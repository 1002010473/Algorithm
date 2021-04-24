package Algorithm.TopologicalSort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: DAG--有向无环图
 * 入度：有向图中一个边指向某个节点，那么该节点的入度+1；
 * 入度为0，说明没有依赖其它节点，可以将该节点抛出，并将相关连其它节点的入度--；
 * 可以通过拓扑排序实现DAG的判断，如果循环完毕所有节点都已经处理完毕，那么即没有环，也没有双向边(也是一个环)
 * @author: 文琛
 * @time: 2020/7/6 10:35
 */
public class lc207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //拓扑排序 -- BFS（队列） -- 6ms
        int[] inDegree = new int[numCourses]; // 入度数组，存储index对应课程的入度
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            inDegree[arr[0]]++; // 更新入度
            edges.get(arr[1]).add(arr[0]); // 建立节点间的边界联系 index 指向 对应list中的元素
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(inDegree[i] == 0)
                queue.addLast(i);
        }
        while(!queue.isEmpty()){
            int n = queue.removeFirst();
            numCourses--;
            for(int i : edges.get(n)){
                if(--inDegree[i] == 0)
                    queue.addLast(i);
            }
        }
        return numCourses == 0;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        //拓扑排序 -- DFS -- 4ms
        int[] inDegree = new int[numCourses]; // 入度数组，存储index对应课程的入度
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            inDegree[arr[0]]++; // 更新入度
            edges.get(arr[1]).add(arr[0]); // 建立节点间的边界联系 index 指向 对应list中的元素
        }
        boolean[] flags = new boolean[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            method(i, flags, inDegree,edges);
        }
        for(boolean flag : flags){
            if(!flag)
                return false;
        }
        return true;
    }
    public static void method(int i, boolean[] flags, int[] inDegree, List<List<Integer>> edges){
        if(!flags[i] && inDegree[i] == 0){ // flags == true 的节点说明已经抛出了，不能再遍历一遍其对应的list了，不然重复减去了indegree，造成错误
            flags[i] = true;
            for(int j : edges.get(i)){
                inDegree[j]--;
                method(j, flags, inDegree, edges);
            }
        }
    }

    public static void main(String[] args) {
        int i = 4;
        int[][] arr = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        boolean flag = canFinish1(i, arr);
        System.out.println(flag);
    }
}
