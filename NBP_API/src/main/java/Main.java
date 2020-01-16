import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        CurrencySymbols currencySymbol = (CurrencySymbols.USD);

        CurrencyData result1 = new CurrencyData(currencySymbol.toString(), 3);
        System.out.println(result1.getRates());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse("2020-01-07", formatter);
        LocalDate date2 = LocalDate.parse("2020-01-14", formatter);

        CurrencyData result2 = new CurrencyData(currencySymbol.toString(), date1, date2);
        System.out.println(result2.getRates());

        int increase = new NumberOfSessionsIncrease().calculate(CurrencySymbols.USD, Periods.ONE_WEEK);
        System.out.println(increase);
        int stable = new NumberOfSessionsStable().calculate(CurrencySymbols.USD, Periods.ONE_WEEK);
        System.out.println(stable);
        int decrease = new NumberOfSessionsDecrease().calculate(CurrencySymbols.USD, Periods.ONE_WEEK);
        System.out.println(decrease);
    }
}
