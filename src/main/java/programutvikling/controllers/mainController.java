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
import programutvikling.controllers.controllersHelper.registerController;
import programutvikling.controllers.helpers.inputChecker;

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

    private ObservableList<Person> pData = FXCollections.observableArrayList();

    private inputChecker iC;


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

        update();

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
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(txtNavn.getScene().getWindow());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void registrerKunde() {
        launchRegistrerPersonScene();
    }

    private void launchRegistrerPersonScene() {
        Parent root = null;
        Person tempPerson = new Person();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("/programutvikling/controllers/registerKundeScene.fxml").openStream());


            registerController controller = fxmlLoader.getController();
            controller.setPerson(tempPerson);

            pData.add(tempPerson);

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
        int valgtIndex = tblPerson.getSelectionModel().getSelectedIndex();
        if (valgtIndex >=0) {
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
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(txtNavn.getScene().getWindow());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    public void update() {

        ColumnNavn.setCellValueFactory(cellData -> cellData.getValue().navnProperty());
        ColumnForsikring.setCellValueFactory(cellData -> cellData.getValue().forsikringProperty());
        // Clear person details.
        showPerson(null);

        // Listen for selection changes and show the person details when changed.
        tblPerson.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPerson(newValue));

        tblPerson.setItems(pData);
    }
}
