package shapeGallery;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;

public class MyTriangle extends MyShape {

    public MyTriangle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(x, y, x + 40, y + 60, x - 40, y + 60);
        triangle.setFill(Color.TOMATO);
        pane.getChildren().add(triangle);
        
        addLabel(pane, "Triangle");
    }
}
