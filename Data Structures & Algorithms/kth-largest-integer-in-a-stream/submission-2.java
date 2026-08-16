class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

    int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > capacity) {
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > capacity) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
