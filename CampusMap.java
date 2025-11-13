import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Botanical Gardens", "16 College Ln", 1));
        myMap.addBuilding(new Cafe("Campus Center", "1 Chapin Way", 1, 100,50,50,80));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr", 4));
        myMap.addBuilding(new Library("Neilson","7 Neilson Dr", 4 ));
        myMap.addBuilding(new Building("Chapin","3 Chapin Way", 3 ));
        myMap.addBuilding(new Building("Hatfield Hall", "3 Neilson Dr", 2 ));
        myMap.addBuilding(new Building("Sabin Reed", "44 College Ln", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln", 4));
        myMap.addBuilding(new Building("Mendenhall", "122 Green St",1));
        myMap.addBuilding(new Building("Sage Hall", "144 Green St", 2));
        System.out.println(myMap);

        Library neilson = new Library("Neilson", "7 Neilson Dr",4);
        neilson.enter();
        neilson.goToFloor(4);
        neilson.showOptions();

        Cafe CC = new Cafe("Campus Center", "1 Chapin Way", 1, 100,50,50,80);
        CC.enter();
        CC.goToFloor(2);
        CC.sellCoffee(12);
        CC.showOptions();
    }
    
}
