public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if (str == null || str.length == 0) return 0;
        return str[str.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("        "));
    }
}
