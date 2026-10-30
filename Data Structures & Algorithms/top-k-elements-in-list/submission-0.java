class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        int[] res = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    res[index++] = val;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }
        
        return res;
    }
}