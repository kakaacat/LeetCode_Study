import org.junit.Test;

import java.util.Random;

/**
 * @Author : kaka
 * @Date: 2021-11-21 17:09
 */
public class MyTest {
    @Test
    public void test(){
        int left = 0;
        int right = 5;
        Random random = new Random(System.currentTimeMillis());
        int randomInt = random.nextInt(right - left);
    }

}
