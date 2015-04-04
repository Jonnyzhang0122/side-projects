public class Solution {
  
    public int[] searchRange(int[] A, int target) {


        if (A == null){
            int[] range = {-1, -1};
	    	return range;
    	}  

    	//start part
        int rangeStart = -1, rangeEnd = -1;
    	int start = 0;
    	int end = A.length - 1;
    	int mid;
    	int judge = 0;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A[mid] == target){
    			end = mid;
    		}
    		else if (A[mid] > target){
    			end = mid;
    		}
    		else if (A[mid] < target){
    			start = mid;
    		}
    	}

    	if (A[start] ==  target){
    		rangeStart = start;
    		++judge;
    	}
    	else if (A[end] == target){
            rangeStart = end;
    		++judge;
    	}
			
		//end part
    	start = 0;
    	end = A.length - 1;

    	while (start + 1 < end){
    		mid = start + (end - start) / 2;
    		if (A[mid] == target){
    			start = mid;
    		}
    		else if (A[mid] > target){
    			end = mid;
    		}
    		else if (A[mid] < target){
    			start = mid;
    		}
    	}

    	if (A[end] == target){
            rangeEnd = end;
    		++judge;
    	}
    	else if (A[start] ==  target){
            rangeEnd = start;
    		++judge;
    	}

    	if (judge > 0){
            int[] range = {rangeStart, rangeEnd};
    		return range;
    	}

        int[] range = {-1, -1}; 
    	return range;

    }
}

