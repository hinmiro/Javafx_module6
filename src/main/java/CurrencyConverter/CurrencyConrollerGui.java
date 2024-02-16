package CurrencyConverter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CurrencyConrollerGui extends Application {
    private ListView<String> targetList;
    private ListView<String> sourceList;
    private Controller controller;


    @Override
    public void start(Stage stage) throws Exception {
        this.controller = new Controller(this);
        this.sourceList = new ListView<String>();
        this.targetList = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("EUR", "USD", "AUD", "CHF", "GBP", "JPY", "NOK", "SEK", "THB");
        sourceList.setItems(items);
        targetList.setItems(items);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        AnchorPane layout = new AnchorPane();
        GridPane layout1 = new GridPane();
        Button button1 = new Button("Convert");
        Button button2 = new Button("Clear");
        TextField source = new TextField();
        Label sourceLabel = new Label();
        Label target = new Label();
        TextField targetLabel = new TextField();
        Label sourceCurrencyLabel = new Label();
        Label targetCurrencyLabel = new Label();

        source.setPromptText("Type amount");
        source.setPrefWidth(150);

        sourceLabel.setText("Amount to be converted:");
        sourceLabel.setPrefWidth(150);

        target.setText("Converted amount:");
        target.setPrefWidth(150);

        targetLabel.setEditable(false);
        targetLabel.setPromptText("Amount");
        targetLabel.setPrefWidth(150);

        sourceCurrencyLabel.setText("Select your currency:");
        sourceCurrencyLabel.setPrefWidth(150);

        targetCurrencyLabel.setText("Select target currency:");
        targetCurrencyLabel.setPrefWidth(150);

        sourceList.setPrefHeight(70);

        targetList.setPrefHeight(70);


        layout1.setHgap(10);
        layout1.add(sourceLabel, 0, 0);
        layout1.add(source, 1, 0);
        layout1.add(sourceCurrencyLabel, 0, 2);
        layout1.add(sourceList, 1, 2);
        layout1.add(targetCurrencyLabel, 0, 6);
        layout1.add(targetList, 1, 6);
        layout1.add(target, 6, 0);
        layout1.add(targetLabel, 6, 1);
        hBox.getChildren().addAll(button2, button1);

        layout.getChildren().addAll(layout1, hBox);


        AnchorPane.setBottomAnchor(hBox, 10.0);
        AnchorPane.setRightAnchor(hBox, 10.0);

        layout.setPrefSize(750, 200);

        Scene view = new Scene(layout);

        //Added button color
        view.getStylesheets().add("style.css");

        stage.setScene(view);
        stage.show();

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sourceSelection = sourceList.getSelectionModel().getSelectedItem();
                String targetSelection = targetList.getSelectionModel().getSelectedItem();
                try {
                    String amountText = source.getText();
                    if (amountText.contains(","))
                        amountText = amountText.replace(",", ".");
                    double amount = Double.parseDouble(amountText);
                    float conversion = (float) controller.convert(amount, sourceSelection, targetSelection);
                    targetLabel.setText(String.format("%.2f", conversion));
                } catch (NumberFormatException e) {
                    targetLabel.setText("Cannot convert that");
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sourceList.getSelectionModel().clearSelection();
                targetList.getSelectionModel().clearSelection();
                source.clear();
                targetLabel.clear();
            }
        });
    }
}
