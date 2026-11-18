class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            boolean canFinish = canFinishInTime(piles, h, mid);

            if (canFinish) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFinishInTime(int[] piles, int h, int speed) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += ((long) pile + speed - 1) / speed;
        }

        return totalHours <= h;
    }
}