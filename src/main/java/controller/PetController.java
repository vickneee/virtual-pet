package controller;

import model.PetModel;
import view.PetView;

public class PetController {

    // Instance variables
    private final PetModel pet;
    private final PetView view;

    // Event variables
    private double targetX;
    private double targetY;
    private boolean isMouseInside;

    // Constructor
    public PetController(PetView petView) {
        this.view = petView;
        this.pet = new PetModel(200, 200); // Initial position
        this.isMouseInside = false; // Initially, the mouse is not inside the canvas
    }

    // Method to update the pet's position
    public void updatePetPosition() {
        if (isMouseInside) {
            pet.moveTowards(targetX, targetY, 1); // Speed of 1 pixel per frame
            view.updateCanvas(pet.getX(), pet.getY());
        }
    }

    // Methods to set the target position and mouse state
    public void setMousePosition(double x, double y) {
        this.targetX = x;
        this.targetY = y;
    }

    // Method to set the mouse inside state
    public void setMouseInside(boolean inside) {
        this.isMouseInside = inside;
    }

}
