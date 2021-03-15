package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CovidDao {
    MariaDbDataSource dataSource;

    public CovidDao() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
    }

    public String getCityForZip(String zip) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("select city from city_zip where zip = ?");) {
            stmt.setString(1, zip);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("city");
                    return name;
                }
                return null;
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by select", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    public void setCitizen(Citizen citizen) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("REPLACE INTO `citizens`\n" +
                                "SET `citizen_name` = ?,\n" +
                                "`zip` = ?,\n" +
                                "`age` = ?,\n" +
                                "`email` = ?,\n" +
                                "`taj` = ?,\n" +
                                "`number_of_vaccination` = ?,\n" +
                                "`last_vaccination` = ?;")) {
            stmt.setString(1, citizen.getName());
            stmt.setString(2, citizen.getZip());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getTaj());
            stmt.setInt(6, citizen.getNumberOfVaccination());
            if (citizen.getLastVaccination() != null) {
                stmt.setString(7, citizen.getLastVaccination().toString());
            } else {
                stmt.setNull(7, 0);
            }
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void setCitizenVaccination(Citizen citizen, String note, String status, String vaccinationType) {
        try (
                Connection conn = dataSource.getConnection();
        ) {
            PreparedStatement stmt =
                    conn.prepareStatement("UPDATE `citizens`\n" +
                            "SET `citizen_name` = ?,\n" +
                            "`zip` = ?,\n" +
                            "`age` = ?,\n" +
                            "`email` = ?,\n" +
                            "`taj` = ?,\n" +
                            "`number_of_vaccination` = ?,\n" +
                            "`last_vaccination` = ?\n" +
                            "WHERE row_id= ?;", Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);

            stmt.setString(1, citizen.getName());
            stmt.setString(2, citizen.getZip());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getTaj());
            stmt.setInt(6, citizen.getNumberOfVaccination());
            if (citizen.getLastVaccination() != null) {
                stmt.setTimestamp(7, Timestamp.valueOf(citizen.getLastVaccination()));
            } else {
                stmt.setNull(7, 0);
            }
            stmt.setLong(8, citizen.getId());
            stmt.executeUpdate();

            //  long clientID = executeAndGetGeneratedKey(stmt);

            stmt = conn.prepareStatement("INSERT INTO vaccinations(citizen_id,vaccination_date,status,note,vaccination_type) VALUES (?,?,?,?,?);");

            stmt.setLong(1, citizen.getId());
            stmt.setTimestamp(2, Timestamp.valueOf(citizen.getLastVaccination()));
            stmt.setString(3, status);
            stmt.setString(4, note);
            stmt.setString(5, vaccinationType);
            stmt.executeQuery();
            conn.commit();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void insertCitizens(List<Citizen> citizens) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into citizens(citizen_name,zip,age,email,taj,number_of_vaccination) values (?,?,?,?,?,?)")) {
            try {
                conn.setAutoCommit(false);
                for (Citizen item : citizens) {
                    stmt.setString(1, item.getName());
                    stmt.setString(2, item.getZip());
                    stmt.setInt(3, item.getAge());
                    stmt.setString(4, item.getEmail());
                    stmt.setString(5, item.getTaj());
                    stmt.setInt(6, item.getNumberOfVaccination());
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (SQLException se) {
                conn.rollback();
                throw new IllegalStateException("Cannot insert", se);
            }
        } catch (SQLException se) {

            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public List<Citizen> getCitizensForFullReport() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM \n" +
                             "(SELECT citizen_name,zip,age,email,taj, (@num:=if(@group = `zip`, @num +1, if(@group := `zip`, 1, 1))) row_number FROM citizens CROSS JOIN (SELECT @num:=0, @group:= NULL) c\n" +
                             " WHERE (number_of_vaccination = 0 OR (number_of_vaccination < 2 AND last_vaccination IS NOT NULL AND DATEDIFF(NOW(),last_vaccination) >15 )) ORDER BY `zip`, Age DESC, citizen_name) AS x\n" +
                             " WHERE x.row_number <= 16;"
             );) {

            List<Citizen> citizens = new ArrayList<>();

            while (rs.next()) {
                citizens.add(getCitizenFromResultSet(rs));
            }
            return citizens;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    public List<Citizen> getCitizensForReport(String zip) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT citizen_name,zip,age,email,taj FROM citizens" +
                             " WHERE (zip = ? AND (number_of_vaccination = 0 OR number_of_vaccination < 2 AND last_vaccination IS NOT NULL AND DATEDIFF(NOW(),last_vaccination) >15 ))" +
                             " ORDER BY Age DESC, citizen_name LIMIT 16"
             );) {
            stmt.setString(1, zip);
            ResultSet rs = stmt.executeQuery();
            List<Citizen> citizens = new ArrayList<>();

            while (rs.next()) {
                citizens.add(getCitizenFromResultSet(rs));
            }
            return citizens;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }


    public List<String> getCitizensForReport2() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \n" +
                     "(\n" +
                     "SELECT citizen_name,zip,age,\n" +
                     " (@num:=if(@group = `zip`, @num +1, if(@group := `zip`, 1, 1))) row_number\n" +
                     "FROM citizens CROSS JOIN (SELECT @num:=0, @group:= NULL) c\n" +
                     "ORDER BY `zip`, Age DESC, citizen_name\n" +
                     ") AS x\n" +
                     "WHERE x.row_number <= 16;");) {
            List<String> citizenDatasForReport = new ArrayList<>();
            //Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám
            while (rs.next()) {
                citizenDatasForReport.add(
                        rs.getString("citizen_name") +
                                rs.getString("zip") +
                                rs.getInt("age") +
                                rs.getString("email") +
                                rs.getString("taj"));
            }
            return citizenDatasForReport;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    public Citizen getCitizenWithTAJ(String taj) {
        taj = taj.trim();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM citizens LEFT JOIN vaccinations ON citizens.row_id=vaccinations.citizen_id AND vaccinations.`status`=\"OK\" WHERE citizens.taj=? ORDER BY vaccinations.vaccination_date DESC");) {
            stmt.setString(1, taj);

            return getCitizenFromStatement(taj, stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    private Citizen getCitizenFromStatement(String taj, PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return getCitizenFromResultSet(rs);
            }
            throw new IllegalArgumentException("People not found, TAJ: " + taj);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    private Citizen getCitizenFromResultSet(ResultSet rs) throws SQLException {
        return new Citizen(
                rs.getLong("citizens.row_id"),
                rs.getString("citizens.citizen_name"),
                rs.getString("citizens.zip"),
                rs.getInt("citizens.age"),
                rs.getString("citizens.email"),
                rs.getString("citizens.taj"),
                rs.getInt("citizens.number_of_vaccination"),
                rs.getTimestamp("citizens.last_vaccination") != null ? rs.getTimestamp("citizens.last_vaccination").toLocalDateTime() : null,
                rs.getString("vaccinations.vaccination_type"));
    }

    public List<Citizen> getCitizens() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM citizens LEFT JOIN vaccinations ON citizens.row_id=vaccinations.citizen_id AND vaccinations.`status`=\"OK\" ORDER BY vaccinations.vaccination_date DESC");) {
            List<Citizen> citizens = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    citizens.add(getCitizenFromResultSet(rs));
                }
                return citizens;
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by select", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    public List<String> getVaccinatedCitizens() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("SELECT zip ,SUM(CASE WHEN citizens.number_of_vaccination=0 THEN 1 ELSE 0 END) AS BEOLTATLAN, SUM(CASE WHEN citizens.number_of_vaccination=1 THEN 1 ELSE 0 END) AS BEOLTOTT,SUM(CASE WHEN citizens.number_of_vaccination=2 THEN 1 ELSE 0 END) AS BEOLTOTT2 FROM citizens GROUP BY zip");) {
            List<String> citizenDatasForReport = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(rs.getString("zip")).append(";");
                    stringBuilder.append(rs.getString("BEOLTATLAN")).append(";");
                    stringBuilder.append(rs.getString("BEOLTOTT")).append(";");
                    stringBuilder.append(rs.getString("BEOLTOTT2")).append(";");
                    citizenDatasForReport.add(stringBuilder.toString());
                }
                return citizenDatasForReport;
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by select", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }
}
