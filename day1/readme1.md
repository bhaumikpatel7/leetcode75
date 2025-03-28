Here's the Java code for the "Product of Array Except Self" problem, along with a detailed explanation of the approach to help you post it on GitHub.

---

### Problem: Product of Array Except Self

**Problem Statement:**

Given an integer array `nums`, return an array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

**Example:**

```text
Input:  [1,2,3,4]
Output: [24,12,8,6]
Explanation: 
  For index 0, the product of all elements except `nums[0]` is 2 * 3 * 4 = 24.
  For index 1, the product of all elements except `nums[1]` is 1 * 3 * 4 = 12.
  For index 2, the product of all elements except `nums[2]` is 1 * 2 * 4 = 8.
  For index 3, the product of all elements except `nums[3]` is 1 * 2 * 3 = 6.
```

**Note:**
1. You must solve it without using the division operator.
2. Do it in O(n) time complexity.

### Approach:

This solution uses the concept of prefix and suffix products to efficiently calculate the desired product for each element.

- **Prefix Product:** The product of all elements to the left of the current index.
- **Suffix Product:** The product of all elements to the right of the current index.

The idea is to calculate the prefix product for each element first and then update the result by multiplying it with the suffix product (in the second pass, moving from right to left).

### Solution:

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        // Step 1: Initialize the first element of the result array to 1
        ans[0] = 1;
        
        // Step 2: Calculate the prefix products (left side)
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 3: Calculate the suffix products (right side) and update the result
        int suffix = 1;
        for (int j = n - 1; j >= 0; j--) {
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }

        // Return the final result array
        return ans;
    }
}
```

### Explanation of the Code:

1. **Initialization:**
   - We initialize an array `ans[]` of the same length as `nums[]` to store the result.
   - The first element of `ans[]` is set to 1, because there are no elements to the left of index 0.

2. **First Pass (Prefix Product Calculation):**
   - In this loop, we calculate the prefix product for each element in `nums[]`. The prefix product for an element `i` is the product of all elements to its left. We store this in `ans[i]`.

3. **Second Pass (Suffix Product Calculation):**
   - In this loop, we calculate the suffix product for each element. The suffix product for an element `i` is the product of all elements to its right.
   - We use a variable `suffix` to keep track of the cumulative product while traversing the array from right to left.
   - We then multiply the current value of `ans[i]` (which holds the prefix product) by the `suffix` to get the final product for the index.

4. **Return the Final Result:**
   - After both passes, the `ans[]` array will contain the product of all elements except the one at each index.

### Time and Space Complexity:

- **Time Complexity:** O(n), where n is the length of the input array. The solution makes two passes over the array: one for the prefix products and one for the suffix products.
  
- **Space Complexity:** O(1), excluding the space for the result array. We use constant space for the `suffix` variable and modify the `ans[]` array in place.

### Test Cases:

```java
// Example 1
Solution sol = new Solution();
System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {1, 2, 3, 4})));
// Output: [24, 12, 8, 6]

// Example 2
System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {0, 0})));
// Output: [0, 0]
```

