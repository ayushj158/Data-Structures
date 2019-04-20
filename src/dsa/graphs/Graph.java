package dsa.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	private int v ; 
	
	private Set<Integer>[] adj ;
	
	
	public Graph(int v) {
		this.v = v;
		adj = (Set<Integer>[]) new Set[v];
		for (int i=0 ;i<v;i++) {
			adj[i] = new HashSet<Integer>();
		}
	}

	public int V() {
		return this.v;
	}

	public void addEdge(int v,int w) {
		adj[v].add(w);
	}

	public Set<Integer> adj(int v) {
		return adj[v];
	}
}
