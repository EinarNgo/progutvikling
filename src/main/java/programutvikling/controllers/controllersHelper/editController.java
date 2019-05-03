package programutvikling.controllers.controllersHelper;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.MainApp;
import programutvikling.base.Person;

public class editController {

    private Person minPerson;
    private MainApp mainApp;

    @FXML
    private TextField txtNavn,txtAdresse,txtPostkode,txtForsikring;

    public void setPerson(Person minPerson) {
        this.minPerson = minPerson;

        txtNavn.setText(minPerson.getNavn());
        txtAdresse.setText(minPerson.getAdresse());
        txtPostkode.setText(minPerson.getPostkode());
        txtForsikring.setText(minPerson.getForsikring());
    }

    /*
    @FXML
    private void registrerKunde() {

    }
    */

    /*
    public void editKunde(ObservableList<Person> pData) {

        pData.add(new Person(txtNavn.getText(),txtAdresse.getText(),txtPostkode.getText(),txtForsikring.getText(),""));

        closeWindow();
    }
    */

    private void closeWindow() {
        Stage myStage = (Stage) txtNavn.getScene().getWindow();
        myStage.close();
    }
}
