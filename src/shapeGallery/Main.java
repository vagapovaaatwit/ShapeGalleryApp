package shapeGallery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<MyShape> shapes = new ArrayList<>();
    private Pane canvas = new Pane();

    @Override
    public void start(Stage primaryStage) {

        Button addShapeBtn = new Button("Add Random Shape");
        Button clearAllBtn = new Button("Clear All");

        // Add random shape functionality
        addShapeBtn.setOnAction(e -> {
            MyShape shape = getRandomShape();
            shapes.add(shape);
            shape.draw(canvas); // Polymorphic call
        });

        // Clear all shapes from the canvas
        clearAllBtn.setOnAction(e -> {
            shapes.clear();
            canvas.getChildren().clear();
        });

        VBox layout = new VBox(10, addShapeBtn, clearAllBtn, canvas);
        layout.setStyle("-fx-padding: 20");

        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setTitle("Shape Gallery - Polymorphism Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MyShape getRandomShape() {
        double x = Math.random() * 500;
        double y = Math.random() * 300;
        int r = (int)(Math.random() * 3);

        return switch (r) {
            case 0 -> new MyCircle(x, y);
            case 1 -> new MyRectangle(x, y);
            default -> new MyTriangle(x, y);
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
