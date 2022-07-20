package com.codingdojo.tries;
public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix) {
        Node currentNode = this.root;
    	for(int i = 0; i < prefix.length(); i++) {
            currentNode = currentNode.children.get(prefix.charAt(i));
            
            //if currentNode (letter) doesn't exist return false 
            if (currentNode == null) {
            	return false;
            }
    	}
    	return true;
    }
    
    
    public boolean isWordValid(String word) {
    	Node currentNode = this.root;
    	for(int i = 0; i < word.length(); i++) {
    		currentNode = currentNode.children.get(word.charAt(i));
            
            //if currentNode(letter) doesn't exist return false 
            if (currentNode == null) {
            	return false;
            }
    	}
    	
    	// different between isPrefixValid and isWordValid is that we need to check this condition
    	return currentNode.isCompleteWord;
    }
    
    public void printAllKeys() {
        Node currentNode = this.root;
        printAllKeys(currentNode);
        System.out.println();
    }
    
    private Node printAllKeys(Node currentNode) {
    	
    	for (Character key: currentNode.children.keySet()) {
    		System.out.print(key+" ");
    		printAllKeys(currentNode.children.get(key));
    	}
    	return null;
    }
}
