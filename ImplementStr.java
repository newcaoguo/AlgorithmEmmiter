public class ImplementStr {

    // "mississippi","issipi"
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (haystack != null && haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            final int index = i;
            int count = 0;
            for (int j = 0; j < needle.length() && (i + j ) < haystack.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)){
                    count++;
                }else{
                    break;
                }
            }
            if (count == needle.length()){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("",""));
    }

}
