import com.kaka.topic10.RegularExpressionMatching;
import org.junit.Test;

/**
 * @Author : kaka
 * @Date: 2021-11-21 17:09
 */
public class MyTest {
    @Test
    public void test(){
        String s = "aaabc";
        String p = "a*b.";
        RegularExpressionMatching matching = new RegularExpressionMatching();
        boolean f = matching.isMatch(s, p);

        System.out.println(f);
    }

}
