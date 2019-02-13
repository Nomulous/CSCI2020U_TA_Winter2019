import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {

    public static ObservableList<PetRecord> getAllPets() {
        ObservableList<PetRecord> records = FXCollections.observableArrayList();


        records.add(new PetRecord("Whiskers", "Cat", "4"));
        records.add(new PetRecord("Felix", "Dog", "2"));
        records.add(new PetRecord("Oscar", "Parrot", "48"));

        return records;
    }
}
