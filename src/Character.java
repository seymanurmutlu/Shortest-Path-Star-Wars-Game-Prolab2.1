
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Character {

    public String name;/*karakterin adini tutar*/
    public String kind;/*karakterin turunu tutar*/
    Location location = new Location();
    public int lives;
	public int startRow;
	public int startCol;

    public Character(String name, String kind, int matrixRow, int matrixCol, int startRow, int startCol) {
        this.name = name;
        this.kind = kind;
        location.matrixRow = matrixRow;
        location.matrixCol = matrixCol;
        this.startRow=startRow;
        this.startCol=startCol;
    }
    
        public int characterMoveX(int currentX, int nextX){
        if(nextX > currentX){
           return (currentX+1);
        }else if(nextX < currentX){
            return (currentX-1);
        }else{
            return currentX;
        }
    }
    
        public int characterMoveY(int currentY, int nextY){
        if(nextY > currentY){
           return (currentY+1);
        }else if(nextY < currentY){
            return (currentY-1);
        }else{
            return currentY;
        }
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
//        System.out.println("Current xAxis :"+location.xAxis);
//        System.out.println("Current yAxis :"+location.yAxis);
        //System.out.println(location.distance);
        return location;
    }

    public void setLocation(int xAxis, int yAxis) {
        this.location.xAxis = xAxis;
        this.location.yAxis = yAxis;
        //this.location = location;
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

    // Binary Maze'in boyutu
    private static final int rowNum = 11;
    private static final int colNum = 14;

    // Below arrays details all 4 possible movements from a cell
    // burasi belki gereksizdir degistirilebilir
    private static final int row[] = {-1, 0, 0, 1};
    private static final int col[] = {0, -1, 1, 0};

    // Bu fonksiyon Function to check if it is possible to go to position (row, col)
    // from current position. The function returns false if (row, col)
    // is not a valid position or has value 0 or it is already visited
    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < rowNum) && (col >= 0) && (col < colNum)
                && mat[row][col] == 1 && !visited[row][col];
    }

    public int[] arr;

    public ArrayList<Location> kopyala(ArrayList<Location> kopyagel) {
        ArrayList<Location> kopya = new ArrayList<Location>();
        kopya = kopyagel;
        for (int i = 0; i < kopya.size(); i++) {

         //   System.out.println("-kopya-" + kopya.get(i).path.get(i).matrixRow + "," + kopya.get(i).path.get(i).matrixCol);

        }
        return kopya;
    }

    public ArrayList<Location> deneme = new ArrayList<Location>();

    //shortest path i kopyalamak icin buraya yeni bir q 
    public Queue<Location> q = new ArrayDeque<>();
    public ArrayList<Integer> shortestPathRows;
    public ArrayList<Integer> shortestPathCols;

    public Queue<Location> shortestPath(int mat[][], int i, int j, int x, int y) {/*sonrasinda duzenleme yapilacak */

        // construct a matrix to keep track of visited cells
        boolean[][] visited = new boolean[rowNum][colNum];

        // create an empty queue
        //Queue<Location> q = new ArrayDeque<>();
        // mark source cell as visited and enqueue the source node
        visited[i][j] = true;
        q.add(new Location(i, j, 0));

        // stores length of longest path from source to destination
        int min_dist = Integer.MAX_VALUE;

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            Location node = q.poll();

            // (i, j) represents current cell and dist stores its
            // minimum distance from the source
            i = node.matrixRow;
            j = node.matrixCol;
            int dist = node.distance;

            // if destination is found, update min_dist and stop
            if (i == x && j == y) {
                min_dist = dist;
                break;
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++) {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Location(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.println("Destination can't be reached from source");
        }

        return q;
    }

}
