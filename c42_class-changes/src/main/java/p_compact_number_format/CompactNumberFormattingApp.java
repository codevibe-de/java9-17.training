package p_compact_number_format;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormattingApp {

    @Test
    void formatMultiple() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(
                Locale.GERMANY,
                NumberFormat.Style.SHORT);
        long nmbr = 23;
        for (int i = 0; i < 10; i++) {
            String formattedNmbr = fmt.format(nmbr);
            System.out.println(formattedNmbr);
            nmbr = nmbr * 10;
        }
    }
}
