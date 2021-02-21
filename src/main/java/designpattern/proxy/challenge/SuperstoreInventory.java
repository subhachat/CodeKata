package designpattern.proxy.challenge;

import java.util.ArrayList;
import java.util.List;

public class SuperstoreInventory implements Inventory<Item> {
    List<Item> inventory = null;

    public SuperstoreInventory() {
        inventory = new ArrayList<>();
        inventory.add(new Item("Bread", 0.85, 150));
        inventory.add(new Item("Onion", 0.75, 200));
        inventory.add(new Item("Milk", 1.25, 150));
        inventory.add(new Item("Eggs", 0.85, 150));
        inventory.add(new Item("Tea", 1.5, 250));
        inventory.add(new Item("Coffee", 1.2, 150));
        inventory.add(new Item("Butter", 2.5, 150));
        inventory.add(new Item("Flour", 1.35, 200));
        inventory.add(new Item("Salt", 0.65, 400));
        inventory.add(new Item("Sugar", 1.5, 400));
    }

    @Override
    public List<Item> getInventory() {
        return inventory;
    }
}
