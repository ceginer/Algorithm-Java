public class 완전탐색_피로도 {
    class Solution {
        // 1. dfs 를 하기 위해선 방문배열 필요
        //2. 계속해서 최대던전 수를 count 해준다.
        public static boolean visited[];
        public static int count = 0;

        public int solution(int k, int[][] dungeons) {

            visited = new boolean [dungeons.length];
            dfs(dungeons, k, 0);

            return count;
        }


        private void dfs(int[][] dungeons, int fatigue, int depth ){

            for (int i=0; i<dungeons.length; i++){
                if(!visited[i] && fatigue >= dungeons[i][0] ){
                    visited[i] = true;

                    dfs(dungeons, fatigue - dungeons[i][1], depth +1);
                    visited[i] =false;
                }
            }
            count = Math.max(count, depth);
        }
    }
}
