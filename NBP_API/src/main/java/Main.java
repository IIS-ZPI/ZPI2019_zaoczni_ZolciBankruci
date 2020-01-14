import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        CurrencySymbols currencySymbol = (CurrencySymbols.USD);

        CurrencyData result1 = new CurrencyData(currencySymbol.toString(), 3);
        System.out.println(result1.getRates());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse("2020-01-03", formatter);
        LocalDate date2 = LocalDate.parse("2020-01-03", formatter);

        CurrencyData result2 = new CurrencyData(currencySymbol.toString(), date1, date2);
        System.out.println(result2.getRates());
    }
}
