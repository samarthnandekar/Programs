package Graph;

import java.util.ArrayList;
import java.util.List;

public class _11_BinaryMaxHeap<T> {

	private List<Node> allNodes = new ArrayList<Node>();

    class Node {
        int weight;
        T data;
    }
    
	public void add(int weight,T data) {

        Node node = new Node();
        node.weight = weight;
        node.data = data;
        allNodes.add(node);
        int size = allNodes.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;

        while (parentIndex >= 0) {
            Node parentNode = allNodes.get(parentIndex);
            Node currentNode = allNodes.get(current);
            if (parentNode.weight < currentNode.weight) {
                swap(parentNode,currentNode);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }

    }
	
	 private void swap(Node node1,Node node2){
	        int weight = node1.weight;
	        T data = node1.data;
	        
	        node1.data = node2.data;
	        node1.weight = node2.weight;
	        
	        node2.data = data;
	        node2.weight = weight;
	    }
	 
	public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.data);
        }
    }
    
    public static void main(String args[]){
    	_11_BinaryMaxHeap heap = new _11_BinaryMaxHeap();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.printHeap();
    }
}
