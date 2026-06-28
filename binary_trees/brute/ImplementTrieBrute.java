package dsa.binary_trees.brute;

import java.util.ArrayList;
import java.util.List;
public class ImplementTrieBrute {






// Implement Trie - Brute Force
// Brute: Store all words in a list, search with startsWith — O(n*L)
// Optimal: TrieNode with children array, insert/search O(L)


    List<String> words = new ArrayList<>();

    public ImplementTrieBrute() {}

    // just add word to list
    public void insert(String word) {
        words.add(word);
    }

    // check if exact word exists
    public boolean search(String word) {
        return words.contains(word);
    }

    // check if any word starts with prefix
    public boolean startsWith(String prefix) {
        for (String w : words) {
            if (w.startsWith(prefix)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementTrieBrute trie = new ImplementTrieBrute();
        trie.insert("apple");
        System.out.println(trie.search("apple"));    // true
        System.out.println(trie.search("app"));      // false
        System.out.println(trie.startsWith("app"));  // true
        trie.insert("app");
        System.out.println(trie.search("app"));      // true
    }
}
