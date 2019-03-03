
public class Character {
    public String name;/*karakterin adini tutar*/
    public String kind;/*karakterin turunu tutar*/
    Location location = new Location();
    
    
    public Character(String name, String kind) {
        this.name = name;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public void shortestPath(){/*sonrasinda duzenleme yapilacak */ 
        
    }
    
    
}
