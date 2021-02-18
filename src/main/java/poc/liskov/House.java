package poc.liskov;

public class House extends Building {
    private int numberOfRooms = 4;

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "House built with " + numberOfRooms + " rooms";
    }
}
