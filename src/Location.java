
import java.util.LinkedList;
import java.util.Queue;


public class Location {
    Queue<Integer> xAxis = new LinkedList<>(); 
    Queue<Integer> yAxis = new LinkedList<>(); 

    public Location() {
        
    }

    public Queue<Integer> getxAxis() {
        return xAxis;
    }

    public void setxAxis(Queue<Integer> xAxis) {
        this.xAxis = xAxis;
    }

    public Queue<Integer> getyAxis() {
        return yAxis;
    }

    public void setyAxis(Queue<Integer> yAxis) {
        this.yAxis = yAxis;
    }
    
    private void displayContentsOfQueue(){ /*this method displays contents of queue*/
        System.out.println("Elements of xAxis :"+ xAxis);
        System.out.println("Elements of yAxis :"+ yAxis);
    }
    
    private void displayHeadOfQueue(){ /*this method displays head of queues*/
        System.out.println("Head of xAxis Queue :" + xAxis.peek() );
        System.out.println("Head of yAxis Queue :" + yAxis.peek() );
    }
    
}
