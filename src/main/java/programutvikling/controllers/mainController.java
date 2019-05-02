package programutvikling.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import programutvikling.MainApp;
import programutvikling.base.Person;
import programutvikling.controllers.helpers.applicationCleaner;

public class mainController {

    private Person nyPerson;
    private applicationCleaner clean;

    @FXML
    private TableView<Person> tblPerson;
    @FXML
    private TableColumn<Person, String> ColumnNavn;
    @FXML
    private TableColumn<Person, String> ColumnForsikring;
    @FXML
    private Button btnRegistrer;
    @FXML
    private TextField txtNavn,txtAdresse,txtPostkode,txtForsikring;
    @FXML
    private DatePicker txtDato;

    private MainApp mainApp;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public mainController() {
        // Add some sample data.
        personData.add(new Person("Hans","Hagatjernveien","30501","102120121","10.10.191"));
        personData.add(new Person("Hans1","Hagatjernveien1","30502","102120122","10.10.192"));
        personData.add(new Person("Hans2","Hagatjernveien2","30503","102120123","10.10.193"));
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

        //Legger til data i kolonne
        tblPerson.setItems(personData);
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
    private void registrerKunde() {
        personData.add(new Person(txtNavn.getText(),txtAdresse.getText(),txtPostkode.getText(),txtForsikring.getText(),"Dato"));

        clean.clearScreen(txtNavn,txtAdresse,txtPostkode,txtForsikring);

    }

    @FXML
    private void slettKunde() {
        int valgtIndex = tblPerson.getSelectionModel().getSelectedIndex();
        if (valgtIndex >=0) {
            tblPerson.getItems().remove(valgtIndex);
        }
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
