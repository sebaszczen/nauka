package sebaszczen.algorithms;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 6, 8, 5}));
    }

    public int solution(int[] blocks) {
        // write your code in Java SE 8
        int max=0;
        for (int i = 0; i < blocks.length; i++) {
            int maxi = 0;
            while (i < blocks.length - 2) {
                if (blocks[i] < blocks[i + 1]) {
                    maxi++;
                    i++;
                }
                else {
                    i = blocks.length;
                }
            }
            while (i >= 1) {
                if (blocks[i - 1] > blocks[i]) {
                    maxi++;
                    i--;
                } else {
                    i = 0;
                }
            }
            if (maxi > max) {
                max = maxi;
            }
        }
        System.out.println("cxx");
        return max;
    }
}