import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        ans[0] = 1;
        // Prefix product
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Suffix product
        int suffix = 1;
        for (int j = n - 1; j >= 0; j--) {
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int nums[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Create an instance of Solution and call the method
        Solution sol = new Solution();
        int result[] = sol.productExceptSelf(nums);

        // Print the output array
        System.out.println("Output array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
