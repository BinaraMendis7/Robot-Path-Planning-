public class CustomIntarrayList {
    private static final int INITIAL_CAPACITY = 10;
    private int[] elements;
    private int size;
    private int capacity;

    public CustomIntarrayList() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int value) {
        if (size >= capacity) {
            ensureCapacity(); // Increase capacity if necessary
        }
        elements[size++] = value;
    }

    public int get(int index) {
        return elements[index];
    }
    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = elements[left];
            elements[left] = elements[right];
            elements[right] = temp;


            // Move towards the middle
            left++;
            right--;
        }


    }
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }



    public int size() {
        return size;
    }
    public void print(){
        for (int i=0;i<size;i++){
            System.out.print(elements[i]+ " > ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        int newCapacity = capacity * 2;
        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
        capacity = newCapacity;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
