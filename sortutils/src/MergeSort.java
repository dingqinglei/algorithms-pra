public class MergeSort implements Sort {
    @Override
    public void sortAsc(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        sortAsc(nums, left, mid);
        sortAsc(nums, mid + 1, right);
        mergeAsc(nums, left, mid, right);
    }

    private void mergeAsc(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid  && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        k = 0;
        i = left;
        while (i <= right) {
            nums[i++] = tmp[k++];
        }
    }

    private void mergeDesc(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid  && j <= right) {
            if (nums[i] > nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        k = 0;
        i = left;
        while (i <= right) {
            nums[i++] = tmp[k++];
        }
    }

    @Override
    public void sortDesc(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        sortDesc(nums, left, mid);
        sortDesc(nums, mid + 1, right);
        mergeDesc(nums, left, mid, right);
    }
}
