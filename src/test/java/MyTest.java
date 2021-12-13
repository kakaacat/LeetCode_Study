import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * @Author : kaka
 * @Date: 2021-11-21 17:09
 */
public class MyTest {
    @Test
    public void test(){
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        System.out.println(integers.size());
    }

}
