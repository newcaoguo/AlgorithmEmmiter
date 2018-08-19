import java.lang.reflect.Field;

public class SwapNumber {
    public static void main(String[] args) throws Exception {

        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(2);
        System.out.println("before : a: " + a + " b: " + b);
        System.out.println(a == Integer.valueOf(1));
        System.out.println(a == Integer.valueOf(2));
        System.out.println(b == Integer.valueOf(1));
        System.out.println(b == Integer.valueOf(2));
        System.out.println(a.equals(Integer.valueOf(1)));
        System.out.println(b.equals(Integer.valueOf(2)));
        swap(a, b);
        System.out.println("after : a: " + a + " b: " + b);
        System.out.println(a == Integer.valueOf(1));
        System.out.println(a == Integer.valueOf(2));
        System.out.println(b == Integer.valueOf(1));
        System.out.println(b == Integer.valueOf(2));
        System.out.println(a.equals(Integer.valueOf(1)));
        System.out.println(b.equals(Integer.valueOf(2)));
    }

    private static void swap(Integer a, Integer b) throws Exception {

        Field field = a.getClass().getDeclaredField("value");
        field.setAccessible(true);
        int temp = a;
        field.setInt(a, b);
        field.setInt(b, temp);
    }
}
