// Two Sum III - Data structure design My Submissions Question Solution 
// Total Accepted: 3518 Total Submissions: 13938 Difficulty: Easy
// Design and implement a TwoSum class. It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
// Hide Tags Hash Table Data Structure
// Hide Similar Problems (M) Two Sum

public class TwoSum {
    private HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

	public void add(int number) {
	    if (!numMap.containsKey(number)) {
	        numMap.put(number, 0);
	    }
	    else {
	        numMap.put(number, 1);
	    }
	}

	public boolean find(int value) {
	    for (int key : numMap.keySet()) {
	        int another = value - key;
	        if (numMap.containsKey(another)) {
	            if (key == another) {
	                if (numMap.get(another) == 1) {
	                    return true;
	                }
	            }
	            else {
    	            return true;	                
	            }
	        }
	    }
	    
	    return false;
	}
}
