import java.util.Arrays;
import java.util.Random;

public interface Sort {
    void sortAsc(int[] nums, int left, int right);

    void sortDesc(int[] nums, int left, int right);

    default void printArr(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    default void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    default void testAsc() {
        for (int i = 0; i < 10000; i++) {
            int[] origin = getRandomArr();
            int[] copied = copyArr(origin);
            sortAsc(origin, 0, origin.length - 1);
            Arrays.sort(copied);
            if (!Arrays.equals(origin, copied)) {
                System.out.println("asc测试失败");
                return;
            }
        }
        System.out.println("asc测试成功");
    }

    default void testDesc() {
        for (int i = 0; i < 10000; i++) {
            int[] origin = getRandomArr();
            int[] copied = copyArr(origin);
            sortDesc(origin, 0, origin.length - 1);
            Arrays.sort(copied);
            reverse(copied);
            if (!Arrays.equals(origin, copied)) {
                System.out.println("desc测试失败");
                return;
            }
        }
        System.out.println("desc测试成功");
    }

    default void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    default int[] getRandomArr() {
        Random random = new Random();
        int len = random.nextInt(1000);

        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(300);
        }
        return nums;
    }

    default int[] copyArr(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }
}
