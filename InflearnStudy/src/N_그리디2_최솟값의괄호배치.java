import java.util.Scanner;

public class N_그리디2_최솟값의괄호배치 {
    static int answer  = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String example = in.next();
        String[] str = example.split("-");
        // String 의 길이는 a.length(), 객체의 길이는 a.length
        for(int i =0;i<str.length;i++ ){
            int temp = mySum(str[i]);
            if(i==0)answer = answer + temp;
            else answer =answer - temp;
        }
        System.out.println(answer);
    }
    private static int mySum(String a){
        int sum = 0;
        // split 할 때, +는 "[+]" 로 나타내거나 "\\+" 로 나타내야만 한다.
        // split 할 때 String[] A 로 배열로 표시할 것!
        // (정규식으로 표현되기 때문)
        String[] temp = a.split("[+]");
        for (String i : temp){
            sum += Integer.parseInt(i);
        }
        return sum;
    }
}
