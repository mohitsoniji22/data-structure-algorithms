package com.leetcode.blind75.mediam;

class WordDictionary211 {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private final TrieNode root;

    public WordDictionary211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        // If we reached end of word
        if (index == word.length())
            return node.isWord;

        char ch = word.charAt(index);

        if (ch != '.') {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            return dfs(word, index + 1, node.children[idx]);
        }

        // if ch == '.'
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, index + 1, child))
                return true;
        }


        return false;
    }

    public static void main(String[] args) {
        WordDictionary211 wordDictionary = new WordDictionary211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}

