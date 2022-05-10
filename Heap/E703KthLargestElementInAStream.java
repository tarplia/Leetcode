/* Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 * (1) KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * (2) int add(int val) Appends the integer val to the stream and
 * returns the element representing the kth largest element in the stream.
*/

import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        storeDataInHeaps(nums);
    }

    private void storeDataInHeaps(int[] nums) {
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
                minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
