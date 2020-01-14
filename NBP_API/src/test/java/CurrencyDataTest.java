import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CurrencyDataTest {

    @Test
    public void getRates() {

        CurrencySymbols currencySymbol = (CurrencySymbols.USD);

        CurrencyData result1 = new CurrencyData(currencySymbol.toString(), 3);
        assertEquals(3, result1.getRates().size());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse("2020-01-03", formatter);
        LocalDate date2 = LocalDate.parse("2020-01-03", formatter);

        CurrencyData result2 = new CurrencyData(currencySymbol.toString(), date1, date2);
        assertEquals(3.8213, result2.getRates().get(0), 0);
    }

    @Test
    public void getPairRates() {
        CurrencyData result = new CurrencyData(CurrencySymbols.EUR.toString(), CurrencySymbols.USD.toString(), LocalDate.of(2020, 1, 12), LocalDate.of(2020, 1, 13));
        ArrayList<ArrayList<Double>> arrayLists = new ArrayList<>();
        ArrayList<Double> rates = new ArrayList<>();
        rates.add(4.2353);
        rates.add(3.8101);
        arrayLists.add(rates);
        assertEquals(arrayLists, result.getPairRates());
    }
}