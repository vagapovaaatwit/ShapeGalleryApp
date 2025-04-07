package shapeGallery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private ArrayList<MyShape> shapes = new ArrayList<>();
    private Map<String, MyShape> shapesMap = new HashMap<>();
    private Pane canvas = new Pane();
    private ListView<String> shapeListView = new ListView<>();
    private ComboBox<String> filterComboBox = new ComboBox<>();

    private int shapeCount = 1;  // To generate unique names like "Shape 1", "Shape 2", ...

    @Override
    public void start(Stage primaryStage) {
        Button addShapeBtn = new Button("Add Random Shape");
        addShapeBtn.setOnAction(e -> addRandomShape());

        // Set up ListView to show shape names
        shapeListView.setOnMouseClicked(e -> highlightShape());

        // Set up ComboBox to filter by shape type
        filterComboBox.getItems().addAll("All", "Circle", "Rectangle", "Triangle");
        filterComboBox.setValue("All");
        filterComboBox.setOnAction(e -> filterShapes());

        VBox layout = new VBox(10, addShapeBtn, filterComboBox, shapeListView, canvas);
        layout.setStyle("-fx-padding: 20");

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Shape Gallery - Enhanced");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addRandomShape() {
        MyShape shape = getRandomShape();
        String shapeName = "Shape " + shapeCount++;
        shapes.add(shape);
        shapesMap.put(shapeName, shape);

        shapeListView.getItems().add(shapeName);
        shape.draw(canvas);  // Draw the shape

        // After adding a shape, update the ListView and canvas
    }

    private MyShape getRandomShape() {
        double x = Math.random() * 500;
        double y = Math.random() * 300;
        int r = (int)(Math.random() * 3);

        switch (r) {
            case 0: return new MyCircle(x, y);
            case 1: return new MyRectangle(x, y);
            default: return new MyTriangle(x, y);
        }
    }

    private void highlightShape() {
        String selectedName = shapeListView.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            MyShape selectedShape = shapesMap.get(selectedName);
            selectedShape.highlight(canvas); // Highlight the selected shape
        }
    }

    private void filterShapes() {
        String selectedType = filterComboBox.getValue();
        shapeListView.getItems().clear();

        // Add shapes back to the list based on the selected type
        for (String name : shapesMap.keySet()) {
            MyShape shape = shapesMap.get(name);
            if (selectedType.equals("All") || shape.getClass().getSimpleName().equals("My" + selectedType)) {
                shapeListView.getItems().add(name);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
