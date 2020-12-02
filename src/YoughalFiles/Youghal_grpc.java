package YoughalFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Youghal_grpc extends Application{

    public void start(Stage primaryStage) throws Exception{
        Parent Youghal = FXMLLoader.load(getClass().getResource("Youghal Gui.fxml"));
        primaryStage.setTitle("Youghal Outpost");
        primaryStage.setScene(new Scene(Youghal, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
