import java.util.PriorityQueue;

class Solution {
    class Point {
        public int x;
        public int y;
        public double distToOrigin;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distToOrigin = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][1];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                ((b[0] * b[0] + b[1] * b[1]) - a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < points.length; i++) {
            minHeap.add(points[i]);
        }

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
