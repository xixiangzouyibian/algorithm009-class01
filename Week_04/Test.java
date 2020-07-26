import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        List list = Arrays.asList(new Integer[] {1, 2, 3});
        Stack stack = new Stack();
        stack.addAll(list);
        System.out.println(stack);
        while (!stack.empty()) {
            Integer num = (Integer) stack.pop();
            System.out.println(num);
        }
    }
}
