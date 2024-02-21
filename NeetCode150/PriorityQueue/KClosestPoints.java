package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class KClosestPoints {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if (Math.sqrt(Math.pow(p1.x, 2) + Math.pow(p1.y, 2)) < Math.sqrt(Math.pow(p2.x, 2) + Math.pow(p2.y, 2)))
                return 1;
            else if (Math.sqrt(Math.pow(p1.x, 2) + Math.pow(p1.y, 2)) > Math.sqrt(Math.pow(p2.x, 2) + Math.pow(p2.y, 2)))
                return -1;
            return 0;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        for(int[] point: points) {
            pq.offer(new Pair(point[0], point[1]));
            if(pq.size() > k) pq.poll();
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            result[i][0] = pair.x;
            result[i][1] = pair.y;
            i++;
        }
        return result;
    }

    public static void main(String... args) {
        KClosestPoints kClosestPoints = new KClosestPoints();
        int[][] result = kClosestPoints.kClosest(new int[][]{{1,3},{-2,2}}, 1);

        for(int[] res: result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
