class MedianFinder {

    private final PriorityQueue<Integer> lowerHalf = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    private final PriorityQueue<Integer> upperHalf = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (lowerHalf.isEmpty() || num < lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }
        
        if (lowerHalf.size() - upperHalf.size() > 1) {
            upperHalf.add(lowerHalf.poll());
        } else if (upperHalf.size() - lowerHalf.size() > 1) {
            lowerHalf.add(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return ((double) upperHalf.peek() + lowerHalf.peek()) / 2d;
        } else if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return upperHalf.peek();
        }
    }
}
