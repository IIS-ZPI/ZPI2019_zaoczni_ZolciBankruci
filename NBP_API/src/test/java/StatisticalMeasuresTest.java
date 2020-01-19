import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StatisticalMeasuresTest {

    @Test
    public void measuresTest() {
        CurrencyData currencyData = new CurrencyData(CurrencySymbols.EUR.toString(), LocalDate.of(2020, 1, 7), LocalDate.of(2020, 1, 13));
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(currencyData);
        assertEquals(4.2459, statisticalMeasures.getMedian(), 0);
        assertEquals(4.2347, statisticalMeasures.getDominant(), 0);
        assertEquals(0.00557795661510557, statisticalMeasures.getStandardDeviation(), 0);
    }
}