package programutvikling.controllers.controllersHelper;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.base.Person;

public class registerController {

    private Person Person;

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
        Person = new Person(txtNavn.getText(),txtAdresse.getText(),txtPostkode.getText(),txtForsikring.getText(),"");

        closeWindow();
    }

    private void closeWindow() {
        Stage myStage = (Stage) txtNavn.getScene().getWindow();
        myStage.close();
    }
}
