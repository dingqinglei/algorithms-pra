import java.util.Arrays;

/**
 * 实现选择排序
 *
 * @author dingqinglei
 */
public class SelectSort implements Sort {
    @Override
    public void sortAsc(int[] nums, int left, int right) {
        for (int i = 0; i <= right; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j <= right; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        for (int i = 0; i <= right; i++) {
            int max = nums[i];
            int maxIndex = i;
            for (int j = i + 1; j <= right; j++) {
                if (nums[j] < max) {
                    max = nums[j];
                    maxIndex = j;
                }
            }

            if (i != maxIndex) {
                swap(nums, i, maxIndex);
            }
        }
    }
}
