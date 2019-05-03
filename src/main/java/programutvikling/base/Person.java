package programutvikling.base;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    public final StringProperty navn;
    public final StringProperty adresse;
    public final StringProperty postkode;
    public final StringProperty forsikring;
    public final StringProperty dato;

    public Person() {
        this(null,null,null,null,null);
    }

    public Person(String navn, String adresse, String postkode, String forsikring, String dato) {


        this.navn = new SimpleStringProperty(navn);
        this.adresse = new SimpleStringProperty(adresse);
        this.postkode = new SimpleStringProperty(postkode);
        this.forsikring = new SimpleStringProperty(forsikring);
        this.dato = new SimpleStringProperty(dato);
    }


    public String getNavn() {
        return navn.get();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public StringProperty navnProperty() {
        return navn;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getPostkode() {
        return postkode.get();
    }

    public StringProperty postkodeProperty() {
        return postkode;
    }

    public void setPostkode(String postkode) {
        this.postkode.set(postkode);
    }

    public String getForsikring() {
        return forsikring.get();
    }

    public StringProperty forsikringProperty() {
        return forsikring;
    }

    public void setForsikring(String forsikring) {
        this.forsikring.set(forsikring);
    }

    public String getDato() {
        return dato.get();
    }

    public StringProperty datoProperty() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato.set(dato);
    }

}
