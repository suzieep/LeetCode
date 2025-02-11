class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int start = 0;
        int end = 1;
        
        while(start<s.length()&&s.length()>0){
            String subString = s.substring(start,end);
            Set<String> charSet = new HashSet<>(Arrays.asList(subString.split("")));
            if(subString.length()!=charSet.size()){
                start++;
            } else if (subString.length()> maxCount){
                maxCount = subString.length();
                if(end<s.length()){
                    end++;
                }
            } else {
                if(end<s.length()){
                    end++;
                } else{
                    start++;
                }
            }
        }
        return maxCount;

    }
}