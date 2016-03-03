import java.util.*;

public class MaxPathLen {
	public static int maxLen(String input) {
		String[] paths = input.trim().split("\n");
		
		Stack<Integer> stack = new Stack<>();
		int maxLen = 0;
		int curLen = 0;
		int prevSpace = 0; //  to indicate the level
		for (String curPath : paths) {
			// count the spaces ahead
			int space = 0;
			for (int i = 0; i < curPath.length(); ++i) {
				if (curPath.charAt(i) == ' ') {
					++space;
				}
				else {
					break;
				}
			}

			// for same level or level up (do not need to pop if level down)
			if (space <= prevSpace) {
				// pop out all content including the same level
				for (int i = 0; i < prevSpace - space + 1 && !stack.isEmpty(); ++i) {
					curLen -= stack.pop();
				}
			}
			prevSpace = space;
			// append current path len
			int curLevelLen = curPath.length() - space + 1; // +1 for the slash
			curLen += curLevelLen;
			stack.push(curLevelLen);

			// check if it is image
			if (curPath.endsWith(".jpeg") || curPath.endsWith(".gif") || curPath.endsWith(".png")) {
				// System.out.println("Found an image: " + curLen);
				maxLen = Math.max(maxLen, curLen);
			}

		}
		return maxLen;
	}

	public static void main(String[] args) {
		String test1 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\ndddir\nddddir\n aaa.exe\n";
		System.out.println("Input:\n" + test1);
		System.out.println(MaxPathLen.maxLen(test1));
	}
}