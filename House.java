
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator){
    this(name, address, nFloors, hasDiningRoom);
    this.hasElevator = hasElevator;
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  public void moveIn(Student s){
    if (this.residents.contains(s)){
      throw new RuntimeException("Student " + s.getName() + " is already a resident of " + this.name + ".");
    }  
      this.residents.add(s);
      System.out.println(s.getName() + " has moved into " + this.name + "!");
  }

  public Student moveOut(Student s){
    if(this.residents.remove(s)){
      return s;
    }else{
      return null;
    }
  }

  public boolean isResident(Student s){
    return this.residents.contains(s);
  }

  
  public void moveIn(ArrayList<Student> newResidents){
    for (Student s : newResidents){
      if(this.residents.contains(s)){
        throw new RuntimeException("Student " + s.getName() + " is already a resident of " + this.name + ".");
      }
      this.residents.add(s);
    }
    System.out.println(newResidents.size() + " students moved in!");
  }

  public Student moveOut(String studentName){
    for(Student s : residents){
      if (s.getName().equals(studentName)){
        residents.remove(s);
        return s;
      }
    }
    return null;
  }

  @Override 
  public void showOptions(){
    super.showOptions();
    System.out.println(" + moveIn(Student s)");
    System.out.println(" + moveIn(ArrayList<Student> group)");
    System.out.println(" + moveOut(Student s)");
    System.out.println(" + moveOut(String name)");
    System.out.println(" + isResident(Student s)");
  }

  @Override
  public void goToFloor(int floorNum){
    if(this.activeFloor == -1){
      throw new RuntimeException("Enter the house first!");
    }
    if(!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1){
      throw new RuntimeException("This house has no elevator, move one floor at a time!");
    }
    super.goToFloor(floorNum);
  }

  public static void main(String[] args) {
    House ziskind = new House("Ziskind House", "123 Green Street",3,true);
    Student krystal = new Student("Krystal","9909123",2028);
    ziskind.moveIn(krystal);
    System.out.println("Residents: " + ziskind.nResidents());
    ziskind.enter();
    ziskind.goToFloor(2);
    ziskind.showOptions();
  }

}