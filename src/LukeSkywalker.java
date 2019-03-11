
public class LukeSkywalker extends Character {

    private int lives;
    private Location location = new Location();

    public LukeSkywalker(String name, String kind) {
        super(name, kind);
        this.location.matrixRow = 5; // map [satir] [sutun]
        this.location.matrixCol = 6;
        this.location.xAxis = 6; //kordinat duzlemi sistemi
        this.location.yAxis = 5;
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

    public void printLocation() {
        System.out.println("xAxis : " + location.xAxis);
        System.out.println("yAxis : " + location.yAxis);
    }

    public void setMatrix(int row, int col) {
        this.location.matrixRow = row;
        this.location.matrixCol = col;
    }

    public void printMatrix() {
        System.out.println("matrix row : " + location.matrixRow);
        System.out.println("matrix col : " + location.matrixCol);

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int decreaseLives(int lives) {/*this method for decreasing live numbers */
        return lives--;
    }
}
