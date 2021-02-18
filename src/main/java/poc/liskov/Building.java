package poc.liskov;

public class Building {
    private int numberOfRooms = 8;

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Building with " + numberOfRooms + " rooms";
    }
}
