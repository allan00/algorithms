package nowcoder;

/**
 * Created by ping on 2015/9/4.
 */
/**
 * ���Ӽ�������ת��Ϊ0-1��������
 * dp[i][j]�ĺ��壺����Ϊj�ı����е�ǰi����Ʒ�����м�ֵ�Ӽ����ܼ�ֵ
 * ���ƹ�ϵ��
 * j-arr[i]>=0,dp[i][j] = max{dp[i-1][j],arr[i] + dp[i-1][j-arr[i]]};
 * j-arr[i]< 0,dp[i][j] = dp[i-1][j]��
 */

