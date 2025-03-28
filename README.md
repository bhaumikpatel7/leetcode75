# leetcode75
Here's a well-formatted solution for the "Product of Array Except Self" problem that you can use for posting on GitHub:

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

1. We will use two auxiliary arrays:
   - `left[]`: This array will store the product of all elements to the left of the current index.
   - `right[]`: This array will store the product of all elements to the right of the current index.
   
2. The final product array is calculated by multiplying the corresponding elements from `left[]` and `right[]`.

3. To optimize space, we can compute the product array in-place using only one array (`output[]`), with a running product from the left and the right.

### Solution:

```python
class Solution:
    def productExceptSelf(self, nums):
        # Initialize the output array
        output = [1] * len(nums)
        
        # Calculate the product of elements to the left of each index
        left_product = 1
        for i in range(len(nums)):
            output[i] = left_product
            left_product *= nums[i]

        # Calculate the product of elements to the right of each index
        right_product = 1
        for i in range(len(nums) - 1, -1, -1):
            output[i] *= right_product
            right_product *= nums[i]

        return output
```

### Explanation:

1. **Initialization:**
   - We start by initializing an `output` array where each element is initially set to `1`. This will hold the final product values.

2. **Left Product Calculation:**
   - We traverse the array from left to right, and for each element, we store the product of all the previous elements in `output[i]`. We use a variable `left_product` to keep track of the cumulative product of all elements before the current element.

3. **Right Product Calculation:**
   - After calculating the left product, we traverse the array from right to left. For each element, we multiply `output[i]` by the cumulative product of all elements after it. We use a variable `right_product` to keep track of the cumulative product of all elements after the current element.

4. **Final Output:**
   - The final output array contains the desired result.

### Time and Space Complexity:

- **Time Complexity:** O(n), where n is the length of the input array. We make two passes over the array (one for left products and one for right products).
- **Space Complexity:** O(1) (excluding the space for the output array). We use constant space for `left_product` and `right_product`.

### Test Cases:

```python
# Example 1
sol = Solution()
print(sol.productExceptSelf([1,2,3,4]))  # Output: [24, 12, 8, 6]

# Example 2
print(sol.productExceptSelf([0, 0]))  # Output: [0, 0]
```

---

Feel free to copy this into your GitHub repository! This format includes code comments, a problem description, and explanations for each part of the solution, which will make your post look professional and clear.
