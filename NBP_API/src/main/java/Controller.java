import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Controller {

    @FXML
    ChoiceBox okres, waluta1, waluta2;

    @FXML
    Label label;

    @FXML
    LineChart chartPeriod;

    @FXML
    NumberAxis numberAxis, numberAxis2;


    public void iloscSesji() {
        int increase = new NumberOfSessionsIncrease().calculate(CurrencySymbols.valueOf(waluta1.getValue().toString()), Periods.valueOf(okres.getValue().toString()));
        int stable = new NumberOfSessionsStable().calculate(CurrencySymbols.valueOf(waluta1.getValue().toString()), Periods.valueOf(okres.getValue().toString()));
        int decrease = new NumberOfSessionsDecrease().calculate(CurrencySymbols.valueOf(waluta1.getValue().toString()), Periods.valueOf(okres.getValue().toString()));
        String labelText = "Ilość sesji wzrostowych: " + increase + "\n";
        labelText += "Ilość sesji bez zmian: " + stable + "\n";
        labelText += "Ilość sesji spadkowych: " + decrease + "\n";
        label.setText(labelText);
    }

    public void miaryStatystyczne() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(String.valueOf(Periods.valueOf(okres.getValue().toString())), formatter);

        CurrencyData currencyData = new CurrencyData(waluta1.getValue().toString(), date, now);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(currencyData);
        String labelText = "Mediana: " + statisticalMeasures.getMedian() + "\n";
        labelText += "Dominanta: " + statisticalMeasures.getDominant() + "\n";
        labelText += "Odchylenie standardowe: " + statisticalMeasures.getStandardDeviation() + "\n";
        labelText += "Współczynnik zmienności: " + statisticalMeasures.getCoefficient() + "\n";
        label.setText(labelText);
    }

    public void zmianyOkresowe() throws Exception {
        Periods periodLastMonth = Periods.PREV_MONTH;
        Periods periodLastQuater = Periods.LAST_QUARTER;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateLastMonth = LocalDate.parse(periodLastMonth.toString(), formatter);
        LocalDate dateLastQuater = LocalDate.parse(periodLastQuater.toString(), formatter);
        CurrencyData currencyDataLastMonth = new CurrencyData(CurrencySymbols.EUR.toString(), CurrencySymbols.USD.toString(), dateLastMonth, dateLastMonth.plusMonths(1));
        CurrencyData currencyDataLastQuater = new CurrencyData(CurrencySymbols.EUR.toString(), CurrencySymbols.USD.toString(), dateLastQuater, dateLastQuater.plusMonths(3));
        ChangesDistributor changesDistributorLastMonth = new ChangesDistributor(currencyDataLastMonth);
        ChangesDistributor changesDistributorLastQuater = new ChangesDistributor(currencyDataLastQuater);
        XYChart.Series seriesQuarter = new XYChart.Series();
        XYChart.Series seriesMonth = new XYChart.Series();
        seriesQuarter.setName("Last Quarter");
        seriesMonth.setName("Last Month");
        numberAxis.setAutoRanging(true);
        List<Double> lastQuarterChanges = changesDistributorLastQuater.getChanges();
        List<Double> lastMonthChanges = changesDistributorLastMonth.getChanges();
        System.out.println(lastQuarterChanges.size());
        Map<Integer, Double> changesQuarterMap = new TreeMap<>();
        for (int i = 1; i < lastQuarterChanges.size(); i++) {
            changesQuarterMap.put(i, lastQuarterChanges.get(i));
        }
        for (Map.Entry<Integer, Double> entry : changesQuarterMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            seriesQuarter.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }
        Map<Integer, Double> changesMonthMap = new TreeMap<>();
        for (int i = 1; i < lastMonthChanges.size(); i++) {
            changesMonthMap.put(i, lastQuarterChanges.get(i));
        }
        for (Map.Entry<Integer, Double> entry : changesMonthMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            seriesMonth.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }
        chartPeriod.getData().addAll(seriesQuarter, seriesMonth);

    }
}
