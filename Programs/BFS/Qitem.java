package BFS;


//A queue item to store word and minimum chain length to reach the word. 
class Qitems 
{ 
String word; 
int len; 


public Qitems(String start, int l) {
	 word=start;
	 len=l;
}

}