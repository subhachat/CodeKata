package designpattern.proxy.challenge;

public class Store {
    private final String storeName;
    private final String location;
    private final Inventory<Item> inventory;

    public Store(String storeName, String location, Inventory<Item> inventory) {
        this.storeName = storeName;
        this.location = location;
        this.inventory = inventory;
    }

    public void printInventory() {
        inventory.getInventory().parallelStream().forEach(System.out::println);
    }

}
