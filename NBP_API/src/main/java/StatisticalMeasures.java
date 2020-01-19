import java.util.*;

public class StatisticalMeasures {
    private CurrencyData currencyData;

    StatisticalMeasures(CurrencyData currencyData) {
        this.currencyData = currencyData;
    }

    public double getMedian(){
        double median;
        ArrayList<Double> rates = currencyData.getRates();
        Collections.sort(rates);
        if (rates.size() % 2 == 0) {
            median = (rates.get(rates.size() / 2) + rates.get(rates.size() / 2 - 1)) / 2;
        } else {
            median = rates.get(rates.size() / 2);
        }
        return median;
    }

    public double getDominant(){
        ArrayList<Double> rates = currencyData.getRates();
        double maxValue = 0;
        int maxCount = 0;
        for (int i = 0; i < rates.size(); ++i) {
            int count = 0;
            for (Double rate : rates) {
                if (rate.equals(rates.get(i))) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = rates.get(i);
            }
        }
        return maxValue;
    }

    public double getCoefficient(){
        double mean = getMean();
        double standardDeviation = getStandardDeviation();
        return standardDeviation/mean;
    }

    private double getMean() {
        double sum = 0.0;
        int length = currencyData.getRates().size();
        for(int i = 0; i <  currencyData.getRates().size(); i++) {
            sum += currencyData.getRates().get(i);
        }
        return sum/length;
    }
    public double getStandardDeviation(){
        double mean = getMean();
        double standardDeviation = 0;
        for(int i = 0; i <  currencyData.getRates().size(); i++) {
            standardDeviation += Math.pow(currencyData.getRates().get(i) - mean, 2);
        }
        return Math.sqrt(standardDeviation/currencyData.getRates().size());
    }


}
