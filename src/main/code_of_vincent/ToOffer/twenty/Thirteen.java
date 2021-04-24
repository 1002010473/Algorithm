package ToOffer.twenty;

/**
 * @description:此处需要指出：该题目并不是需要找出矩阵中的所有节点，而是找出和0.0联通的节点数目
 * @author: 文琛
 * @time: 2019/11/29 14:48
 */
public class Thirteen {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return method(visited, 0, 0, k);
    }

    public int method(boolean[][] visited, int i, int j, int k){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || judge(i, j, k))
            return 0;
        visited[i][j] = true;
        int res = 1;
        res += method(visited, i - 1, j, k);
        res += method(visited, i + 1, j, k);
        res += method(visited, i, j - 1, k);
        res += method(visited, i, j + 1, k);
        return res;
    }

    public boolean judge(int i, int j, int k){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        while(j > 0){
            sum += j % 10;
            j /= 10;
        }
        return sum > k;
    }
}
