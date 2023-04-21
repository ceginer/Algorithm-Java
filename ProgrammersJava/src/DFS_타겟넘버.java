
public class DFS_타겟넘버 {

    // 그래프의 형식에서 각 노드가 일정하게 2개씩, 혹은 n개씩 나누어질 때
    // 이러한 방식처럼 for문 없이 dfs 2번 사용함으로써 각각의 노드마다 2개의 노드가 나올 수 있도록 하는 방식도 유용할 듯 싶다.
    // 물론 백준 숨바꼭질 처럼 각각에 3개씩의 노드가 적용되어도,
    // 그 깊이를 특정 개수만큼 제한할 수 없으면 계속된 DFS로 스택오버플로우가 발생하므로 이에 유의해서 사용하도록 하자.

    class Solution {
        static int[] numbers;
        static int target;
        static int answer;

        public int solution(int[] numbers, int target) {
            answer = 0;
            this.numbers = numbers;
            this.target = target;

            dfs(0, 0);
            return answer;
        }
        private static void dfs(int depth, int sum)  {
            if(depth == numbers.length){
                if (sum == target){
                    answer++;
                }
                return;
            }


            dfs(depth +1, sum + numbers[depth]);
            dfs(depth +1, sum - numbers[depth]);
        }

    }
}
