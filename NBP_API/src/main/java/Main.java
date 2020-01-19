import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("NBP Zolci Bankruci");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

//        CurrencySymbols currencySymbol = (CurrencySymbols.USD);
//
//        CurrencyData result1 = new CurrencyData(currencySymbol.toString(), 3);
//        System.out.println(result1.getRates());
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date1 = LocalDate.parse("2020-01-03", formatter);
//        LocalDate date2 = LocalDate.parse("2020-01-03", formatter);
//
//        CurrencyData result2 = new CurrencyData(currencySymbol.toString(), date1, date2);
//        System.out.println(result2.getRates());
    }
}
