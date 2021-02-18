package poc.liskov;

import java.util.ArrayList;
import java.util.List;

public class RunLSPChecker {

    public static void main(String[] args){
        //List of Buildings
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);

        //List of Houses
        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());
        //----printBuildings(houses);
        printBuildings2(houses);

        //List of Offices
        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        //----printBuildings(offices);
        printBuildings2(offices);

        addHouseToList(houses);
        //----addHouseToList(buildings);
        addHouseToList2(buildings);
    }

    private static void printBuildings(List<Building> buildings){
        buildings.forEach(asset -> System.out.println(asset));
    }

    private static void printBuildings2(List<? extends Building> buildings){
        buildings.forEach(asset -> System.out.println(asset));
    }

    private static  void addHouseToList(List<House> assets){
        assets.add(new House());
        System.out.println(assets);
    }

    private static  void addHouseToList2(List<? super House> assets){
        assets.add(new House());
        System.out.println(assets);
    }
}
