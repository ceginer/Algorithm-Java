import java.util.*;


public class 구현_카카오다트게임 {

    class Solution {
        public int solution(String dartResult) {
            int answer = 0;

            int n = 0;
            int k = 0;
            String[] str = new String[3];

            // 1. 숫자 나올때마다 앞에서 끊어서 배열
            int loop = 2;
            while (loop <= dartResult.length()){
                if(n == 2){
                    str[n] = dartResult.substring(k);
                    break;
                }
                if(Character.isDigit(dartResult.charAt(loop))){
                    str[n] = dartResult.substring(k,loop);
                    k = loop;
                    n++;
                    loop++;
                }
                loop++;
            }

            int[] sum = {0,0,0};
            int loc =0;

            for(int i=0;i<3;i++){
                if(Character.isDigit(str[i].charAt(1))){
                    sum[i] += 10;
                    loc = 2;
                    // System.out.println(sum[i]);
                } else{
                    // 1번 index
                    sum[i] += str[i].charAt(0)-'0';
                    loc = 1;
                    // System.out.println(sum[i]);
                }

                // 2번 index
                if (str[i].charAt(loc) == 'D'){
                    sum[i] = sum[i]*sum[i];
                } else if (str[i].charAt(loc) == 'T'){
                    sum[i] = sum[i]*sum[i]*sum[i];
                }
                loc ++;
                // System.out.println(sum[i]);
                // System.out.println("loc :" +loc);

                // 3번 index
                if(str[i].length() > loc ){
                    if (str[i].charAt(loc) == '*'){
                        sum[i] *= 2;
                        if(i > 0){
                            sum[i-1] *= 2;
                        }
                    } else if (str[i].charAt(loc) == '#'){
                        sum[i] *= (-1);
                    }
                    // System.out.println(sum[i]);
                }
            }

            int result = sum[0] + sum[1]+ sum[2];
            // System.out.println(result);

            return result;
        }
    }
}
