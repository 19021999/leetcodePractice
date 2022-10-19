class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> answer = new ArrayList<>();
        int i=0;
        int j=1;
        int n = intervals.length;
        while(j < n) {
            if(intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                if(answer.size() == 0 || (answer.get(answer.size()-1)[1]) < intervals[j][0]) {
                    answer.add(intervals[i]);
                }
                j++;
            } else {
                if(answer.size() == 0) {
                    answer.add(intervals[i]);
                }
                answer.add(intervals[j]);
                i=j;
                j++;
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}