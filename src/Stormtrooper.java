
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Stormtrooper extends Character {

    int stormtrooperNumber;

    public Stormtrooper(String name, String kind, int matrixRow, int matrixCol,int startRow,int startCol) {
        super(name, kind, matrixRow, matrixCol,startRow,startCol);
    }

  /*  public Stormtrooper(String name, String kind) {
        super(name, kind);
    }*/
    
    
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

    @Override
	public int characterMoveX(int currentX, int nextX) {
		return super.characterMoveX(currentX, nextX);
	}

	@Override
	public int characterMoveY(int currentY, int nextY) {
		return super.characterMoveY(currentY, nextY);
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

    public Queue<Location> q = new ArrayDeque<>();

 /*   public ArrayList<Location> kopyala(ArrayList<Location> kopyagel) {
        ArrayList<Location> kopya = new ArrayList<Location>();
        kopya = kopyagel;
        for (int i = 0; i < kopya.size(); i++) {

      //      System.out.println("-kopya-" + kopya.get(i).path.get(i).matrixRow + "," + kopya.get(i).path.get(i).matrixCol);

        }
        return kopya;
    }*/

    @Override
	public ArrayList<Location> kopyala(ArrayList<Location> kopyagel) {
		return super.kopyala(kopyagel);
	}

    @Override
    public Queue<Location> shortestPath(int mat[][], int i, int j, int x, int y) {
        /*sonrasinda duzenleme yapilacak */

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

                for (int it = 0; it < node.path.size(); it++) {

                    System.out.println("------" + node.path.get(it).getMatrixRow() + "  " + node.path.get(it).getMatrixCol());
                }
                deneme = kopyala(node.path);
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

                    Location tt = new Location(i + row[k], j + col[k], dist + 1);
                    tt.path = (ArrayList<Location>) node.path.clone();
                    tt.path.add(tt);

                    q.add(tt);
                    //q.add(new Location(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.println("Destination can't be reached from source");
        }
        System.out.println("\nstormtrooperdayiz");
        return q;
    }

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
