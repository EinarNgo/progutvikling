package programutvikling.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import programutvikling.base.Person;
import programutvikling.controllers.controllersHelper.editController;

import java.io.IOException;

public class mainController {

    @FXML
    private TableView<Person> tblPerson;
    @FXML
    private TableColumn<Person, String> ColumnNavn;
    @FXML
    private TableColumn<Person, String> ColumnForsikring;
    @FXML
    private TextField txtNavn,txtAdresse,txtPostkode,txtForsikring;
    @FXML
    private DatePicker txtDato;

    private ObservableList<Person> pData = FXCollections.observableArrayList();;

    public ObservableList<Person> getpData() {
        return pData;
    }

    public mainController() {
        // Add some sample data.

        pData.add(new Person("Hans","Hagatjernveien","30501","102120121","10.10.191"));
        pData.add(new Person("Hans1","Hagatjernveien1","30502","102120122","10.10.192"));
        pData.add(new Person("Hans2","Hagatjernveien2","30503","102120123","10.10.193"));
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Setter opp kolonne
        ColumnNavn.setCellValueFactory(cellData -> cellData.getValue().navnProperty());
        ColumnForsikring.setCellValueFactory(cellData -> cellData.getValue().forsikringProperty());

        // Clear person details.
        showPerson(null);

        // Listen for selection changes and show the person details when changed.
        tblPerson.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPerson(newValue));

        tblPerson.setItems(pData);

    }

    private void showPerson(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            txtNavn.setText(person.getNavn());
            txtAdresse.setText(person.getAdresse());
            txtPostkode.setText(person.getPostkode());
            txtForsikring.setText(person.getForsikring());
        } else {
            // Person is null, remove all the text.
            txtNavn.setText("");
            txtAdresse.setText("");
            txtPostkode.setText("");
            txtForsikring.setText("");
        }
    }

    @FXML
    private void slettKunde() {
        int valgtIndex = tblPerson.getSelectionModel().getSelectedIndex();
        if (valgtIndex >=0) {
            tblPerson.getItems().remove(valgtIndex);
        }
    }

    @FXML
    private void registrerKunde() {
        launchRegistrerPersonScene();
    }

    private void launchRegistrerPersonScene() {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("/programutvikling/controllers/registerKundeScene.fxml").openStream());

        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }

        Scene scene = new Scene(root);
        // add CSS etc. should be here
        Stage editPersonStage = new Stage();
        editPersonStage.setTitle("Registrer person");
        editPersonStage.setScene(scene);

        editPersonStage.initOwner(txtNavn.getScene().getWindow());
        editPersonStage.initModality(Modality.WINDOW_MODAL);
        editPersonStage.show();
    }

    @FXML
    private void redigerKunde() {
        launchRedigerPersonScene();
    }

    private void launchRedigerPersonScene() {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("/programutvikling/controllers/editKundeScene.fxml").openStream());

            // Får tak i controlleren og overfører referanse til person-objektet
            editController controller = fxmlLoader.getController();
            controller.setPerson(tblPerson.getSelectionModel().getSelectedItem());
        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }

        Scene scene = new Scene(root);
        // add CSS etc. should be here
        Stage editPersonStage = new Stage();
        editPersonStage.setTitle("Endre person");
        editPersonStage.setScene(scene);

        editPersonStage.initOwner(txtNavn.getScene().getWindow());
        editPersonStage.initModality(Modality.WINDOW_MODAL);
        editPersonStage.show();
    }



    private boolean isInputTrue() {
        String errorMsg = "";

        if (txtNavn.getText() == null || txtNavn.getText().length() < 2) {
            errorMsg += "Navnet er ugyldig \n";
        }

        if (txtAdresse.getText() == null || txtAdresse.getText().length() < 2) {
            errorMsg += "Adressen er ugyldig \n";
        }

        if (txtPostkode.getText() == null || txtPostkode.getText().length() != 4 ) {
            errorMsg += "Postkode er ugyldig \n";
        }

        if (txtForsikring.getText() == null || txtForsikring.getText().length() !=8) {
            errorMsg += "Forsikringskode er ugyldig eller feil \n";
        }

        //dato

        //ubetalt erstaning i integer

        //forsikring - vent

        if (errorMsg.length() == 0) {
            return true;

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMsg);

            alert.showAndWait();

            return false;
        }

    }
}
