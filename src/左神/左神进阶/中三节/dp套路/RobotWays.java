package 左神.左神进阶.中三节.dp套路;


/**
 * @description:进阶第7节末尾，阿里加试题
 * 给定N个位置，机器人一开始在M位置上，该机器人可以在1-N范围内任意左右行走P步，问其最终停留在K位置上的走法有多少种
 * @author: 文琛
 * @time: 2020/6/5 10:36
 */
public class RobotWays {
    public static void main(String[] args) {
        System.out.println(ways(3,1,3,3));
    }
    //1-N上N个位置, 在递归中，M为当前位置
    public static int ways(int N, int M, int P, int K){
        if(N < 2 || M < 1 || M > N || P < 0|| K < 1 || K > N)
            return 0;
        if(P == 0){
            return M == K ? 1 : 0;
        }
        //可能性讨论
        if(M == 1){
            return ways(N, M+1, P-1,K);
        }else if(M == N){
            return ways(N,M-1,P-1,K);
        }else{
            return ways(N,M-1,P-1,K)+ways(N,M+1,P-1,K);
        }
    }
    //动态规划：参数： M和P，在P=0时，只有M = K时，为1，其它为0，求解P=P时，M=M的值
}
