package reversiApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Observable;

public class Settings extends GridPane {

    ObservableList<String> sizes = FXCollections.observableArrayList("4"  , "6" , "8" , "10" , "12" , "14" , "16" , "18" , "20");
    ObservableList<Symbol> players = FXCollections.observableArrayList(Symbol.X , Symbol.O);

    @FXML
    private ColorPicker player1color;
    @FXML
    private ColorPicker player2color;
    @FXML
    private ChoiceBox size;

    @FXML
    private ChoiceBox firstPlayer;


    @FXML
    private void initialize() {
        player1color.setValue(Color.BLACK);
        player2color.setValue(Color.WHITE);
        size.setItems(sizes);
        firstPlayer.setItems(players);
        size.setValue("8");
        firstPlayer.setValue(Symbol.X);

    }


    @FXML
    private void SaveAdnReturn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("menuStyle.css");
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            PrintWriter writer = new PrintWriter("settings.txt", "UTF-8");
            writer.println(firstPlayer.getValue().toString());
            writer.println(player1color.getValue().toString());
            writer.println(player2color.getValue().toString());
            writer.println(size.getValue().toString());



            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
