package shapeGallery;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

public class MyCircle extends MyShape {

    public MyCircle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        Circle circle = new Circle(x, y, 30, Color.DODGERBLUE);
        pane.getChildren().add(circle);
    }

    @Override
    public void highlight(Pane pane) {
        Circle circle = new Circle(x, y, 30, Color.DODGERBLUE);
        circle.setStroke(Color.RED);  // Add a red border for highlighting
        circle.setStrokeWidth(3);
        pane.getChildren().add(circle);
    }
}
