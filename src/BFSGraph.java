import java.util.*;
class BFSGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

    }

    //breath first search

    public static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()){
            int current = q.remove();
            if(visited[current] == false){
                System.out.println(current + " ");
                visited[current] = true;

                for(int i = 0; i<graph[current].size(); i++){
                    Edge e= graph[current].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //depth first search
    public static void dfs( ArrayList<Edge> graph[], int current, boolean visited[]){
        System.out.println(current+" ");
        visited[current] = true;

        for(int i = 0; i<graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(visited[e.dest] == false)
                dfs(graph,e.dest,visited);
        }
    }

    //Find all paths

    public static void allPaths(ArrayList<Edge> graph[], boolean visited[], int current, String Path, int target){
        if(current == target){
            System.out.println(Path);
            return;
        }

        for(int i = 0; i< graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(visited[current] == false){
                visited[current] = true;
                allPaths(graph,visited,e.dest, Path+e.dest,target);
                visited[current] = false;

            }
        }
    }

    //Cycle detection in directed graph

    public static boolean cycleDirected(ArrayList<Edge> graph[], boolean[] visited, int current, boolean[] recusion){
        visited[current] = true;
        recusion[current] = true;
        for(int i = 0; i< graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(recusion[e.dest]){
                return true;
            } else if (!visited[e.dest]) {
                if(cycleDirected(graph,visited,e.dest,recusion))
                    return true;
            }
            recusion[current] = false;
            return false;

        }
    }

    //Cycle detection in Undirected graph

    public static boolean CycleUndirected(ArrayList<Edge> graph[], boolean visited[], int current, int parent){
        visited[current]= true;
        for(int i = 0; i<graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(visited[e.dest] && e.dest != parent){
                return true;
            }
            else if (!visited[e.dest]) {
                if(CycleUndirected(graph,visited,e.dest,current)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; i++){
            if(visited[i] == false){
                bfs(graph,V, visited, i);
            }
        }

        dfs(graph,0,visited);

        int src = 0, target = 5;
        allPaths(graph,  new boolean[V],src,"0",target );
        System.out.println();
    }
}