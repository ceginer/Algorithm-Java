import java.util.*;


public class 정렬_k번째수 {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer2 = new int[commands.length];

            for(int i=0; i<commands.length;i++){
                int a= commands[i][0]-1;
                int b= commands[i][1]-1;
                int c= commands[i][2]-1;
                int answer1[] = new int[b-a+1];
                int k = 0;
                for (int j = a; j <= b; j++){
                    answer1[k] = array[j];
                    k++;
                }
                Arrays.sort(answer1);

                answer2[i]=answer1[c];
            }


            return answer2;
        }
    }
}
