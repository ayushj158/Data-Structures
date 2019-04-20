package dsa.graphs;

public class ConnectedComponents {

	private boolean [] marked;
	private Integer[] edgeTo;
	private Integer[] componentId;
	private int count=0;

	public ConnectedComponents(Graph graph) {
		this.marked= new boolean[graph.V()];
		this.edgeTo= new Integer[graph.V()];
		this.componentId= new Integer[graph.V()];
		findAllCC(graph);
	}
	
	private void findAllCC(final Graph graph) {
		for (int i=0;i<graph.V();i++) {
			if(!marked[i]) {
				dfs(graph,i);
				count++;
			}
		}
	}
	
	private void dfs(Graph graph,int s) {
		marked[s]=true;
		componentId[s] = count;
		for (int w: graph.adj(s)) {
			if(!marked[w]) {
				edgeTo[w]=s;
				dfs(graph,w);
			}
		}
	}
}
