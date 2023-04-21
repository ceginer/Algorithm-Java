import java.util.*;

public class 그리디_체육복 {

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] A = new int[n+1];

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i : reserve){
                A[i] = 1;
            }
            for (int i : lost){
                A[i] = A[i]-1;
            }
            // System.out.println("1" + Arrays.toString(A));


            for(int i : reserve){
                if(A[i] == 1){
                    if(A[i-1] == -1){
                        A[i-1] = 0;
                        A[i] = 0;
                    }else if (i != n && A[i+1] == -1){
                        A[i+1] = 0;
                        A[i] = 0;
                    }
                }
            }

            // System.out.println("2" + Arrays.toString(A));


            for (int i : A){
                if (i == 0 || i == 1){
                    answer++;
                }
            }

            return answer-1; // A[0]은 제외
        }
    }
}
