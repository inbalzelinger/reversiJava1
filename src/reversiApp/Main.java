package reversiApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            HBox root = (HBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root , 520 , 440);
            scene.getStylesheets().add("menuStyle.css");
            Image image = new Image("rev.jpg");
            // simple displays ImageView the image as is
            ImageView iv = new ImageView();
            iv.setImage(image);

            iv.setFitWidth(200);
            iv.setFitHeight(400);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);


            Rectangle2D viewportRect = new Rectangle2D(0, 0, 500, 440);
            iv.setViewport(viewportRect);

//            root.getChildren().add(iv);

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
