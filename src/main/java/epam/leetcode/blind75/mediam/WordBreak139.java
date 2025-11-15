package epam.leetcode.blind75.mediam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String str : wordDict) {
            if(!wordSet.contains(str)) {
                wordSet.add(str);
                if(s.contains(str)) {
                    s = s.replaceAll(str, " ").replaceAll("\\s+", "").trim();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordBreak139 solver = new WordBreak139();
        String s = "catsanddog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        boolean result = solver.wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result);
    }
}
