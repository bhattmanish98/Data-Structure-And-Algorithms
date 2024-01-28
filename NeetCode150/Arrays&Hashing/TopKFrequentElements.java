import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums) frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
            a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> it : frequencyMap.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int[] result = new int[k];
        while(!pq.isEmpty()) result[--k] = pq.poll().getKey();
        return result;
    }

    public static void main(String... args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for(int i: result) System.out.println(i);
    }
}