package dsa.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DFS {
	
	private boolean [] marked;
	private Integer[] edgeTo;
	private int s;

	public DFS(Graph graph,int s) {
		this.s=s;
		this.marked= new boolean[graph.V()];
		this.edgeTo= new Integer[graph.V()];
		dfs(graph,s);
	}
	
	private void dfs(Graph graph,int s) {
		marked[s]=true;
		for (int w: graph.adj(s)) {
			if(!marked[w]) {
				edgeTo[w]=s;
				dfs(graph,w);
			}
		}
	}
	
	/*if all vertices are visited after performing DFS then our graph is connected */
	public boolean isConnectedGraph() {
		for (int i=0 ;i<marked.length;i++) {
			if (!marked[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasPathTo(int d) {
		return marked[d];
	}
	
	public List<Integer> pathTo(int d){
		final List<Integer> path = new ArrayList<Integer>();
		if(!hasPathTo(d)) return null;
		int x = edgeTo[d]; 
		path.add(x);
		while(x!=s) {
			x=edgeTo[x];
			path.add(x);
		}
		path.add(s);
		return path;
	}

}
