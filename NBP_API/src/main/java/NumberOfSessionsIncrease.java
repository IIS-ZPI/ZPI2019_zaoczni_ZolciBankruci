public class NumberOfSessionsIncrease extends CompareSessions {

    @Override
    public int calculate(CurrencySymbols currency, Periods period) {

        date1 = getDates(period);
        currencyData = new CurrencyData(currency.toString(), date1, now);
        arraySize = currencyData.getRates().size();

        for (int i = 0; i < arraySize-1; i++) {
            if (currencyData.getRates().get(i) < currencyData.getRates().get(i + 1)) {
                result++;
            }
        }
        return result;
    }
}
