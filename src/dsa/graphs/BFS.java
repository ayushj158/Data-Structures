package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private boolean [] marked;
	private Integer[] edgeTo;
	private Integer[] distTo;
	private int s;

	public BFS(Graph graph,int s) {
		this.s=s;
		this.marked= new boolean[graph.V()];
		this.edgeTo= new Integer[graph.V()];
		this.distTo= new Integer[graph.V()];
		bfs(graph,this.s);
	}
	
	private void bfs(Graph graph,int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		marked[s]=true;
		int count =0 ;
		while(!queue.isEmpty()) {
			final int peekedElement = queue.peek();
			count++;
			System.out.println(peekedElement);
			for (int w : graph.adj(peekedElement)) {
				if(!marked[w]) {
					queue.add(w);
					marked[w]=true;
					edgeTo[w]=peekedElement;
					distTo[w]=count;
				}
			}
		}
	}
	
	public boolean hasPathTo(int d) {
		return marked[d];
	}
	
	public void pathTo(int d) {
		if (!marked[d]) System.out.println(false);
		List<Integer> path = new ArrayList<Integer>();
		int x=edgeTo[d];
		while(x!=s) {
			path.add(x);
			x=edgeTo[x];

		}
		path.add(s);
		
	}
}
