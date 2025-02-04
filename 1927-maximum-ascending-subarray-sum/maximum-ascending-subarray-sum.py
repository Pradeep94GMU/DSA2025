class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        res = 0
        win_sum = nums[0]

        if len(nums) == 1:
            return nums[0]

        for i in range(1,len(nums)):
            res = max(res, win_sum)
            if nums[i] <= nums[i-1]:
                win_sum = nums[i]
            else:
                win_sum += nums[i]
            res = max(res, win_sum)
        return res
            