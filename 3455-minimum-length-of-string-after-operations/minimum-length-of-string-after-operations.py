class Solution:
    def minimumLength(self, s: str) -> int:
        freq = [0] * 26

        for ch in s:
            freq[ord(ch) - ord('a')] += 1
        
        print(freq)
        count = 0
        # now, just take each freq and check the freq
        for eachFr in freq:
            if eachFr == 0: 
                continue
            elif eachFr % 2 == 0: #hame even char delete krne ke baad sirf 2 hi bachega, abababababaaaaa
                count += 2
            else:
                count += 1 

        return count

        