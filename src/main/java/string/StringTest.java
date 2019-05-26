package string;

/**
 * Created by longyun on 2018/10/12.
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "12345";
        System.out.println(str);

        String s1 = str.substring(0, 1);//substring(int beginIndex, int endIndex), 从beginIndex到endIndex-1的字符串
        System.out.println("s1: " + s1);
        String s2 = str.substring(1);
        System.out.println("s2: " + s2);


        //String --> char[]
        char[] charArr = str.toCharArray();
        char ch = str.charAt(0);

        //char[] --> String
        String sss = new String(charArr);
        System.out.println(sss);

        char ch1 = 'a';
        char chLow = Character.toLowerCase(ch1);
        chLow = Character.toUpperCase(chLow);
        System.out.println(chLow);

        boolean bool1 = Character.isLetter(ch1);//判断字符是否是字母
        System.out.println(bool1);
        boolean bool2 = Character.isDigit(ch1);//判断字符是否是数字
        System.out.println(bool2);
        boolean bool3 = Character.isLetterOrDigit(ch1);//判断字符是否字符or数字
        System.out.println(bool3);


    }
}
