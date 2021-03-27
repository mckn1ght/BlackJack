package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Scoruri {


    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("scoruri.fxml"));
        BorderPane layoutScoruri = new BorderPane();
        Scene scenaScoruri = new Scene(layoutScoruri, 500, 480);
        Stage scoruri = new Stage();

        scoruri.setTitle("SCORURI");
        scoruri.setScene(scenaScoruri);
        scoruri.setResizable(false);

        layoutScoruri.setId("scoruri");
        String css = this.getClass().getResource("styles.css").toExternalForm();
        layoutScoruri.getStylesheets().add(css);

        scoruri.setScene(root.getScene());
        scoruri.show();

    }

}