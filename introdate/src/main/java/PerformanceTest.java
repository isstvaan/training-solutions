import java.time.*;

public class PerformanceTest {
    public static void main(String[] args) {
        Performance performance = new Performance(LocalDate.now(), "Prodigy", LocalTime.now(), LocalTime.now().plusMinutes(90));
        System.out.println(performance.getInfo());
    }
}
