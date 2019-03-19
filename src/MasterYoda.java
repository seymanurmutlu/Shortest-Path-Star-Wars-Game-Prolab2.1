public class MasterYoda extends Character {

    private Location location = new Location();

    public MasterYoda(String name, String kind,int lives,int matrixRow, int matrixCol,int startRow,int startCol) {
        super(name, kind, matrixRow, matrixCol,startRow,startCol);
        this.location.matrixRow = 5; // map [satir] [sutun]
        this.location.matrixCol = 6;
        this.location.xAxis = 6;
        this.location.yAxis = 5;
        /*matris uzerinde sag-sol hareketi sutun sayisini degistirir*/
        this.lives=lives;
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
    	return this.lives=lives-1;
    }

}
