class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

    int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        for (int num : nums) {
            addElement(num);
        }
    }
    
    public int add(int num) {
        addElement(num);
        return minHeap.peek();
    }

    private void addElement(int num) {
        minHeap.add(num);
        if (minHeap.size() > capacity) {
            minHeap.remove();
        }
    }
}
