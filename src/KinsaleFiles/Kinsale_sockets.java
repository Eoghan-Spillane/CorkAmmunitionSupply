package KinsaleFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Kinsale_sockets extends Application{

    public void start(Stage primaryStage) throws Exception{
        Parent Kinsale = FXMLLoader.load(getClass().getResource("Kinsale Gui.fxml"));
        primaryStage.setTitle("Kinsale Outpost");
        primaryStage.setScene(new Scene(Kinsale, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
