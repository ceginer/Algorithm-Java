import java.security.cert.PolicyQualifierInfo;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test11 {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        System.out.println(que.size());
        int a =que.size();
        int []A = new int[a];
        for (int i=0;i<a;i++){
            A[i] = que.poll();
            System.out.println(que.toString());
        }
        System.out.println(Arrays.toString(A));
    }
}
