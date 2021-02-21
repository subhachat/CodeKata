package designpattern.proxy.challenge;

import java.util.List;

public class InventoryProxy implements Inventory {

    private Inventory<Item> inventory;

    @Override
    public List<Item> getInventory() {
        if (inventory == null) {
            inventory = new SuperstoreInventory();
        }
        return inventory.getInventory();
    }
}
