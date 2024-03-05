package VirtualPet;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.*;

public class PetThread extends Thread {
    private ImageView pet;
    private Pane pane;
    private ToggleButton startButton, followButton;
    private boolean runFlag = true;
    private Image food;
    private double foodH, foodW;
    private ImageView imageView;
    private HashMap<Double, Food> foods;
    private ArrayList<Image> images;
    private Random rand;

    public PetThread(ImageView pet, Pane pane, ToggleButton startButton, ToggleButton followButton) {
        rand = new Random();
        this.pet = pet;
        this.pane = pane;
        this.startButton = startButton;
        this.followButton = followButton;
        foods = new HashMap<>();
        images = new ArrayList<>();
        images.add(new Image("/food1.png"));
        images.add(new Image("/food2.png"));
    }

    @Override
    public void run() {
        while (runFlag) {
        }
    }

    public void moveToCenter() {
        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;

        double petX = pet.getLayoutX() + pet.getFitWidth() / 2;
        double petY = pet.getLayoutY() + pet.getFitHeight() / 2;

        double distance = Math.sqrt(Math.pow(centerX - petX, 2) + Math.pow(centerY - petY, 2));

        while (distance > 5) {
            double speed = Math.max(0.08, distance / 1000);

            double newX = petX + (centerX - petX) * speed;
            double newY = petY + (centerY - petY) * speed;

            pet.setLayoutX(newX - pet.getFitWidth() / 2);
            pet.setLayoutY(newY - pet.getFitHeight() / 2);

            petX = newX;
            petY = newY;

            distance = Math.sqrt(Math.pow(centerX - petX, 2) + Math.pow(centerY - petY, 2));

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void petFollow(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getSceneX();
        double mouseY = mouseEvent.getSceneY();
        double petX = pet.getLayoutX() + pet.getFitWidth() / 2;
        double petY = pet.getLayoutY() + pet.getFitHeight() / 2;

        double distance = Math.sqrt(Math.pow(mouseX - petX, 2) + Math.pow(mouseY - petY, 2));
        double speed = 0.05;

        if (distance > 2) {
            double newX = petX + (mouseX - petX) * speed;
            double newY = petY + (mouseY - petY) * speed;
            pet.setLayoutX(newX - pet.getFitWidth() / 2);
            pet.setLayoutY(newY - pet.getFitHeight() / 2);

        }
        Double foodKeyToRemove = null;
        for (Map.Entry<Double, Food> entry : foods.entrySet()) {
            Food food = entry.getValue();
            if (Math.abs(petX - food.getCoordX()) < 50 && Math.abs(petY - food.getCoordY()) < 50) {
                pane.getChildren().remove(food.getImage());
                foodKeyToRemove = entry.getKey();
                break;
            }
        }
        if (foodKeyToRemove != null) {
            foods.remove(foodKeyToRemove);
        }
    }

    public void feedingTime(double height, double width) {
        Image img = images.get(rand.nextInt(images.size()));
        foods.put(width, new Food(img, width, height));
        imageView = new ImageView(img);
        imageView.setLayoutX(foods.get(width).getCoordX());
        imageView.setLayoutY(foods.get(width).getCoordY());
        this.pane.getChildren().add(imageView);
    }

    public void seize() {
        runFlag = false;
    }
}
