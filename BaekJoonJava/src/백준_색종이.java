import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준_색종이 {
    public static void main(String[] args) throws IOException {
        boolean[][] visited = new boolean[101][101];
        BufferedReader in = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int all = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=0;i<all;i++){
            st = new StringTokenizer(in.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            for(int a=fir;a<fir+10;a++){
                for(int b=sec;b<sec+10;b++){
                    if(visited[a][b] == false){
                        visited[a][b] = true;
                    } else{
                        count++;
                    }
                }
            }
        }

        System.out.print(100*all-count);
    }
}
