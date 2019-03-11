public class Stormtrooper extends Character {

    int stormtrooperNumber;
    
    public Stormtrooper(String name, String kind) {
        super(name, kind);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = "Stromtrooper";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        kind = "Kotu";
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public int getStormtrooperNumber() {
        return stormtrooperNumber;
    }

    public void setStormtrooperNumber(int stormtrooperNumber) {
        this.stormtrooperNumber = stormtrooperNumber;
    }

//    @Override
//    public void shortestPath(int mat[][], int i, int j, int x, int y) {/*Override edilecek*/
//
//    }

    public Character addStormtrooper(Character Stormtrooper) {
        Stormtrooper.setName("Stormtrooper" + stormtrooperNumber);
        Stormtrooper.setKind("Kotu");
        //Stormtrooper.setLocation(location); // duzelt ;   location i nasil olusturacagimiz belli degil su an     
        
        return Stormtrooper;
    }
    
    public void incrementStormtrooperNumber() {
        this.stormtrooperNumber++;
    }
}
