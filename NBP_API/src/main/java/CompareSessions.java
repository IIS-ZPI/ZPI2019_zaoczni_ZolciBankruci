import java.time.LocalDate;

public abstract class CompareSessions {

    CurrencyData currencyData;
    LocalDate now = LocalDate.now();
    LocalDate date1;
    int arraySize;
    int result = 0;
    Double firstNumber;

    public abstract int calculate(CurrencySymbols currency, Periods period);

    public LocalDate getDates(Periods period) {

        if (period == Periods.ONE_WEEK) {
            return now.minusWeeks(1);
        }
        else if (period == Periods.TWO_WEEKS) {
            return now.minusWeeks(2);
        }
        else if (period == Periods.ONE_MONTH) {
            return now.minusMonths(1);
        }
        else if (period == Periods.THREE_MONTHS) {
            return now.minusMonths(3);
        }
        else if (period == Periods.SIX_MONTHS) {
            return now.minusMonths(6);
        }
        else if (period == Periods.ONE_YEAR) {
            return now.minusYears(1);
        }
        else {
            return null;
        }
    };
}