class KthLargest {

    PriorityQueue<Integer> pq;
    final int queueSize;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        queueSize = k;

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > queueSize) {
                pq.remove();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > queueSize) {
            pq.remove();
        }
        return pq.peek();
    }
}