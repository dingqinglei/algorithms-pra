import java.util.Arrays;

/**
 * 实现冒泡排序
 *
 * @author dingqinglei
 */
public class BubbleSort implements Sort {

    @Override
    public void sortAsc(int[] nums, int left, int right) {
        for (int i = right - 1; i >= 0; i--) {
            for (int j = left; j <= i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        for (int i = right - 1; i >= 0; i--) {
            for (int j = left; j <= i; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
