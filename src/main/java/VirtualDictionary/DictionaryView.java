package VirtualDictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        Button button1 = new Button("Search");
        TextField type1 = new TextField();
        TextArea description = new TextArea();
        TextField type2 = new TextField();
        TextArea textArea = new TextArea();
        Button button2 = new Button("Add");

        type1.setPromptText("Type here");
        description.setPromptText("Description");
        description.setEditable(false);
        type2.setPromptText("Type here");
        textArea.setPromptText("Type description gere");

        stage.setTitle("Dictionary");

        pane.setMargin(type1, new Insets(10));
        pane.setMargin(button1, new Insets(10));
        pane.setMargin(description, new Insets(50));
        pane.setMargin(button2, new Insets(10));
        pane.setMargin(type2, new Insets(10));
        pane.setMargin(textArea, new Insets(10));

        pane.getChildren().add(type1);
        pane.getChildren().add(button1);
        pane.getChildren().add(description);
        pane.getChildren().add(type2);
        pane.getChildren().add(button2);
        pane.getChildren().add(textArea);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String searchText = type1.getText();
                String meaning = controller.dictionarySearch(searchText);
                description.setText(meaning);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String word = type2.getText();
                String meaning = textArea.getText();
                String text = controller.dictionaryAdd(word, meaning);
                description.setText(text);
            }
        });
    }

    public void init() {
        controller = new DictionaryController(this);
    }
}
