import java.util.*;
import java.io.*;
class Dijkstra {
	// maintain 2 sets
	// set 1 will contain visited nodes
	// set 2 will contain not visited nodes
	// maintain minimum cost path. Initiallly all the paths will cost INF except first

	public int findMin(int[] arr, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i=0; i<arr.length; i++) {
			if (!visited[i] && arr[i]<min) {
				min = arr[i];
				minIndex = i;
			}
		}
		System.out.println(minIndex+" "+min);
		return minIndex;
	}

	public void findShortestPath(int[][] adjMatrix, int source) {
		// maintain visited nodes
		boolean[] visited = new boolean[adjMatrix.length];
		int[] cost = new int[visited.length];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[source] = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(source);
		while(list.size() < visited.length) {
			printArray(cost);
			int min = findMin(cost, visited);
			for (int i=0; i<adjMatrix[0].length; i++) {
				if (i != min && adjMatrix[min][i] != 0 && !visited[i] && cost[i]>cost[min]+adjMatrix[min][i]) {
					cost[i] = cost[min]+adjMatrix[min][i];
				}
			}
			visited[min] = true;
			list.add(min);
		}
		printArray(cost);
	}

	public void printArray(int[][] arr) {
		for(int[] ar:arr) {
			for(int val:ar) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
	public void printArray(int[] ar) {
		for(int val:ar) {
			System.out.print(val+" ");
		}
		System.out.println();

	}
}
