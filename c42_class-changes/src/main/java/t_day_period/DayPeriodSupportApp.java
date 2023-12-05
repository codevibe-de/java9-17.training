package t_day_period;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DayPeriodSupportApp {

    @Test
    void print() {
        var zonedDateTime = ZonedDateTime.now();

        final String dateTimeStr = DateTimeFormatter
                .ofPattern("'Es ist' h 'Uhr' B, zzzz")
//                .localizedBy(Locale.US)
                .format(zonedDateTime);

        System.out.println(dateTimeStr);
    }
}
