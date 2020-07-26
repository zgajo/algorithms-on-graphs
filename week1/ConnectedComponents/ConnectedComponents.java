import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConnectedComponents {
    static HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
    
    private static void explore(ArrayList<Integer>[] adj, int x) {
        if(ConnectedComponents.visited.get(x)){
            return;
        }
        
        ConnectedComponents.visited.put(x, true);
        
        for (int i = 0; i < adj[x].size(); i++) {
            if(!ConnectedComponents.visited.get(adj[x].get(i))){
                explore(adj, adj[x].get(i));
            }
        }
        return;
    }

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;

        for(int i = 0; i<adj.length; i ++){
            ConnectedComponents.visited.put(i, false);
        }

        //write your code here
        for(int i = 0; i<adj.length; i ++){
            if(!ConnectedComponents.visited.get(i)){
                ++result;

                explore(adj, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert no of vertices");

        int n = scanner.nextInt();
        System.out.println("Insert no of edges");

        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            System.out.println("Edge between:");

            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println("numberOfComponents: " + numberOfComponents(adj));

        scanner.close();
    }
}

