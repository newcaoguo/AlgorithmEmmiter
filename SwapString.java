import java.lang.reflect.Field;

public class SwapString {
    public static void main(String[] args) throws Exception {
        String str1 = "a";
        String str2 = "b";

        System.out.println("before: str1: " + str1 + " str2: " + str2);
        System.out.println("str1 == a : " + (str1 == "a"));
        System.out.println("str1 == b : " + (str1 == "b"));
        System.out.println("str2 == a : " + (str2 == "a"));
        System.out.println("str2 == b : " + (str2 == "b"));
        System.out.println("str1.equals(\"a\") : " + str1.equals("a"));
        System.out.println("str1.equals(\"b\") : " + str1.equals("b"));
        System.out.println("str2.equals(\"a\") : " + str2.equals("a"));
        System.out.println("str2.equals(\"b\") : " + str2.equals("b"));
        swap(str1, str2);
        System.out.println("after: str1: " + str1 + " str2: " + str2);
        System.out.println("str1 == a : " + (str1 == "a"));
        System.out.println("str1 == b : " + (str1 == "b"));
        System.out.println("str2 == a : " + (str2 == "a"));
        System.out.println("str2 == b : " + (str2 == "b"));
        System.out.println("str1.equals(\"a\") : " + str1.equals("a"));
        System.out.println("str1.equals(\"b\") : " + str1.equals("b"));
        System.out.println("str2.equals(\"a\") : " + str2.equals("a"));
        System.out.println("str2.equals(\"b\") : " + str2.equals("b"));
    }

    private static void swap(String str1, String str2) throws Exception {
        Object temp;

        Field fv = String.class.getDeclaredField("value");
//        Field fh = String.class.getDeclaredField("hash");

        fv.setAccessible(true);
//        fh.setAccessible(true);

        temp = fv.get(str1);
        fv.set(str1, fv.get(str2));
        fv.set(str2, temp);

//        fh.setInt(str1, 0);
//        fh.setInt(str2, 0);
    }
}
