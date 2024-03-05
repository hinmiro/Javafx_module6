package VirtualPet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Food {
    private double coordY, coordX;
    private Image image;
    private ImageView imageView;

    public Food(Image image, double coordX, double coordY) {
        this.image = image;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return  coordY;
    }

    public Image getImage() {
        return image;
    }
}
