import java.util.Scanner;
// 백준 1548

public class 평균_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 필요한 건 합sum 과 최댓값max
        // 정수 N개로 숫자 개수 입력받기
        int N = in.nextInt();
        // 점수 입력받기
        int[] iNum = new int[N]; // => intA[] = new int[N]
        for (int i =0; i< iNum.length; i++){
            iNum[i] = in.nextInt();
        }
        long sum = 0;
        long max=0;
        // 최댓값 구하기, 총합 구하기
        for (int i=0; i< N; i++){
            if (iNum[i]>max) max = iNum[i];
            sum = sum + iNum[i];
        }
        System.out.println(sum*100.0/max/N);



    }
}
