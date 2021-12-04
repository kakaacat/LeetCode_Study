import com.kaka.LC11_20.topic18.SortAnArray;

/**
 * @Author : kaka
 * @Date: 2021-12-03 10:26
 */
public class Test {
    @org.junit.Test
    public void mytest(){
        SortAnArray sortAnArray = new SortAnArray();
        int[] nums = {5,2,3,1,4};
        nums = sortAnArray.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
