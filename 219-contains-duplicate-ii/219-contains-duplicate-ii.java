class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.size() > 1) {
                for(int i = 1; i < list.size(); i++) {
                    if(Math.abs(list.get(i-1)-list.get(i)) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}