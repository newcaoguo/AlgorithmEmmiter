public class CountAndSay {

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     */
    public static String countAndSay(int n) { // n = 5
        int i = 1;
        String res = "1";
        while (i < n) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0); // c = "1"
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {
                    count++; // count = 1
                } else {
                    sb.append(count); // sb = 1
                    sb.append(c); // sb = 11
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString(); // res = "11"
            i++; // i = 2
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
