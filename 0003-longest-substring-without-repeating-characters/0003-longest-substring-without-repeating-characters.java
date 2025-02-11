class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        List<String> elements = s.isEmpty() ? new ArrayList<>() : new ArrayList<>(Arrays.asList(s.split("")));
        List<String> currentList = new LinkedList<>();
        Set<String> currentSet = new HashSet<>();

        for (int i = 0; i < elements.size(); i++) {
            String current = elements.get(i);
            while (currentSet.contains(current)) {
                currentSet.remove(currentList.removeFirst());
            }
            currentSet.add(current);
            currentList.addLast(current);
            maxCount = Math.max(currentSet.size(), maxCount);
        }
        return maxCount;
    }
}