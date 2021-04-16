public class ShortestCommonAncestor {
    private Digraph DAG; // Directed Acylic Graph

    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G){
        if (G == null) throw new java.lang.IllegalArgumentException("Digraph is null");
        this.DAG = new Digraph(G);
    }
    // length of shortest ancestral path between v and w
    public int length(int v, int w){
        // Check to see if either vertex are in range, throw exception if they are outside the prescribed range
        if (v < 0 || v > DAG.V()) throw new java.lang.IllegalArgumentException("v is out of range");
        if (w < 0 || w > DAG.V()) throw new java.lang.IllegalArgumentException("w is out of range");
        
        // Create two graphs for the two vertices
        dag1 = new BreadthFirstDirectedPaths(DAG, v);
        dag2 = new BreadthFirstDirectedPaths(DAG, w);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        // Go through the vertices and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)) {
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                }
            }
        }
        // If the length never changed, then the vertex is its own ancestor, otherwise return the length
        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }
    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w){
        // Check to see if either vertex are in range, throw exception if they are outside the prescribed range
        if (v < 0 || v > DAG.V()) throw new java.lang.IllegalArgumentException("v is out of range");
        if (w < 0 || w > DAG.V()) throw new java.lang.IllegalArgumentException("w is out of range");
          
        // Create two graphs for the two vertices
        dag1 = new BreadthFirstDirectedPaths(DAG, v);
        dag2 = new BreadthFirstDirectedPaths(DAG, w);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        int result = -1;
        // Go through the vertices and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        // Store the number into result
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)){
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                    result = i;
                }
            }
        }
        // If the length never changed, then the vertex is its own ancestor (-1), otherwise it is the updated length
        return result;
    }
    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset points to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
        return -1; //todo change
    }
    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset points to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
        return -1; //todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}
