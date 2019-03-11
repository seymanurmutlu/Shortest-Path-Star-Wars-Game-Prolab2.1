
public class MasterYoda extends Character {

    private int lives;
    private Location location = new Location();

    public MasterYoda(String name, String kind) {
        super(name, kind);
        this.location.matrixRow = 5; // map [satir] [sutun]
        this.location.matrixCol = 6;
        this.location.xAxis = 6;
        this.location.yAxis = 5;
        /*martis uzerinde sag-sol hareketi sutun sayisini degistirir*/
        lives = 6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = "Master Yoda";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        kind = "Iyi";
    }

    public Location getLocation() {
        // System.out.println("Master Yoda Current xAxis :"+location.xAxis);
        // System.out.println("Master Yoda Current yAxis :"+location.yAxis);

        return location;
    }

    public void setLocation(int xAxis, int yAxis) {
        this.location.xAxis = xAxis;
        this.location.yAxis = yAxis;
//        this.location = location;
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
