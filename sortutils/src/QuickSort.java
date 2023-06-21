import java.util.Random;

/**
 * 实现快速排序
 */
public class QuickSort implements Sort {
    private int[] partitionAsc(int[] nums, int left, int right) {
        int l = left - 1;
        int r = right;
        int c = left;

        int pivot = getPivot(nums, left, right);
        swap(nums, pivot, right);

        while (c < r) {
            if (nums[c] < nums[right]) {
                swap(nums, ++l, c++);
            } else if (nums[c] > nums[right]) {
                swap(nums, --r, c);
            } else {
                c++;
            }
        }

        swap(nums, r++, right);
        return new int[]{l, r};
    }

    private int[] partitionDesc(int[] nums, int left, int right) {
        int l = left - 1;
        int r = right;
        int c = left;

        int pivot = getPivot(nums, left, right);
        swap(nums, pivot, right);

        while (c < r) {
            if (nums[c] > nums[right]) {
                swap(nums, ++l, c++);
            } else if (nums[c] < nums[right]) {
                swap(nums, --r, c);
            } else {
                c++;
            }
        }

        swap(nums, r++, right);
        return new int[]{l, r};
    }

    @Override
    public void sortAsc(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] p = partitionAsc(nums, left, right);
        sortAsc(nums, left, p[0]);
        sortAsc(nums, p[1], right);
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] p = partitionDesc(nums, left, right);
        sortDesc(nums, left, p[0]);
        sortDesc(nums, p[1], right);
    }

    private int getPivot(int[] nums, int left, int right) {
        Random random = new Random();
        return left + random.nextInt(right - left + 1);
    }
}
