import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CurrencyDataTest {

    @Test
    public void getRates() {
        CurrencyData result1 = new CurrencyData("USD", 3);
        assertEquals(3, result1.getRates().size());

        CurrencyData result2 = new CurrencyData("USD", "2020-01-03", "2020-01-03");
        assertEquals(3.8213, result2.getRates().get(0));
    }
}