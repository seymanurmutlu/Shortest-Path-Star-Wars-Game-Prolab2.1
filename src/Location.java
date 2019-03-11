
public class Location {
    
    int xAxis = 0, yAxis = 0, distance = 0;
    int matrixRow = 0, matrixCol = 0;
    
    Location(int xAxis, int yAxis, int distance) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.distance = distance;
    }

    Location() {
        /*iyi krakterlerin kullanabilmesi icin default constructor*/
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getMatrixRow() {
        return matrixRow;
    }

    public void setMatrixRow(int matrixRow) {
        this.matrixRow = matrixRow;
    }

    public int getMatrixCol() {
        return matrixCol;
    }

    public void setMatrixCol(int matrixCol) {
        this.matrixCol = matrixCol;
    }
    

}
