package dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamitonPaperBoyProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTests = Integer.parseInt(br.readLine().trim());
		
		for (int i=0 ;i<noOfTests;i++) {
			String [] firstLineOfTestCase = br.readLine().split(" ");
			int noOfVertices = Integer.parseInt(firstLineOfTestCase[0]);
			int noOfEdges = Integer.parseInt(firstLineOfTestCase[1]);
			Graph g = new Graph(noOfVertices);
			for (i=0;i<noOfEdges;i++) {
				String[] edgeVertices = br.readLine().split(" ");
				g.addEdge(Integer.parseInt(edgeVertices[0])-1,Integer.parseInt(edgeVertices[1])-1);
			}
			boolean isDistributionPossible = false;
			for (int j=0;j<g.V();j++) {
				DFS dfs = new DFS(g,j);
				if(dfs.isConnectedGraph()){
					System.out.println("Yes");
					isDistributionPossible = true;
					break;
				}
			}
			if(!isDistributionPossible) {
				System.out.println("No");
			}
		}
	}

}
