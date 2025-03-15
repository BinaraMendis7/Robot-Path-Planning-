class Graph {
    char[][] matrix;
    int size;
    CustomArrayList nodes;



    Graph(int size){
        this.size=size;
        matrix=new char[size][size];
        nodes=new CustomArrayList(size);
    }

    public void addNode(Node node){
        nodes.add(node);

    }
    public void addEdges(int row,int col){
        matrix[row][col]='O';

    }
    public boolean checkEdge(int row, int col){
        if (matrix[row][col]=='O'){
            return false;
        }
        else{
            return true;
        }

    }
    public void obstacles(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if (checkEdge(i, j)==true){
                    matrix[i][j]='.';
                }
            }
        }

    }

    public void print(){
        System.out.print("  ");
        for (Node node: nodes.nodes){
            System.out.print(node.data+ " ");
        }
        System.out.println();
        for (int i=0;i< matrix.length;i++){
            System.out.print(nodes.get(i).data+" ");
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void BFS(int src, int dest) {
        MyQueue queue = new MyQueue();
        boolean[] visited = new boolean[size];
        CustomIntarrayList[] parent = new CustomIntarrayList[size];



        for (int i = 0; i < size; i++) {
            parent[i] = new CustomIntarrayList();
            parent[i].add(-1);
        }

        queue.enqueue(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int current = queue.dequeue();

            if (current == dest)
                break;

            for (int i = 0; i < size; i++) {
                if (matrix[current][i] == 'O' && !visited[i]) {
                    queue.enqueue(i);
                    visited[i] = true;

                    for (int j = parent[i].size() - 1; j >= 0; j--) {
                        parent[i].remove(j);
                    }

                    parent[i].add(current);
                } else if (matrix[current][i] == 'O' && visited[i]) {
                    if (!parent[i].contains(current)) {
                        parent[i].add(current);
                    }
                }
            }
        }

        CustomIntarrayList shortestPath = new CustomIntarrayList();
        int current = dest;
        int distance = 0;
        while (current != -1) {
            shortestPath.add(current);
            distance++;
            if (current == src) {
                break;
            }

            // Choose the parent that leads to the shortest path:
            int shortestParentIndex = 0;
            for (int i = 1; i < parent[current].size(); i++) {
                if (visited[parent[current].get(i)] != visited[parent[current].get(shortestParentIndex)]) {
                    shortestParentIndex = i;
                }
            }
            current = parent[current].get(shortestParentIndex);
        }
        if (shortestPath.size()==1){
            shortestPath.remove(0);
        }

        if (shortestPath.isEmpty()){
            System.out.println("Path not found: ");
        }else {
            shortestPath.reverse();
            System.out.println("The shortest path form " + src + "to " + dest);
            shortestPath.print();

            // Mark the path cells with "*"
            for (int i = 0; i < shortestPath.size() - 1; i++) {
                int row = shortestPath.get(i);
                int col = shortestPath.get(i + 1);
                matrix[row][col] = 'R';
            }


            print();

        }
        }


}