import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Random;
import java.lang.Runnable;
import java.util.*;
public class CarQueue {
  PriorityQueue<Integer> q;
  CarQueue() {
    q = new PriorityQueue<Integer>();
    q.add(3);
    q.add(1);
    q.add(4);
    q.add(4);
    q.add(0);
    q.add(2);
  }
  public void addToQueue() {
   class Run implements Runnable {
      PriorityQueue<Integer> r;
      public Run(PriorityQueue<Integer> s) {
        r = s;
      }
      public void run() {
        Random number = new Random();
        int randnumber = number.nextInt() % 4;
        r.add(randnumber);
      }
    }
    Run runnable = new Run(q);
    Thread thread = new Thread(runnable);
    thread.run();
  }
  public int deleteQueue() {
    int num;
    if (q.isEmpty()) {
      addToQueue();
    }
    num = q.poll();
    return num;
  }
}