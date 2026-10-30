

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Store element-frequency pairs
        List<int[]> pairs = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Sort pairs by frequency in descending order
        pairs.sort((a, b) -> b[1] - a[1]);

        // Take top k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pairs.get(i)[0];
        }

        return result;
    }
}