import java.util.Scanner;
import java.util.Stack;
public class E강의_스택과큐_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력할 스택의 개수 N
        int N = sc.nextInt();
        // 스택들, int 배열 A
        int[]A = new int[N];
        // 배열에 숫자들 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        // 시작 num
        int num = 1; // 오름차순 수
        boolean result = true;


        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 수열의 수
            if (su >= num) { //현재 수열 값 >= 오름차순 자연수 : 값이 같아 질 때까지 push()수행
                while (su >= num) { // push()
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {  //현재 수열 값 < 오름차순 자연수: pop()을 수행하여 수열 원소를 꺼냅니다
                int n = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수 보다 크다면 수열 출력 불가능
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } //
                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
