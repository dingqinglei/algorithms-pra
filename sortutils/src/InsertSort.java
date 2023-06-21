/**
 * 实现插入排序
 *
 * @author dingqinglei
 */
public class InsertSort implements Sort {
    @Override
    public void sortAsc(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] < tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }
}
