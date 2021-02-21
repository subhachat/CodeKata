package designpattern.proxy.challenge;

public class StoreCheckerUpdated {

    public static void main(String... args) {
        long startTime = System.nanoTime();
        Inventory<Item> inventory = new InventoryProxy();
        long loadTime = System.nanoTime();
        Store store = new Store("Amazon Fresh", "Jackson Height", inventory);
        store.printInventory();
        long endTime = System.nanoTime();
        System.out.println("----data loading time----" + (loadTime - startTime) + " in ns");
        System.out.println("----inventory allotment and print time----" + (endTime - loadTime) + " in ns");
    }
}
