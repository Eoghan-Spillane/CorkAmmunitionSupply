package View;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application{

        public void start(Stage primaryStage) throws Exception{
            //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Parent Kinsale = FXMLLoader.load(getClass().getResource("Kinsale Gui.fxml"));
            Parent Youghal = FXMLLoader.load(getClass().getResource("Youghal Gui.fxml"));

            Stage secondaryStage = new Stage();

            primaryStage.setTitle("Kinsale Outpost");
            secondaryStage.setTitle("Youghal Outpost");

            secondaryStage.setScene(new Scene(Youghal, 300, 200));
            primaryStage.setScene(new Scene(Kinsale, 300, 200));

            //primaryStage.setScene();
            primaryStage.show();
            secondaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

}