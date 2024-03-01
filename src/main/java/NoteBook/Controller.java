package NoteBook;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private AnchorPane pane;
    @FXML
    private TextArea noteArea;
    @FXML
    private TextField titleField;
    @FXML
    private ListView<String> display;


    public void submitNote() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.now();

        String title = titleField.getText();
        String note = noteArea.getText();
        display.getItems().add(date.format(format) + "\t" + title + ": " + note);
        titleField.clear();
        noteArea.clear();
    }

    public void removeNote() {
        display.getItems().remove(display.getSelectionModel().getSelectedItem());
    }

    public static void main(String[] args) {
        NoteBook.launch(NoteBook.class);
    }

}
