package VirtualPet;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class Controller {
    private static Random rand;
    @FXML
    private Pane pane;
    @FXML
    private ImageView petImage;
    @FXML
    private ToggleButton startButton;
    private PetThread pet;
    @FXML
    private ToggleButton followButton;
    @FXML
    private Button feedButton;
    @FXML
    private Canvas visualDisplay;

    private double height, width;
    private double foodH, foodW;

    @FXML
    public void initialize() {
        rand = new Random();
        pet = new PetThread(petImage, pane, startButton, followButton);
        followButton.setDisable(true);
        pet.start();
    }


    public void startStop() {
        if (startButton.isSelected()) {
            startButton.setText("Stop");
            followButton.setDisable(false);
        } else {
            startButton.setText("Start");
        }
    }

    public void followToggle() {
        if (followButton.isSelected()) {
            pane.setOnMouseMoved(this::petFollow);
        }
        else {
            pane.setOnMouseMoved(null);
            pet.moveToCenter();
        }
    }


    public void petFollow(MouseEvent mouseEvent) {
        pet.petFollow(mouseEvent);
    }

    public void feed() {

        height = pane.getHeight();
        width = pane.getWidth();
        foodH = rand.nextDouble()*height;
        foodW = rand.nextDouble()*width;
        System.out.println(foodW);
        System.out.println(foodH);
        pet.feedingTime(foodH, foodW);
    }

    public static void main(String[] args) {

        PetGui.launch(PetGui.class);
    }

}
