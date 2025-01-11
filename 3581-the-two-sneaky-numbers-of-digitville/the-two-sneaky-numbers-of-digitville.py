class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:

        res = {}
        for num in nums:
            if num in res:
                #alread dic me hai to update kr denge
                res[num] += 1
            else:
                res[num] = 1
        #iterte count and check the value
        print(res)
        result = []
        #key val so 2 items ek baar me nikalega
        for key, val in res.items():
            if val > 1:
                result.append(key)

        return result

        