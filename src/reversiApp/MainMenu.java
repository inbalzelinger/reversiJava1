package reversiApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {
    @FXML
    private HBox root;




    private int[][] maze = {
            {0,1,0,1,0,0,0,1,0,0,0},
            {0,1,0,1,0,0,0,1,0,0,0}
    };
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ;
    }



}
