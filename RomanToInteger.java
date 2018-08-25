import java.util.HashMap;
import java.util.Map;

public  class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("I",1);
        hashMap.put("V",5);
        hashMap.put("X",10);
        hashMap.put("L",50);
        hashMap.put("C",100);
        hashMap.put("D",500);
        hashMap.put("M",1000);
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            int pre = hashMap.get(s.charAt(i) + "");
            int cur = 0;
            try {// 捕获 III 时候出现的异常
                cur = hashMap.get(s.charAt(i + 1) + "");
            }catch (StringIndexOutOfBoundsException e){
                result += pre;
                i++;
                continue;
            }
            if (pre < cur){
                result += (cur - pre);
                i += 2;
            }else{
                result += pre;
                i++;
            }
        }
        return result;
    }
}
