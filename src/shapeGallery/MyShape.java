package shapeGallery;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.text.Text;

public abstract class MyShape {

    protected double x, y;

    public MyShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Pane pane);

    public void animateShape(Pane pane) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(pane);
        transition.setByX(100);  // Move 100 pixels in X direction
        transition.setByY(100);  // Move 100 pixels in Y direction
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setDuration(Duration.seconds(2));
        transition.play();
    }
    public void addLabel(Pane pane, String label) {
        Text text = new Text(x, y + 50, label);  // Position below the shape
        pane.getChildren().add(text);
    }
}
