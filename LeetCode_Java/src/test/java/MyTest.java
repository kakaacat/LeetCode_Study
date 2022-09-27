import org.junit.Test;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2021-11-21 17:09
 */
public class MyTest {
    @Test
    public void test(){
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        char c = ')';

        Deque<Character> stack = new LinkedList<Character>();
        stack.push('(');
        System.out.println(stack.peek());
        System.out.println(c);
        System.out.println(pairs.get(c));
        System.out.println(pairs.get(c) == stack.peek());
    }

}
