import java.util.Stack;

public class TencentQuestion1 {
    /**
     * 假设给定一个由字母和小数点组成的字符串，
     * 把字符串按块翻转，
     * 其中连续的小数点为一块，
     * 连续的字母为一块。
     * 例如 'ab..bc...cd.' 翻转后为 '.cd...bc..ab'。
     */
    public static void function(String str) {
        Stack<Character> mStack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '.') {
                while (!mStack.empty()) {
                    System.out.print(mStack.pop());
                }
                System.out.print(str.charAt(i) + "");
            } else {
                mStack.push(str.charAt(i));
            }
        }
        while (!mStack.empty()) {
            System.out.print(mStack.pop());
        }
    }


    public static void main(String[] args) {
        function("ab..bc...cd.");
    }
}
