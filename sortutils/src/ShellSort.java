/**
 * 实现希尔排序
 *
 * @author dingqinglei
 */
public class ShellSort implements Sort {
    @Override
    public void sortAsc(int[] nums, int left, int right) {
        for (int w = nums.length >> 1; w >= 1; w >>= 1) {
            for (int i = left + w; i <= right; i += w) {
                int j = i;
                int tmp = nums[i];
                while (j > left && nums[j - w] > tmp) {
                    nums[j] = nums[j - w];
                    j -= w;
                }
                nums[j] = tmp;
            }
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        for (int w = nums.length >> 1; w >= 1; w >>= 1) {
            for (int i = left + w; i <= right; i += w) {
                int j = i;
                int tmp = nums[i];
                while (j > left && nums[j - w] < tmp) {
                    nums[j] = nums[j - w];
                    j -= w;
                }
                nums[j] = tmp;
            }
        }
    }
}
