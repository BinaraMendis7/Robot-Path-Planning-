class CustomArrayList {
    Node[] nodes;
    int[] numbers;
    int size;
    int capacity;

    public CustomArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        this.nodes = new Node[initialCapacity];
        this.size = 0; // Initialize size to 0, as initially the list is empty
        this.numbers=new int[initialCapacity];
    }

    public void add(Node input) {
        if (size >= capacity) {
            capacity *= 2;
            Node[] newArray = new Node[capacity];
            System.arraycopy(nodes, 0, newArray, 0, size);
            nodes = newArray;
        }
        nodes[size++] = input;
    }




    public Node get(int index) {
        return nodes[index];
    }


}