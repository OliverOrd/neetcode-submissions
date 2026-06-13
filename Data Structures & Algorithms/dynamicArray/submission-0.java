class DynamicArray {

    private int[] buffer;
    private int capacity;
    private int tail;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.tail = 0;
        this.buffer = new int[capacity];
    }

    public int get(int i) {
        return buffer[i];
    }

    public void set(int i, int n) {
        buffer[i] = n;
    }

    public void pushback(int n) {
        if (tail >= getCapacity()) {
            resize();
        }
        buffer[tail++] = n;
    }

    public int popback() {
        return buffer[--tail];
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newBuffer = new int[capacity];
        System.arraycopy(buffer, 0, newBuffer, 0, capacity/2);
        buffer = newBuffer;
    }

    public int getSize() {
        return tail;
    }

    public int getCapacity() {
        return capacity;
    }
}
