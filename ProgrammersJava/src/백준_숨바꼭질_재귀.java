import java.util.Scanner;

public class 백준_숨바꼭질_재귀 {

    // 재귀로 풀수 없음, 무한 루프에 걸릴수도 있음

    static int N,M;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        int answer = 0;

        answer = dfs(0,N);

        System.out.println(answer);
    }
    private static int dfs(int depth, int curIndex){
        if (curIndex == M) return depth;

        dfs(depth+1,curIndex+1);
        dfs(depth+1,curIndex-1);
        dfs(depth+1,curIndex*2);

        return -1; // 실패
    }
}
