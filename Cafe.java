
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public Cafe(String name, String address){
        this(name, address, 1, 200, 100, 100, 50);
    }
    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(size > this.nCoffeeOunces){
            throw new RuntimeException("Not enough coffee!");
        }
        if(nSugarPackets > this.nSugarPackets){
            throw new RuntimeException("Not enough sugar packets!");
        }
        if(nCreams > this.nCreams){
            throw new RuntimeException("Not enough cream cups!");
        }
        if(this.nCups < 1){
            throw new RuntimeException("No cups left!");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    public void sellCoffee(int size){
        sellCoffee(size, 1, 1);
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Inventory Restocked!");
    }

    private void restock(int nCoffeeOunces, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nCups += nCups;
        System.out.println("Partial restock complete!");
    }

    @Override
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(int size)");
        System.out.println(" + sellCoffee(int size, int sugar, int cream)");
        System.out.println(" + restock(...)");
    }

    @Override
    public void goToFloor(int floorNum){
        if(this.activeFloor == -1){
            throw new RuntimeException("Enter the cafe first!");
        }
        if (floorNum != 1){
            throw new RuntimeException("The cafe only has 1 floor!");
        }
        super.goToFloor(1);
    }

    public static void main(String[] args) {
       Cafe compass = new Cafe("Compass Cafe","123 Green Street",1,100,50,50,50);
        compass.enter();
        compass.goToFloor(2);
        compass.sellCoffee(12);
        compass.sellCoffee(12,2,3);
        compass.restock(50,10);
        compass.restock(50,20,20,10);
        compass.showOptions();
    }
    
}
