public class 구현_행렬덧셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {


            int str1 = arr1.length;
            int str2 = arr1[0].length;

            int[][] answer = new int[str1][str2];

            for (int i =0;i<str1;i++){
                for(int j=0;j<str2;j++){
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            return answer;
        }
    }
}
