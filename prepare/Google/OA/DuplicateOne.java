/* 
input range [1, 10,000,000]
1234 -> 11234, 12234, 12334, 12344 -> return 12344
1000 -> 11000, 10000 -> return 11000
9378 -> 99378, 93378, 93778, 93788 -> return 99378

methodology: loop from the left, once current number is larger than the next one (or is the last number), duplicate it
*/
public class DuplicateOne {
	public static int duplicateOne(int num) {
		// out of bound detection
		if (num < 1 || num > 10000000) {
			return -1;
		}

		StringBuilder res = new StringBuilder();
		String numS = "" + num;
		boolean duplicated = false;
		for (int i = 0; i < numS.length() - 1; ++i) {
			res.append(numS.charAt(i));
			if (!duplicated && numS.charAt(i) - numS.charAt(i + 1) > 0) {
				res.append(numS.charAt(i));
				duplicated = true;
			}
		}
		// last bit is not yet be appended
		res.append(numS.charAt(numS.length() - 1));
		// if duplication not executed, duplicate the last bit
		if (!duplicated) {
			res.append(numS.charAt(numS.length() - 1));
		}
		return Integer.parseInt(res.toString());
	}

	public static void main(String[] args) {
		int test1 = 1234;
		int test2 = 1000;
		int test3 = 9378;
		System.out.println(test1 + " -> " + DuplicateOne.duplicateOne(test1));
		System.out.println(test2 + " -> " + DuplicateOne.duplicateOne(test2));
		System.out.println(test3 + " -> " + DuplicateOne.duplicateOne(test3));
	}
}