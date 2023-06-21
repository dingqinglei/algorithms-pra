/**
 * 基数排序
 *
 * @author dingqinglei
 */
public class RadixSort implements Sort {

    /**
     * 返回num的倒数第pos位的数据
     *
     * @param num
     * @param pos
     * @return
     */
    private int locate(int num, int pos) {
        int res = 0;
        while (pos > 0) {
            res = num % 10;
            num /= 10;
            pos--;
        }
        return res;
    }

    /**
     * 将count数组转换为前缀和数组
     *
     * @param count
     */
    private void prefixSum(int[] count) {
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }

    /**
     * 返回n的长度
     *
     * @param n
     * @return
     */
    private int bits(int n) {
        int len = 1;
        while (n > 0) {
            n /= 10;
            len++;
        }
        return len;
    }

    /**
     * 返回nums中长度最长的数字的长度
     *
     * @param nums
     * @return
     */
    private int maxBits(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = bits(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, bits(nums[i]));
        }
        return max;
    }

    /**
     * 算法的基本思路是，从个位开始，统计每一个数字的词频
     * 将这个词频转换为前缀和数组，然后根据这个前缀和数组，
     * 逆序遍历前缀和数组，将数字放在指定的拷贝数组上，为
     * 什要逆序遍历前缀和数组，不是正序遍历前缀和数组？？
     *
     * 从后往前是不是为了保证稳定性？？应该是为了保证稳定性，这样后面的数字永远会排在后面
     * 123 213 112 231
     * 0 1 1 2 0 0 0 0 0 0
     * 0 1 2 4 4 4 4 4 4 4
     *
     * @param nums
     * @param left
     * @param right
     */
    @Override
    public void sortAsc(int[] nums, int left, int right) {
        // 获得这批数据里面长度最长的数字的长度
        int iterNum = maxBits(nums);

        for (int i = 1; i <= iterNum; i++) {
            // 根据第i位生成词频数组count
            int[] count = new int[10];
            for (int num : nums) {
                int val = locate(num, i);
                count[val]++;
            }
            prefixSum(count);
            int[] tmp = new int[nums.length];
            for (int j = nums.length - 1; j >= 0; j--) {
                int val = locate(nums[j], i);
                int index = --count[val];
                tmp[index] = nums[j];
            }

            System.arraycopy(tmp, 0, nums, 0, tmp.length);
        }
    }

    private void reversePrefixSum(int[] count) {
        for (int i = count.length - 1; i > 0; i--) {
            count[i -1] += count[i];
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        // 获得这批数据里面长度最长的数字的长度
        int iterNum = maxBits(nums);

        for (int i = 1; i <= iterNum; i++) {
            // 根据第i位生成词频数组count
            int[] count = new int[10];
            for (int num : nums) {
                int val = locate(num, i);
                count[val]++;
            }
            // 反向求逆序和即可
            reversePrefixSum(count);
            int[] tmp = new int[nums.length];
            for (int j = nums.length - 1; j >= 0; j--) {
                int val = locate(nums[j], i);
                int index = --count[val];
                tmp[index] = nums[j];
            }

            System.arraycopy(tmp, 0, nums, 0, tmp.length);
        }
    }
}
