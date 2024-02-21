import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int num: nums) add(num);
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k) pq.poll();
        return pq.peek();
    }

    public static void main(String... args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(9));
    }
}
