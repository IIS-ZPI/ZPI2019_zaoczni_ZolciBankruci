import java.util.ArrayList;

public class ChangesDistributor {
    private CurrencyData currencyData;

    ChangesDistributor(CurrencyData currencyData) {
        this.currencyData = currencyData;
    }

    public ArrayList<Double> getChanges() throws Exception {
        ArrayList<ArrayList<Double>> pairRates = currencyData.getPairRates();
        ArrayList<Double> changesList = new ArrayList<>();
        double prevPairMid = 0;
        for(int i = 0; i < pairRates.size(); i++){
            double firstCurrencyMid = pairRates.get(i).get(0);
            double secondCurrencyMid = pairRates.get(i).get(1);
            double pairMid = firstCurrencyMid / secondCurrencyMid;
            if(i == 0){
                changesList.add(pairMid);
            } else {
                double change = pairMid - prevPairMid;
                changesList.add(change);
            }
            prevPairMid = pairMid;
        }
        return changesList;
    }
}
