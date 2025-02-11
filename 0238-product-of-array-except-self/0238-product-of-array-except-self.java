import java.util.*;
// 2:17-2:41
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct=1;
        int[] result = new int[nums.length];
        Set<Integer> zeroMark = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if (num==0){
                zeroMark.add(i);
            } else {
                totalProduct=totalProduct * num ;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(!zeroMark.contains(i)){
                if(zeroMark.size()>0) result[i]=0;
                else result[i]=totalProduct/nums[i];
            } else {
                if(zeroMark.size()>1) result[i]=0;
                else result[i]=totalProduct;
            }
        }
        return result;
    }
}