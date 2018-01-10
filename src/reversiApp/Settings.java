package reversiApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Settings extends GridPane {
    @FXML
    private ColorPicker player1color;
    @FXML
    private ColorPicker player2color;
    @FXML
    private void initialize() {
        player1color.setValue(Color.BLACK);
        player2color.setValue(Color.WHITE);
    }
    public Settings() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void drew() {
        this.getChildren().clear();
    }

}
