// Combination Sum Total Accepted: 47657 Total Submissions: 170524 My Submissions Question Solution 
// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 
// Hide Tags Array Backtracking

import java.util.*;

public class CombinationSum {
    private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
        	return result;
        }

        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<Integer>();
        comHelper(candidates, target, path, 0);

        return result;
    }

    private void comHelper(int[] candidates, int target, ArrayList<Integer> path, int index) {
    	int pathSum = 0;
    	for (int i = 0; i < path.size(); ++i) {
    		pathSum += path.get(i);
    	}
    	if (pathSum == target) {
    		result.add(new ArrayList<Integer>(path));
    	}
    	else if (pathSum > target) {
    		return;
    	}

    	int prev = Integer.MIN_VALUE;
    	for (int i = index; i < candidates.length; ++i) {
    		if (prev != Integer.MIN_VALUE && candidates[i] == prev) {
    			continue;
    		}
    		path.add(candidates[i]);
    		comHelper(candidates, target, path, i);
    		path.remove(path.size() - 1);
    		prev = candidates[i];
    	}
    }
}