package VirtualPet;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Pane pane;
    @FXML
    private ImageView pet;
    @FXML
    private ToggleButton startButton;

    @FXML
    public void initialize() {
    }


    public void startStop() {
        if (startButton.isSelected()) {
            startButton.setText("Stop");
            pane.setOnMouseMoved(this::petFollow);
        } else {
            pane.setOnMouseMoved(null);
            pet.setLayoutY(pane.getHeight()/2);
            pet.setLayoutX(pane.getWidth()/2);
        }
    }

    public static void main(String[] args) {
        PetGui.launch(PetGui.class);
    }

    public void petFollow(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getSceneX();
        double mouseY = mouseEvent.getSceneY();
        double petX = pet.getLayoutX() + pet.getFitWidth() / 2;
        double petY = pet.getLayoutY() + pet.getFitHeight() / 2;

        double distance = Math.sqrt(Math.pow(mouseX - petX, 2) + Math.pow(mouseY - petY, 2));

        if (distance > 5) {
            double newX = petX + (mouseX - petX) * 0.01;
            double newY = petY + (mouseY - petY) * 0.01;
            pet.setLayoutX(newX - pet.getFitWidth() / 2);
            pet.setLayoutY(newY - pet.getFitHeight() / 2);
        }
    }
}
