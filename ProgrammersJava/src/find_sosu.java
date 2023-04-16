import java.util.HashMap;
import java.util.HashSet;

public class find_sosu {
    static HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        String str = "5312";
        int [] A = {1,2,3,5,7};
        int n = 3;
        // 배열과 만들고 싶은 자릿수가 주어졌을 때,
        // n자리 숫자의 모든 조합을 만들어보고 싶음. 어떻게 할까?

        // 1. 재귀함수를 만들어서 모든 조합을 표현하자
        recursive("", str);

        System.out.println(numberSet);

    }
    public static void recursive(String comb, String others){

        // ====> 1. 탈출조건이나 예외조건 -> length가 0이되면서 찰출해짐 즉, for문에서 0부터 0이 되면 알아서 종료됨, 탈출조건 필요 X
            // 예외조건은? -> 처음 아무것도 없이 시작할 때

        // ====> 2. 어떻게 반복하는가?(for문) -> 한 숫자가 고정되고, 나머지가 남아있는 숫자 형태
            // 제일 처음 아무것도 없을 때는 고정 5,3,1,2 박고 싶었고
            // 만약 고정 하나 박았다고 쳤을 때, 3,1,2 계속 돌아가면서 고정 박고 싶잖어
            // 그러니까 고정된 숫자가 남은 숫자에 의해서 이어지면서 변함, 즉 반복은 index0부터 others.length까지

        // 그리고 고정이 이제 3,1,2 에서 1,2 로 바꼈을 때 뭘 바꾸고 싶어?
        // ==> 3. 반복하면서 "이전 것과 비교해서" 무엇이 변해?(매개변수로)
            // 고정된걸 set에 넣고 싶네, 그리고 바꼈을 때 "이전과"비교해서 뭐가 달라져?
            // 바로 고정값과 남아있는 값이지. 그게 어떻게 달라져? 그걸 파라미터에 넣을거야.
            // -> 처음이라 치더라도, 왠만하면 다 i야. 각각 다 처음 시작할 때는 i에서 시작해, 왜냐면 for문에서 돌리고 있는 와중일 거거든


        // 고정값이 5로 박혀진 채로 다시 고정값이 3 일 때, 1일 때, 2일 때, / 고정값이 5,3으로 박혀져 있는 채로 고정값이 1일 때, 2일 때
        // 어떤 것이 달라질까?
        // 그런데 뭐가 달라져를 알기 위해서는 마지막까지 간다음에 이전으로 돌아오면서 생각해야 알수가있어
        // 왜냐면 큰 관점에서 달라지는 걸 생각했을 때는 고정되는게 달라지는거 밖에 없거든
        // 하지만 여기에서는 각 단계를 통과할 때마다 set에 넣어줄 거라서 한 과정씩만 생각해도 충분히 해결할 수 있어
        // 만약 안된다면 그렇다면 마지막의 전단계인 고정이 다 되기 하나 전으로 가서 고정되는 과정을 봐바 ( 이런 문제는 아직보진 못했지만.. )


        // 1. 예외조건
        if (!comb.equals("")){
            numberSet.add(Integer.valueOf(comb));
        }
        // 2. 어떻게 반복하느냐?
        // recursive ("",str); 주어짐
        for(int i =0; i< others.length(); i++){
            // 3. 무엇이 변화하느냐?
            recursive(comb + others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }

    }
}
