import java.util.Scanner;

public class 백준_상수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.print(Math.max(reverse(a),reverse(b)));
    }
    public static int reverse(int a){
        String num = String.valueOf(a);
        int acc = num.length();
        String answer = "";

        for(int i=0;i<num.length();i++){
            answer += num.charAt(acc-1)-'0';
            acc = acc -1;
        }
        return Integer.parseInt(answer);
    }
}
