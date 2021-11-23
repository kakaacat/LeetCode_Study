import org.junit.Test;

/**
 * @Author : kaka
 * @Date: 2021-11-21 17:09
 */
public class MyTest {
    @Test
    public void test(){
       int flag1 = Integer.MAX_VALUE;
       int flag2 = flag1 / 10;
       int flag3 = flag2 * 10 + 8;
       int flag4 = flag2 * 10 + 7;
        System.out.println(flag1 + "\n" + flag2 + "\n" + flag3 + "\n" + flag4);
    }

}
