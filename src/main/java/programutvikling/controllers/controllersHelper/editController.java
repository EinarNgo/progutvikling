package programutvikling.controllers.controllersHelper;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.MainApp;
import programutvikling.base.Person;
import programutvikling.controllers.mainController;

public class editController {

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
    private void editKunde() {
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
