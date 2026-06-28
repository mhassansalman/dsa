package dsa.binary_trees.optimal;

import java.util.HashMap;
import java.util.Map;

// Trie - Optimal
// Two implementations: Array[26] and HashMap children
// Array: O(1) access, fixed 26 slots, lowercase only
// HashMap: O(1) avg, flexible for any characters

public class ImplementTrieOptimal {

    // ─── Implementation 1: Array[26] ─────────────────────────────────────────
    // Best when: only lowercase a-z, speed matters

    static class ArrayTrieNode {
        ArrayTrieNode[] children = new ArrayTrieNode[26];
        boolean isEnd = false;
    }

    static class ArrayTrie {
        ArrayTrieNode root = new ArrayTrieNode();

        public void insert(String word) {
            ArrayTrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';                              // 'a'=0 'b'=1 ... 'z'=25
                if (curr.children[idx] == null)
                    curr.children[idx] = new ArrayTrieNode();   // create slot if empty
                curr = curr.children[idx];                      // move down
            }
            curr.isEnd = true;                                  // mark end of word
        }

        public boolean search(String word) {
            ArrayTrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) return false;   // path missing
                curr = curr.children[idx];
            }
            return curr.isEnd;                                  // path exists AND complete word?
        }

        public boolean startsWith(String prefix) {
            ArrayTrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) return false;   // prefix path missing
                curr = curr.children[idx];
            }
            return true;                                        // prefix path exists
        }
    }

    // ─── Implementation 2: HashMap ────────────────────────────────────────────
    // Best when: characters beyond a-z, sparse children (saves space)

    static class HashTrieNode {
        Map<Character, HashTrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    static class HashTrie {
        HashTrieNode root = new HashTrieNode();

        public void insert(String word) {
            HashTrieNode curr = root;
            for (char c : word.toCharArray()) {
                // computeIfAbsent: create node only if missing, return it in one step
                curr = curr.children.computeIfAbsent(c, k -> new HashTrieNode());
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            HashTrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            HashTrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }
            return true;
        }
    }

    // ─── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        System.out.println("Array Trie:");
        ArrayTrie at = new ArrayTrie();
        at.insert("apple"); at.insert("app"); at.insert("application");
        System.out.println(at.search("apple"));      // true
        System.out.println(at.search("appl"));       // false
        System.out.println(at.startsWith("app"));    // true
        System.out.println(at.startsWith("apx"));    // false

        System.out.println("HashMap Trie:");
        HashTrie ht = new HashTrie();
        ht.insert("apple"); ht.insert("app"); ht.insert("application");
        System.out.println(ht.search("apple"));      // true
        System.out.println(ht.search("appl"));       // false
        System.out.println(ht.startsWith("app"));    // true
        System.out.println(ht.startsWith("apx"));    // false
    }
}

/*Takeaways for Implement Trie
1. Core Concept

Trie stores strings in tree structure

Each node represents one character

Path from root forms words/prefixes

Common prefixes are shared → memory efficient

2. Two Implementations

Aspect	Array[26]	HashMap
Memory	Fixed 26 slots/node	Only existing children
Speed	O(1) direct access	O(1) avg (hashing)
Characters	Lowercase only	Any character
Best For	Dense trie, speed	Sparse trie, flexibility
3. Operations (Both O(L))

Operation	Method	Key Point
Insert	Create path, mark isEnd	computeIfAbsent for HashMap
Search	Follow path, check isEnd	Must be complete word
StartsWith	Follow path only	No isEnd check needed
4. Brute vs Optimal

Approach	Time	Space	Method
Brute (List)	O(n×L)	O(n×L)	Store all words, scan each query
Trie	O(L)	O(n×L)	Tree structure, follow path
5. Key Insights

search = path exists + isEnd = true

startsWith = path exists only

isEnd flag marks complete words vs prefixes

Trie beats list for prefix operations

6. Edge Cases

Empty string → handle at root

Duplicate words → insert once (or ignore)

Words sharing prefixes → nodes shared

Word is prefix of another → isEnd handles both

7. When to Use

Autocomplete → prefix matching

Spell checker → word validation

Dictionary → fast word lookups

IP routing → prefix-based lookup

8. Memory Tip

Array[26] = faster, more memory

HashMap = flexible, less memory for sparse data

*/