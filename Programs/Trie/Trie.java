package Trie;

public class Trie {

	static TrieNode root;
	
	Trie()
	{
		root = new TrieNode();
	}
	
	static void insert(String word) 
    {  
        int length = word.length();         
        TrieNode pCrawl = root; 
        for (int level = 0; level < length; level++) 
        { 
          int  index = word.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
            {
            	TrieNode temp= new TrieNode();
            	pCrawl.children[index] =temp;
            	pCrawl=temp;
            }
            else
            {
            	pCrawl = pCrawl.children[index];
            }
        } 
        // mark last node as leaf 
        pCrawl.isEndOfWord = true; 
    } 
       
	// Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEndOfWord)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
 
    TrieNode find(String word){
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null){
                return null;
            }
            cur=cur.children[c-'a'];
        }
        return cur;
    }
    
    public TrieNode searchNode(String s){
        TrieNode p = root;
        
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.children[index]!=null){
                p = p.children[index];
            }else{
                return null;
            }
        }
        if(p==root)
            return null;
 
        return p;
    }
    
    /** Deletes a word and sub words **/
    boolean delete_old(String word) {
    	TrieNode node=searchNode(word);
    	
    	if(node==null)
    		return false;//no such word
    	
    	boolean noChild=true;    
    	
    	for(TrieNode t:node.children){
    	    if(t!=null)
    	    	noChild=false;
    	}
    	
    	if(noChild){
    	    node=null;//node is the leaf, so we just delete it.
    	}else{
    	    node.isEndOfWord=false;//node is not the leaf, we can just set node.isEnd to false.
    	}
    	return true;
    }
    
    static boolean hasNoChild(TrieNode currentNode){
		for (int level = 0; level < currentNode.children.length; level++) {
			if(currentNode.children[level]!=null){
				return false;
			}
		}
		return true;
	}
    
    static boolean deleteUtil(TrieNode currentNode,String key,int level,int length){
    	
		if(currentNode==null){
			System.out.println("Does not exist");
			return false;
		}
		if(level==length){
			currentNode.isEndOfWord=false;
			if(hasNoChild(currentNode)){
				return true;
			}else{
				return false;
			}
		}else{
			TrieNode childNode=currentNode.children[key.charAt(level)-'a'];
			boolean childDeleted=deleteUtil(childNode, key, level+1, length);
			if(childDeleted){
			    return childDeleted;
			    		//(currentNode.isEndOfWord && hasNoChild(currentNode));
			}
		}
		return false;
	}
    
	static boolean delete(String key){
		int length=key.length();
		return deleteUtil(root,key,0,length);	
	}
    
    public static void main(String args[]) 
    { 
      	Trie node= new Trie();
    	node.insert("abc");
    	node.insert("abcd");
    	node.insert("samarth");
    	
    	System.out.println("is aab present --->"+ node.search("aab"));
    	System.out.println("is abc present --->"+ node.search("abc"));
    	System.out.println("delete abc -->"+node.delete("abc"));
    	
    	System.out.println("====after delete====");
    	System.out.println();
    	System.out.println("is abc present --->"+node.search("abc"));
    	System.out.println("is abcd present --->"+node.search("abcd"));
    	
    	boolean t=node.delete("abcd");
    	
    	System.out.println("-->"+t);
    	
    	System.out.println("abcd present after delete -->" +node.search("abcd"));
    	
    	node.search("samarth");
    }
}
