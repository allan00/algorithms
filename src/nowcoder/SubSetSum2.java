package nowcoder;

/**
 * Created by ping on 2015/9/4.
 */
/**
 * 将子集和问题转化为0-1背包问题
 * dp[i][j]的含义：承重为j的背包中的前i个物品中最有价值子集的总价值
 * 递推关系：
 * j-arr[i]>=0,dp[i][j] = max{dp[i-1][j],arr[i] + dp[i-1][j-arr[i]]};
 * j-arr[i]< 0,dp[i][j] = dp[i-1][j]。
 */

