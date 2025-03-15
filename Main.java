import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size=10;
        Graph graph=new Graph(size);
        for (int i=0;i< graph.size;i++){
            graph.addNode(new Node(i));
        }


        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(2,4);
        graph.addEdges(2,5);
        graph.addEdges(4,8);
        graph.addEdges(5,9);
        graph.addEdges(5,7);
        graph.addEdges(8,5);
        graph.addEdges(1,9);
        graph.addEdges(1,3);
        graph.addEdges(3,6);
        graph.addEdges(6,1);
        graph.addEdges(4,2);
        graph.addEdges(2,5);
        graph.addEdges(8,7);
        graph.addEdges(0,3);
        graph.addEdges(6,3);
        graph.addEdges(4,5);



        graph.obstacles();
        Scanner userinput=new Scanner(System.in);
        System.out.print("Please enter the Number of the starting node: ");
        int src=userinput.nextInt();

        graph.print();




        graph.BFS(src,size-1);

    }
}








