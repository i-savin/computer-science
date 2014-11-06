package isavin.datastrustures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class YaGraph {
    private GraphNode[][] nodes;
    private int numberOfExits;
    private List<Way> ways = new ArrayList<Way>();
    private Set<GraphNode> foundNodes = new HashSet<>();
    
    /**
     * 
     * @param m строки
     * @param n столбцы
     */
    public YaGraph(int m, int n) {
        nodes = new GraphNode[n][m];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		nodes[i][j] = new GraphNode(i, j);
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (j + 1 < m) {
        			nodes[i][j].nodesList.add(nodes[i][j + 1]);
        		}
        		if (i + 1 < n) {
        			nodes[i][j].nodesList.add(nodes[i + 1][j]);
        		}
        		System.out.print(i + "-" + j +" ");
        	}
        	System.out.println();
        }
        nodes[n - 1][m-1].exit = true;
    }
	
	
	private class GraphNode {
	    private List<GraphNode> nodesList = new ArrayList<GraphNode>();
	    private int x;
	    private int y;
	    private boolean exit;
	    
	    public GraphNode(int x, int y) {
	    	this.x = x;
	    	this.y = y;
	    }

		@Override
        public String toString() {
	        return "[" + x + ", " + y + "]";
        }
	    

	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nodes.length; i++) {
        	for (int j = 0; j < nodes[i].length; j++) {
        		sb.append("Node " + nodes[i][j] + ": " + nodes[i][j].nodesList + "\n");
        		
        	}
        }		
		return sb.toString();
	}
	
	public int findWays() {
		Way way = new Way();
		way.addStep(this.nodes[0][0]);
		processNode(this.nodes[0][0], way);
		return numberOfExits;
	}
	
	private void processNode(GraphNode node, Way way) {
		for (GraphNode child : node.nodesList) {
			Way newWay = new Way(way);
			if (foundNodes.contains(child)) {
				numberOfExits++;
				continue;
			}
			newWay.addStep(child);
			if (child.exit) {
				numberOfExits++;
				ways.add(newWay);
				foundNodes.addAll(newWay.steps);
				return;
			} else {
				processNode(child, newWay);
			}
		}
	}
	
	private class Way {
		private List<GraphNode> steps = new ArrayList<GraphNode>();
		
		public Way() {}
		
		public Way(Way ways) {
			steps.addAll(ways.steps);
		}
		
		public void addStep(GraphNode step) {
			steps.add(step);
		}

		@Override
        public String toString() {
	        return "Way: steps=" + steps;
        }
		
	}
	
	public static void main(String[] args) {
		YaGraph graph = new YaGraph(15, 10);
//		System.out.println(graph);
		long statTime = System.currentTimeMillis();
		System.out.println(graph.findWays());
		long endTime = System.currentTimeMillis();
		System.out.println("It took: " + (endTime - statTime) + " ms");
//		for (int i = 0; i < graph.ways.size(); i++) {
//			System.out.println(i + 1 + ": " + graph.ways.get(i));
//		}
	}
}
