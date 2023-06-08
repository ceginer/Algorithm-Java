import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 백준_알람시계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minute = in.nextInt();

        int current = (hour*60 + minute);
        int alarm = current-45;

        if(alarm < 0){
            alarm = 60*24 - (45-current);
        }
        System.out.print(alarm/60 + " " + alarm%60);

    }
}
