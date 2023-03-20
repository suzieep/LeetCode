class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        emptybeds=''.join(map(str,[0]+flowerbed+[0])).split('1')
        cnt = 0
        for section in emptybeds:
            if len(section)>2:
                cnt+=(len(section)-1)//2
        return cnt>=n
        