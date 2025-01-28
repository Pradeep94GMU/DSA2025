class Solution:
    def maxSubstringLength(self, s: str) -> int:
        freq = {}
        for i,a in enumerate(s):
            if a not in freq:
                freq[a] = [[float('inf'),-float('inf')],[]]
            freq[a][0][0] = min(i,freq[a][0][0])
            freq[a][0][1] = max(i,freq[a][0][1])
            freq[a][1].append(i)
        @cache
        def possible(l,r):
            for letter in freq:
                ll,rr = freq[letter][0]
                ii,jj = bisect.bisect_left(freq[letter][1],l),bisect.bisect_right(freq[letter][1],r)
                if ll > r or rr < l or (l<=ll and rr<=r) or ii==jj:
                    continue
                return False
            return True
        res = -1
        n = len(s)
        for l1 in freq:
            l = freq[l1][0][0]
            for l2 in freq:
                r = freq[l2][0][1]
                #print(l1,l2,l,r,possible(l,r))
                if r-l==n-1:continue
                elif possible(l,r):res = max(res,r-l+1)
        return res if res > 0 else -1


        

        