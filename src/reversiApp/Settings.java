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
    @FXML
    private ColorPicker player1color;
    @FXML
    private ColorPicker player2color;
    @FXML
    private ChoiceBox size;

    @FXML
    private void initialize() {
        File settingsFile = new File("settings.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(settingsFile)));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }

        } catch (Exception e) {
            ;
        }

        player1color.setValue(Color.BLACK);
        player2color.setValue(Color.WHITE);
        size.setItems(sizes);
        size.setValue("8");
    }


    @FXML
    private void SaveAdnReturn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            PrintWriter writer = new PrintWriter("settings.txt", "UTF-8");
            writer.println(player1color.getValue().toString());
            writer.println(player2color.getValue().toString());
            writer.println(size.getValue().toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void drew() {
        this.getChildren().clear(); }

}
