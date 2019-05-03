package programutvikling;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import programutvikling.base.Person;

public class MainApp extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }


    public MainApp() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));

        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Flere vinduer med JavaFX");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


}
