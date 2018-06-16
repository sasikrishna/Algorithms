package com.algorithms.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 	Inserting strings and searching for all strings with given prefix using TRIE data structure.
 * 
 * @author Sasi Jolla on 13-Jun-2018, 12:56:51 am
 */
public class Contacts {
	
	private static final Scanner scanner = new Scanner(System.in);
	static Trie trie = new Trie();
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            
            if("add".equals(op)){
            	addContact(contact);
            	continue;
            }
            
            findContact(contact);
        }

        scanner.close();
	}
	
	private static void addContact(String contact){
		
		Trie tempTrie = trie;
		Character nodeChar;
		for(int i = 0; i < contact.length(); i++){

			nodeChar = contact.charAt(i);
			Trie tempTrieNode = tempTrie.nodes.get(nodeChar);
			if(tempTrieNode == null){
				tempTrieNode = new Trie(nodeChar);
				tempTrie.nodes.put(nodeChar, tempTrieNode);
			}
			
			tempTrie = tempTrie.nodes.get(nodeChar);
		}
		
		tempTrie.isEndOfWord = true;
	}
	
	private static void findContact(String prefix){
		
		Trie tempTrie = trie;
		int index = 0, preFixLength = prefix.length();
		for(index = 0; index < preFixLength; index++){
			tempTrie = tempTrie.nodes.get(prefix.charAt(index));
			if(null == tempTrie){
				System.out.println(0);
				return;
			}
		}
		
		System.out.println("Total strings with prefix " + prefix + " are " + wordCount(tempTrie)) ;
	}
	
	private static int wordCount(Trie node){
		
		if(null == node){
			return 0;
		}
		
		int wordCount = 0;
		if(node.nodes.size() > 0){
			for(Entry<Character, Trie> entry : node.nodes.entrySet()){
					wordCount += wordCount(entry.getValue());
			}
		}
		
		return wordCount + (node.isEndOfWord ? 1 : 0);
	}
	
	static class Trie{
		Character nodeChar;
		Map<Character, Trie> nodes;
		Boolean isEndOfWord = false;
		
		public Trie(){
			nodes =  new HashMap<Character, Contacts.Trie>();
		}
		
		public Trie(Character nodeChar){
			this.nodeChar = nodeChar;
			nodes =  new HashMap<Character, Contacts.Trie>();
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Trie [nodeChar=");
			builder.append(nodeChar);
			builder.append(", nodes=");
			builder.append(nodes);
			builder.append(", isEndOfWord=");
			builder.append(isEndOfWord);
			builder.append("]");
			return builder.toString();
		}
	}
}
