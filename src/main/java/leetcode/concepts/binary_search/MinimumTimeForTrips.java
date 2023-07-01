package leetcode.concepts.binary_search;

public class MinimumTimeForTrips {

    /**
     *  Time complexity: O(n log(m))
     *  - n is the length of the time array
     *  - m is the maximum product of the largest element in the time array, and the total number of trips
     *
     *  Space complexity: O(1) - we use constant space
     */
    public long minimumTime(int[] time, int totalTrips) {
        long low = 0;  // Start of our search space.
        long maxTime = 0;  // To find the maximum time in the array.
        for (int t : time) {
            maxTime = Math.max(maxTime, t);  // Finding maximum time in the array.
        }
        long high = maxTime * totalTrips;  // End of our search space.
        long minTime = high;  // Initialize minTime with high value.

        // Implementing Binary Search
        while (low <= high) {
            long mid = low + (high - low) / 2;  // Calculating middle value of search space.
            // If it is possible to complete totalTrips within mid time,
            // We update our minTime and try to find if there's a smaller value in the left part of search space.
            if (isPossible(time, totalTrips, mid)) {
                minTime = mid;
                high = mid - 1;
            } else {
                // If not possible, we search in the right part of our search space.
                low = mid + 1;
            }
        }
        return minTime;  // Return minimum time.
    }

    private boolean isPossible(int[] time, int totalTrips, long totalTime) {
        long trips = 0;  // To count the total trips that can be done in totalTime.
        for (int i = 0; i < time.length; i++) {
            trips += totalTime / time[i];  // Calculating total trips that can be done by i-th bus in totalTime.
        }
        return trips >= totalTrips;  // If total trips done is greater or equal to required totalTrips, return true.
    }
}
//https://leetcode.com/problems/minimum-time-to-complete-trips/