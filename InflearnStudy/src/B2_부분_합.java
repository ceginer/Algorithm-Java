import java.io.*;
import java.util.StringTokenizer;

public class B2_부분_합 {
    public static void main(String[] args) throws IOException {
        // 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
        // 수를 100,000 개나 직접 읽어야 하므로 BufferdReader 사용
        // in.readLine() 할 때, 입력창 생기는거, StringTokenizer는 입력값 나누는 역할
        // 항상 자바 IO 할 때는 Stirng, int 인지 생각할 것!
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        // 한 줄에 2개 입력 받기, nextToken() -> 띄우기 기준 String 으로 하나씩 받는거
        int suNo = Integer.parseInt(token.nextToken());
        int quizNo = Integer.parseInt(token.nextToken());
        // 숫자들 입력 받기 전, 합 배열 만들기
        long[]S = new long[suNo];
        // 한 줄에 여러 숫자 입력받아 배열 토큰에 5,4,3,2,1 저장해놓기
        token = new StringTokenizer(in.readLine());
        S[0] = 0;
        for (int i = 1; i < suNo; i++){
            // 배열토큰에서 차례로 꺼내와서 합해주기
            S[i] = S[i-1] + Integer.parseInt(token.nextToken());
        }
        for (int i = 1; i < suNo; i++){
            token = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            System.out.println(S[b]-S[a-1]);
        }





    }
}
