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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/programutvikling/mainView.fxml"));
        Parent root = loader.load();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.setTitle("MainApp");
        stage.show();
    }

}
