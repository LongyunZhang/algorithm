package dq;

/**
 * Created by longyun on 2018/11/10.
 */
public class LCS {
    public static void main(String[] args) {
        String A = "abcdfe";
        String B = "bcade";
        System.out.println(findLCS(A, B));
    }

    public static int findLCS(String A, String B) {
        int m = A.length() + 1;
        int n = B.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int getLIS(int[] arr,int n) {
        if(arr == null || n <= 0){ return 0; }
        int[] dp = new int[n]; int length = 0; int max = 0; dp[0] = 1;
        for(int i = 1; i < n; i++){
            length = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    if(dp[j] > length){
                        length = dp[j];
                    }
                }
            }
            dp[i] = length +1;
            if(dp[i] > max)
            { max = dp[i]; }
        }
        return max; }
}
