class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        win_sum = nums[0]
        res = nums[0]

        for i in range(1,len(nums)):
            if nums[i] <= nums[i-1]:
                win_sum = nums[i]
            else:
                win_sum += nums[i]
            res = max(res, win_sum)
            
        return res
            