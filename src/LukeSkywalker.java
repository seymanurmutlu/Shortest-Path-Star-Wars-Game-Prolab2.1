
public class LukeSkywalker extends Character {
    
    private int lives ;
    
    public LukeSkywalker(String name, String kind) {
        super(name, kind);
        lives = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = "Luke Skywalker";
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public int decreaseLives(int lives){/*this method for decreasing live numbers */
        return lives--;
    }
}
