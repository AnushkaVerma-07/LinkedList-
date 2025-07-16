import java.util.ArrayList;

public class countConnectedComponents {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<BFSGraph.Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<BFSGraph.Edge>();
        }
        graph[0].add(new BFSGraph.Edge(0,1));
        graph[0].add(new BFSGraph.Edge(0,2));

        graph[1].add(new BFSGraph.Edge(1,0));
        graph[1].add(new BFSGraph.Edge(1,3));

        graph[2].add(new BFSGraph.Edge(2,0));
        graph[2].add(new BFSGraph.Edge(2,4));

        graph[3].add(new BFSGraph.Edge(3,1));
        graph[3].add(new BFSGraph.Edge(3,4));
        graph[3].add(new BFSGraph.Edge(3,5));

        graph[4].add(new BFSGraph.Edge(4,2));
        graph[4].add(new BFSGraph.Edge(4,3));
        graph[4].add(new BFSGraph.Edge(4,5));

        graph[5].add(new BFSGraph.Edge(5,3));
        graph[5].add(new BFSGraph.Edge(5,4));
        graph[5].add(new BFSGraph.Edge(5,6));

    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean[] visited){
        visited[current] =true;
        for(int i = 0; i< graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest,visited);
            }
        }
    }
    public static int ConnectedComponents(ArrayList<Edge> graph[], int V) {
        boolean  visited[] = new boolean[V];
        int count  = 0;

        for(int i = 0; i< V; i++){
            if(!visited[i]){
                dfs(graph,i,visited);
                count++;
            }
        }
        return count;
    }

    
}
