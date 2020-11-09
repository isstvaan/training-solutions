package csvvalid;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVValidatorTest {
    @Test
    public void filterLinesTest() {
        List<String> lines = List.of(
                "CDR-451;1998;Volvo;red",
                "LAE-119;1966;Trabant;yellow",
                "FKQ-528;2009;Seat",
                "FIX-001;2065;Delorean;silver",
                "ROBIN-1;2003;Ferrari;red",
                "1MYO87;2017;Mitsubishi;blue",
                "FKJ-187;2011;Kia;black"
        );

        List<String> filtered = new CSVValidator().filterLines(lines);

        assertEquals(3, filtered.size());
        assertEquals(List.of(
                "CDR-451;1998;Volvo;red",
                "ROBIN-1;2003;Ferrari;red",
                "FKJ-187;2011;Kia;black"
        ), filtered);

    }
}
