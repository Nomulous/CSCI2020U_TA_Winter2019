package lab05_inclass_wednesday;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<PetRecord> pets;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage ps) {
        ps.setTitle("Lab05 Pet Records");

        BorderPane bp = new BorderPane();

        TableColumn<PetRecord, String> nc = new TableColumn<>("Name");
        nc.setPrefWidth(100);
        nc.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PetRecord, String> tc = new TableColumn<>("Type");
        tc.setPrefWidth(100);
        tc.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<PetRecord, String> ac = new TableColumn<>("Age");
        ac.setPrefWidth(100);
        ac.setCellValueFactory( new PropertyValueFactory<>("age"));

        this.pets = new TableView<>();
        this.pets.getColumns().add(nc);
        this.pets.getColumns().add(tc);
        this.pets.getColumns().add(ac);

        bp.setCenter(this.pets);

        Scene scene = new Scene(bp, 300, 300);
        ps.setScene(scene);
        ps.show();
        this.pets.setItems(DataSource.getAllPets());
    }
}
