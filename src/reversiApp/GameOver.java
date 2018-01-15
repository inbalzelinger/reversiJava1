package reversiApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class GameOver implements Initializable{

    @FXML Label XScore;
    @FXML Label OScore;
    @FXML Label winner;



    public GameOver(Integer XScore , Integer YScore) {
        ;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void returnToMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("menuStyle.css");
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
