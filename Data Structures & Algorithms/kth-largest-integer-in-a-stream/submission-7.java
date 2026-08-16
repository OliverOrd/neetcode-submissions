class KthLargest {

    final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

    final int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        for (int num : nums) {
            addToHeap(num);
        }
    }
    
    public int add(int num) {
        addToHeap(num);
        return minHeap.peek();
    }

    private void addToHeap(int num) {
        minHeap.add(num);
        if (minHeap.size() > capacity) {
            minHeap.poll();
        }
    }
}
