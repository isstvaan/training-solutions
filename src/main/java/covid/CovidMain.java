package covid;

public class CovidMain {
    public static void main(String[] args) {
        CovidDao covidDao = new CovidDao();
        FileHandler fileHandler = new FileHandler();

        Menu menu = new Menu(covidDao, fileHandler);
        menu.startMenu();
    }
}
