import math
class Solution:
    def canMeasureWater(self, x: int, y: int, target: int) -> bool:
        x, y  = max(x,y), min(x,y)

        if target > x+y:
            return False

        if x + y == target:
            return True
        
        # m = math.ceil(x/y) * y - x

        # if target < y:
        #     if m == target:
        #         return True

        # z = (target - m)/y
        # print(z, m)
        # if z != int(z):
        #     if m + x == target:
        #         return True
        #     else:
        #         return False

        # if m + z*y == target or m + x == target:
        #     return True
        # else:
        #     return False

        s = set()

        l,r = x, 0
        flag = 0
        while True:
            flag +=1
        
            amt_needed_in_r = y - r
            if amt_needed_in_r > l:
                r = l
                l = 0
            else:
                l = l - amt_needed_in_r
                r = r + amt_needed_in_r
            

        
            # print(amt_needed_in_r, l,r)
            # if flag == 20:
            #     return False

            if (l,r) in s:
                return False
            else:
                s.add((l,r))

            if l == target or r == target or l+r == target:
                return True

            if r == y :
                r = 0
            if l == 0:
                l = x

                    


        
        return False
            




        