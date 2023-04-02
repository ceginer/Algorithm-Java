
import java.util.*;
import java.io.*;

public class F_큐_카드게임 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Queue 는 항상 LinkedList 로 사용
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i<= N; i++){
            myQueue.add(i);
        }
        // queue 가 1이되면 종료
        // poll 은 pop 처럼 호출과 동시에 제거됨.
        while(myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.peek());
    }
}
