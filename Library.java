import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title){
      collection.put(title, true);
    }

    public String removeTitle(String title){
      collection.remove(title);
      return title;
    }

    public void checkOut(String title){
      collection.replace(title, false);
    }

    public void returnBook(String title){
      collection.replace(title, true);
    }

    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    public boolean isAvailable(String title){
      return collection.getOrDefault(title, false);
    }

    public void printCollection(){
      for(String title : collection.keySet()){
        System.out.println(title + " (Available: " + collection.get(title)+ ")");
      }
    }

    public void addTitle(String title, boolean available){
      collection.put(title, available);
    }

  
    public void checkOut(String[] titles){
      for (String t : titles){
        if(collection.containsKey(t)){
          throw new RuntimeException("This library does not have the book: " + t);
        }
        if(collection.get(t) == false){
          throw new RuntimeException("The book \"" + t + "\" is already checked out!");
        }
        collection.replace(t, false);
        System.out.println("You checked out: " + t);
      }
    }

    @Override
    public void showOptions(){
      super.showOptions();
      System.out.println(" + addTitle(String title)");
      System.out.println(" + addTitle(String title, boolean available)");
      System.out.println(" + checkOut(String title)");
      System.out.println(" + checkOut(String[] titles)");
      System.out.println(" + returnBook(String title)");
      System.out.println(" + printCollection()");
    }

    @Override
    public void goToFloor(int floorNum){
      if(this.activeFloor == -1){
        throw new RuntimeException("Enter the library first!");
      }
      if (floorNum < 1 || floorNum > this.nFloors){
        throw new RuntimeException("Invalid floor number for " + this.getName());
      }
      this.activeFloor = floorNum;
      System.out.println("You took the elevator to floor " + floorNum + " of " + this.name);
    }
  
    public static void main(String[] args) {
      Library josten = new Library("Josten Library", "123 Green Street",4);
      josten.addTitle("The Phantom Of The Opera");
      josten.addTitle("Romeo and Juliet");
      josten.printCollection();
      josten.checkOut("Romeo and Juliet");
      josten.printCollection();
      josten.enter();
      josten.goToFloor(3);
      josten.showOptions();
    }
  
  }