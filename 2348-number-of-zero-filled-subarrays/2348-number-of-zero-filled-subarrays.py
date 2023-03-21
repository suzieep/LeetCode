class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        saving = False
        cnt = 0
        saved =[]
        result = 0
        for num in nums:
            if num!=0:
                if cnt>0:
                    saved.append(cnt)
                    cnt = 0
                saving = False
            else:
                saving = True
                cnt +=1
        if cnt>0:
            saved.append(cnt)
            cnt = 0      

        saved=list(reversed(sorted(saved)))
        for n in saved:
            result += n*(n+1)//2
            
        return result