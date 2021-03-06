import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        primaryStage.setTitle("NBP API");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
    //testComment

    public static void main(String[] args) {
        launch(args);
    }

}
