package model;

public class PetModel {

    // The pet's current position
    private double x;
    private double y;

    // Constructor
    public PetModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Methods to get the pet's position
    public double getX() {
        return x;
    }

    // Methods to get the pet's position
    public double getY() {
        return y;
    }

    // Method to move the pet towards a target position
    public void moveTowards(double targetX, double targetY, double speed) {
        double dx = targetX - x; // Difference in x-coordinates
        double dy = targetY - y; // Difference in y-coordinates
        double distance = Math.sqrt(dx * dx + dy * dy); // Distance to the target

        if (distance < speed) {
            x = targetX; // If the distance is less than the speed, set the pet's position to the target
            y = targetY; // Set the pet's position to the target
        } else {
            // Speed is the distance the pet moves in one frame (in pixels)
            x += (dx / distance) * speed; // Move the pet towards the target
            y += (dy / distance) * speed; // Move the pet towards the target
        }
    }

}
