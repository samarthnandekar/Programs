package Trie;

public class TrieNode {

	TrieNode[] children; 
    // isEndOfWord is true if the node represents end of a word 
    boolean isEndOfWord; 
         
    public TrieNode() {
    	this.children = new TrieNode[26];
	}
    
}
