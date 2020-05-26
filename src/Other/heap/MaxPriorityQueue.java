package Other.heap;

/**
 * @description: 大根堆
 * 删除最大值 和 添加元素 的数量级 都为 logN
 * @author: 文琛
 * @time: 2019/12/24 11:32
 */
public class MaxPriorityQueue {
    private int[] pq;  //基于完全二叉树 数组 实现的堆
    private int N = 0;  // 元素存储于pq[1...N]中，pq[0]并没有使用-----从1开始，左子=2n，右子=2n+1，父=n/2

    //构造函数  初始化 MaxN +1 大小的数组
    public MaxPriorityQueue(int MaxN){
        pq = new int[MaxN+1];
    }

    //查询是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //查询元素数目
    public int size(){
        return N;
    }

    //插入元素
    //将元素放在堆（数组）的末尾，然后上浮
    public void insert(int v){
        pq[++N] = v;
        swim(N);
    }

    //删除最大--index==1
    public int delMax(){
        int del = pq[1];
        pq[1] = pq[N--];
        pq[N+1] = 0;
        sink(1);
        return del;
    }
    //下沉--小的往后走
    //父节点小于子节点，则父节点和子节点中较大的那一个进行交换
    private void sink(int k) {
        while (2*k<=N){
            int j = 2*k;//j=左子的index
            if (j<N && pq[j]<pq[j+1]) j++;//j=max（左，右）的index
            if (pq[k]>=pq[j]) break;
            //进行交换
            int temp = pq[k];
            pq[k] = pq[j];
            pq[j] = temp;
            k = j;//将k改变为和其交换的index
        }
    }
    //上浮--大的元素往前走
    //子节点大于父节点，则子节点和父节点进行递归交换
    private void swim(int k) {
        //k -- index of array （start from 0）
        //在 k == 1 时，不再循环----上浮到头了
        while (k>1 && pq[k]>pq[k/2]){
            int temp = pq[k];
            pq[k] = pq[k/2];
            pq[k/2] = temp;
            k = k/2;
        }
    }


}
