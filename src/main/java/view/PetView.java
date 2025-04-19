package view;

import controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class PetView extends Application {

    // Constant variables
    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;
    private Image petImage;

    // Override init method
    @Override
    public void init() {
        controller = new PetController(this);
    }

    // Override start method
    @Override
    public void start(Stage stage) {

        // Create a new Canvas and GraphicsContext
        canvas = new Canvas(700, 700);
        gc = canvas.getGraphicsContext2D();

        // Load the pet image
        petImage = new Image((Objects.requireNonNull(getClass().getResource("/pet.jpg"))).toExternalForm());

        // Mouse event handlers
        canvas.setOnMouseMoved(event -> {
            controller.setMousePosition(event.getX(), event.getY());
            controller.setMouseInside(true);
        });

        // Mouse exit event handler
        canvas.setOnMouseExited(event -> controller.setMouseInside(false));

        // Animation loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update the pet's position and redraw the canvas
                controller.updatePetPosition();
            }
        };
        timer.start(); // Start the animation loop

        // Set up the scene and stage
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();

        // Update the canvas with the initial position of the pet
        updateCanvas(200, 200);
    }

    // Method to update the canvas with the pet's position
    public void updateCanvas(double x, double y) {
        // Clear the canvas and draw the pet image at the new position
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double imageWidth = 100; // Desired width
        double imageHeight = 100; // Desired height
        // Draw the pet image at the specified position, stopping if it reaches the mouse cursor
        gc.drawImage(petImage, x - imageWidth / 2, y - imageHeight / 2, imageWidth, imageHeight);
    }

}
