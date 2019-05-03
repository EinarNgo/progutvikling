package programutvikling.controllers.controllersHelper;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.base.Person;
import programutvikling.controllers.helpers.inputChecker;
import programutvikling.controllers.mainController;

public class registerController {

    private Person Person;
    private inputChecker iC;

    @FXML
    private TextField txtNavn,txtAdresse,txtPostkode,txtForsikring;

    public void setPerson(Person Person) {
        this.Person = Person;

        txtNavn.setText(Person.getNavn());
        txtAdresse.setText(Person.getAdresse());
        txtPostkode.setText(Person.getPostkode());
        txtForsikring.setText(Person.getForsikring());
    }

    @FXML
    private void registerKunde() {

        Person.setNavn(txtNavn.getText());
        Person.setAdresse(txtAdresse.getText());
        Person.setPostkode(txtPostkode.getText());
        Person.setForsikring(txtForsikring.getText());
        closeWindow();

    }

    private void closeWindow() {
        Stage myStage = (Stage) txtNavn.getScene().getWindow();
        myStage.close();
    }
}
