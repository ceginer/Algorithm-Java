import java.util.Scanner;

public class Q_유니온파인드_집합표현하기 {
    static int parent[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 원소 개수 N
        int M = in.nextInt(); // 질의 개수 M
        // 각각의 대표노드를 표현하기 위해 parent[] 배열 만듬
        parent = new int[N+1];

        // 대표 노드 초기화, N 이하의 자연수~0 -> i =0 ~ N+1 까지로 만듬
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) { // 질의 계산
            int question = in.nextInt(); // 0(합) 또는 1(교)
            int a = in.nextInt();
            int b = in.nextInt();
            if (question == 0){ // union
                union(a,b);
            }else{ // 두 원소 같은지 보기
                boolean result = checkSame(a, b);
                // 1로 시작하는 줄마다 YES, NO 출력
                if(result) System.out.println("YES");
                else System.out.println("No");
            }
        }
    }
    private static void union(int a, int b){
        // 대표 노드 찾아서 연결
        a = find(a);
        b = find(b);
        // 대표 노드가 다르면 같게 만들 것
        // 같으면? 그냥 놔둬도 됨
        if (a!= b){
            parent[b] = a;
        }
    }
    private static int find(int a){
        if (a == parent[a]){// index 와 value 값이 똑같나?
            return a;
        }else{
            // 연결되는 노드의 value 값을,
            // 참조한 대표노드의 value 값으로 바꾸고,
            // 그 값을 return
            return parent[a] = find(parent[a]);
        }
    }

    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if (a==b) return true;
        return false;
    }
}
