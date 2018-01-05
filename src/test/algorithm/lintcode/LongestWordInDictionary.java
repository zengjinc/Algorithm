package test.algorithm.lintcode;

import java.util.HashMap;
import java.util.Stack;
/*
 * 给定�?个字符串列表words，找到words�?长的word，使得这个word可用words中的其他word�?次一个字符地构建。如果有多个可�?�答案，则返回最长的且具有最小字典序的word�?
 * 
 *  Trie，又称单词查找树或键树，是一种树形结构�?�典型应用是用于统计和排序大量的字符串（但不仅限于字符串），�?以经常被搜索引擎系统用于文本词频统计�?
 *  它的优点是：�?大限度地减少无谓的字符串比较，查询效率比哈希表高�?
 *  
 *	它有3个基本�?�质�?
 *	1.根节点不包含字符，除根节点外每一个节点都只包含一个字符�??
 *	2.从根节点到某�?节点，路径上经过的字符连接起来，为该节点对应的字符串�?
 *	3.每个节点的所有子节点包含的字符都不相同�??	
 *
 *	Trie中每个节点有�?个特殊标记作为结束符号，通过该标记可以判断当前节点是否是�?个字符串的终结节�?
 *  把每个word放入Trie中，对Trie进行DFS，只搜索终结节点。每个找到的节点中（除了根）从根到该节点路径代表该节点的word�?  
 *  如果当前word合题，且长度大于ans，或长度等于ans但字典序小于ans，则修改ans为当前word�?
 *  
 *  时间复杂度：O(sum(w_i))，w_i是words[i]的长度�?�这是构建和便利Trie的复杂度。如果使用BFS而不是DFS，并且把每个节点的子节点进行排序�?
 *  那么我们就不�?要再去检查当前的word时�?�比ans要好，后访问的节点一定要好于先访问的节点，但复杂度不变�??
 *  空间复杂度：O(sum(w_i))用于构建Trie�?
 *	
 *  Input: words = ["w","wo","wor","worl", "world"]
 *  Output: "world"
 *  
 *  Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 *  Output:"apple"
 */
public class LongestWordInDictionary {
	public static void main(String[] args) {
//		String[] words = new String[]{"w","wo","wor","worl", "world"};
		String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
		Trie trie = new Trie(words);
		int index = 0;
		for(String word : words){
			trie.insert(word, ++index);
		}
//		System.out.println(trie.root);
		System.out.println(trie.dfs());
	}
}

class Node{
	char c;
	int end;	//end非零表示这是�?个终结节点，且end-1对应的就是该word在words中的索引
	HashMap<Character,Node> children = new HashMap<>();
	public Node(char c){
		this.c = c;
	}
//	@Override
//	public String toString() {
//		return "Node [c=" + c + ", end=" + end + ", children=" + children + "]";
//	}
	
}

class Trie{
	Node root;
	String[] words;
	public Trie(String[] words){
		root = new Node('0');
		this.words = words;
	}
	
	public void insert(String word, int index){
		Node cur = root;
		for(char c : word.toCharArray()){
			if(!cur.children.containsKey(c)){
				cur.children.put(c, new Node(c));
			}
			cur = cur.children.get(c);
		}
		cur.end = index;
//		System.out.println(cur);
	}
	
	public String dfs(){
		String ans = "";
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.empty()){
			Node node = stack.pop();
			if(node.end > 0 || node == root){
				if(node != root){
					String word = words[node.end - 1];
					if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0){
						ans = word;
					}
				}
				for(Node nei : node.children.values()){
					stack.push(nei);
				}
			}
		}
		return ans;			
	}
}
