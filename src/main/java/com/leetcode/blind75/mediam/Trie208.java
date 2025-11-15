package com.leetcode.blind75.mediam;

import java.util.ArrayList;
import java.util.List;

public class Trie208 {

    List<String> list;

    public Trie208() {
        list = new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        if(list.contains(word)) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        for(String str : list) {
            if(str.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie208 trie = new Trie208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
