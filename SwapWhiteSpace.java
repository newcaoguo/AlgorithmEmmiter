import org.junit.Test;

public class SwapWhiteSpace {

    /**
     * 请实现一个函数，
     * 将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.
     * 则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        String mString = str.toString();
        return mString.replace(" ", "%20");
    }

    @Test
    public void test() {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
