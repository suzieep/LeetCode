//12:40
//12:55
//01:46 timeout
//01:59 to set
class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> originNums = new HashSet<>();
        Set<Integer> subsequences = new HashSet<>();
        Set<Integer> numsArray = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int num:nums){
            double sqrtedNum = Math.sqrt(num);
            if(sqrtedNum%1==0.0 && numsArray.contains((int)sqrtedNum)){
                subsequences.add((Integer) num);
                if(Math.sqrt(sqrtedNum)%1!=0.0||
               Math.sqrt(sqrtedNum)%1==0.0&&!numsArray.contains((int) Math.sqrt(sqrtedNum))){
                    originNums.add((int) sqrtedNum);
                }
            }
        }
        if(subsequences.size()==0){
            return -1;
        }

        int maxSquareStreak=0;
        for(int originNum:originNums){
            int squareStreak = getStreakSquareCnt(originNum,subsequences,1);
            maxSquareStreak = Math.max(maxSquareStreak,squareStreak);
        
        }
        return maxSquareStreak;
    }
    
    private int getStreakSquareCnt(int origin, Set<Integer> subsequences,int squareStreak){
        Integer subsequence = origin*origin;
        if(subsequences.contains(subsequence)){
                return getStreakSquareCnt(subsequence,subsequences,++squareStreak);
        } 
        return squareStreak;
    }

}