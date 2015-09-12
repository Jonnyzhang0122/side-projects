// First Bad Version My Submissions Question Solution 
// Total Accepted: 6133 Total Submissions: 29239 Difficulty: Easy
// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Hide Tags Binary Search
// Hide Similar Problems (M) Search for a Range (M) Search Insert Position

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        
        int begin = 1, end = n;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (isBadVersion(mid) == true) {
                end = mid;
            }
            else {
                begin = mid;
            }
        }
        
        if (isBadVersion(begin) == true) {
            return begin;
        }
        else if (isBadVersion(end) == true) {
            return end;
        }
        
        return -1;
    }
}
