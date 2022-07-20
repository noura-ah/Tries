package com.codingdojo.tries;
public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        
        trie.printAllKeys();

        trie.insertWord("chip");
                
        trie.insertWord("trie");
        trie.insertWord("try");
        
        System.out.println(trie.isPrefixValid("try"));
        System.out.println(trie.isPrefixValid("tq"));
        
        System.out.println(trie.isWordValid("chip"));
        System.out.println(trie.isWordValid("ca"));
        System.out.println(trie.isWordValid("car"));
        System.out.println(trie.isWordValid("cat"));

        
        trie.printAllKeys();

        
    }
}
