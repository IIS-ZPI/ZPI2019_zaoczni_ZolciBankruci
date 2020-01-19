
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Controller {

    @FXML
    ChoiceBox okres, waluta1, waluta2;

    @FXML
    Label label;

    @FXML
    LineChart chartMonth;


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
        label.setText(changesDistributorLastMonth.getChanges().toString());
        label.setText(changesDistributorLastQuater.getChanges().toString());
    }
}
