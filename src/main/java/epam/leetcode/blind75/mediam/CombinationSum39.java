package epam.leetcode.blind75.mediam;
import java.util.ArrayList;
import java.util.List;

class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remaining < 0) return;

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(res, path, candidates, remaining - candidates[i], i); // reuse allowed
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = new CombinationSum39().combinationSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
