import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class NumberOfSessionsStableTest {

    private CompareSessions stable;

    @Before
    public void setUp() {
        stable = new NumberOfSessionsStable() {

            public LocalDate getDates(Periods period) {
                return LocalDate.of(2020, 01, 7);
            }
        };
    }

    @Test
    public void calculate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date2 = LocalDate.parse("2020-01-14", formatter);
        stable.now = date2;
        assertEquals(0, stable.calculate(CurrencySymbols.USD, Periods.ONE_WEEK));
    }
}