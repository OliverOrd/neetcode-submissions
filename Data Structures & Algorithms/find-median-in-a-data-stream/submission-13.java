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
        rebalance();
    }

    private void rebalance() {
        while(lowerHalf.size() - upperHalf.size() > 1) {
            upperHalf.add(lowerHalf.poll());
        }
        while(upperHalf.size() - lowerHalf.size() > 1) {
            lowerHalf.add(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            double sum = ((double) upperHalf.peek() + lowerHalf.peek());
            return sum / 2d;
        } else if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return upperHalf.peek();
        }
    }
}
