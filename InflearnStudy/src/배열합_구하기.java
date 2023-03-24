package src;

import java.util.Scanner;
// 백준 11720
public class 배열합_구하기 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // N에 숫자 개수 입력받기
        int N = in.nextInt();
        // sNum에 String으로 입력받기
        String sNum = in.next();
        // String 으로 받은 문자열 char[] 형으로 반환
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i =0; i < cNum.length; i++){
            sum += cNum[i] - '0'; // '0'은 아스키 코드 48
        }
        System.out.print(sum);
    }
}