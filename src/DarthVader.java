public class DarthVader extends Character {

    int darthVaderNumber ;
    
    public DarthVader(String name, String kind) {
        super(name, kind);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Darth Vader";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = "Kotu";
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDarthVaderNumber() {
        return darthVaderNumber;
    }

    public void setDarthVaderNumber(int darthVaderNumber) {
        this.darthVaderNumber = darthVaderNumber;
    }
    

    @Override
    public void shortestPath(){/*Override edilecek tüm
    matris elemanlarının bir olacağı göz önüne alınarak hesaplanmalı.*/ 
        
    }
    
    public Character addDarthVader(Character darthVader){
        darthVader.setName("Darth Vader"+darthVaderNumber);
        darthVader.setKind("Kotu");
        darthVader.setLocation(location); // duzelt ;   location i nasil olusturacagimiz belli degil su an     
        
        return darthVader;
    }
    
    public void incrementDarthVaderNumber(){
        this.darthVaderNumber++;
    }
    
}
