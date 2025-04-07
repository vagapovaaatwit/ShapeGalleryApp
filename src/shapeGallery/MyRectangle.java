package shapeGallery;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

public class MyRectangle extends MyShape {

    public MyRectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        Rectangle rect = new Rectangle(x, y, 60, 40);
        rect.setFill(Color.FORESTGREEN);
        pane.getChildren().add(rect);
    }

    @Override
    public void highlight(Pane pane) {
        Rectangle rect = new Rectangle(x, y, 60, 40);
        rect.setFill(Color.FORESTGREEN);
        rect.setStroke(Color.RED);  // Add a red border for highlighting
        rect.setStrokeWidth(3);
        pane.getChildren().add(rect);
    }
}
