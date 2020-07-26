import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Reachability {

    static HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
    
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        if(Reachability.visited.get(x) != null && Reachability.visited.get(x)){
            return 0;
        }
        
        Reachability.visited.put(x, true);
        
        for (int i = 0; i < adj[x].size(); i++) {
            if(adj[x].get(i) == y){
                return 1;
            }  
            else if(Reachability.visited.get(adj[x].get(i)) == null || !Reachability.visited.get(adj[x].get(i))){
                return reach(adj, adj[x].get(i), y);
            }
        }

        return 0;
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
        System.out.println("Check reachability from:");
        int x = scanner.nextInt() - 1;
        System.out.println("Check reachability to:");
        int y = scanner.nextInt() - 1;
        System.out.println("Check reachability from "+ x +", to: "+ y);
        System.out.println(reach(adj, x, y));

        scanner.close();
    }
}


