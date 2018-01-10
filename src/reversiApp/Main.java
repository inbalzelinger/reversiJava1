package reversiApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            HBox root = (HBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root , 520 , 440);
         //   scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("reversi Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
