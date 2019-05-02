package programutvikling.controllers.controllersHelper;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import programutvikling.base.Person;

public class editController {

    private Person person;

    @FXML
    private TextField txtNavn,txtAdresse,txtPostkode,txtForsikring;

    public void setPerson(Person person) {
        this.person = person;

        txtNavn.setText(person.getNavn());
        txtAdresse.setText(person.getAdresse());
        txtPostkode.setText(person.getPostkode());
        txtForsikring.setText(person.getForsikring());
    }
}
