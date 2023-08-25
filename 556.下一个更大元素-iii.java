/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution {
    public int nextGreaterElement(int n) {
        int[] arr = splitInt(n);
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i > 0) {
            int j = arr.length - 1;
            while (j >= i && arr[j] <= arr[i - 1]) {
                j--;
            }
            swap(arr, i - 1, j);

            reverse(arr, i, arr.length - 1);
            return aggArr(arr);
        } else {
            return -1;
        }
    }

    // for example, convert 213 to [2, 1, 3]
    int[] splitInt(int n) {
        List<Integer> arr = new ArrayList();
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        int[] result = new int[arr.size()];
        Arrays.setAll(result, i -> arr.get(i));

        reverse(result, 0, result.length - 1);
        return result;
    }

    // for example, convert [2, 1, 3] into 213
    int aggArr(int[] arr) {
        long result = 0;
        for (int i : arr) {
            result = result * 10 + i;
            if (result > ((1 << 31) - 1)) {
                return -1;
            }
        }
        return (int) result;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

}
// @lc code=end

