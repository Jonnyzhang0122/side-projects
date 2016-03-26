import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        return (int)calculate(s, 0, s.length() - 1);
    }
    
    private long calculate(String s, int start, int end) {
        int pos = start;
        long prevNum = 0, curNum = 0;
        char prevOperator = '?';
        while (pos <= end) {
            // skip spaces
            if (s.charAt(pos) == ' ') {
                ++pos;
                continue;
            }
            // if current is operator
            else if (s.charAt(pos) == '-' || s.charAt(pos) == '+') {
                prevOperator = s.charAt(pos);
                ++pos;
                continue;
            }
            // if current is number
            else if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                // get current number
                curNum = s.charAt(pos) - '0';
                ++pos;
                while (pos <= end && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                    long curDigit = s.charAt(pos++) - '0';
                    curNum = curNum * 10 + curDigit;
                }
            }
            // if current is bracket
            else if (s.charAt(pos) == '(') {
                // seek for when bracket end and call calculate recursively
                int bracketNum = 1;
                for (int i = pos + 1; i <= end; ++i) {
                    if (s.charAt(i) == '(') {
                        ++bracketNum;
                    }
                    else if (s.charAt(i) == ')') {
                        if (bracketNum == 1) {
                            curNum = calculate(s, pos + 1, i - 1);
                            pos = i + 1;
                            break;
                        }
                        --bracketNum;
                    }
                }
            }
            
            // do calculation if needed
            if (prevOperator == '-') {
                prevNum -= curNum;
            }
            else if (prevOperator == '+') {
                prevNum += curNum;
            }
            else {
                prevNum = curNum;
            }
        }
        return prevNum;
    }

    public static void main(String[] args) {
        BasicCalculator test = new BasicCalculator();
        System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(test.calculate("2147483647"));
    }
}