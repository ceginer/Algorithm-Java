import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_슬라이딩윈도우_DNA {
    // ADD 함수에 적히므로 미리 static 으로 만들어둠
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // S = DNA 문자열 길이, P = 부분문자열 길이
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];

        // checkArr = 체크 목적(int배열), myArr = 내 것(int배열), checkSecret = 정답 수
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        // DNA 모양 입력받기, A = char[]
        A = bf.readLine().toCharArray();
        // A,C,G,T 최소 개수 입력받기, st = token 배열
        st = new StringTokenizer(bf.readLine());

        // token 배열에 넣어주기, 0인 부분은 조건 충족한 것이므로 ++
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0)
                checkSecret++;
        }
        //제일 첫번째로 배열들을 따져볼 때,
        // 시작점 A[i=0]; , 끝점 = A[P(art) 부분문자열 길이 -1] => i<P 지정
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4)
            Result++;

        // 두번째 부분으로 가장끝과, 가장 첫번재만 변화되어지는 것에 착안
        // 지금은 2번째 부분이므로, 한 칸이 늘어났다고 생각해야됨.(원래 처음 부분을 코드쳐서 빼줄거임)
        // 시작점이 A[j = i(초기세팅:문자열 길이(P), ++되면서 1개씩 늘음)-P(부분 문자열 길이)],
        // 끝점에는 A[i(초기세팅:문자열 길이(S), ++ 되면서 인덱스 1개씩 늘어남)] 가 됨
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]); // 끝점 추가
            Remove(A[j]); // 시작점 삭제
            if (checkSecret == 4)  // 4자리 수에 대한 크기가 모두 충족되었을 때는 유효한 비밀번호
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }
    // 함수로 만들어주기 -> 드래그하고 ctrl + alt + m
    private static void Add(char c) { //새로 들어온 문자를 처리해주는 함수
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) { //제거되는  문자를 처리해주는 함수
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
