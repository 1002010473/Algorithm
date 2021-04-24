package Algorithm.TopologicalSort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 不光判断，还要给出一个可行的顺序数组
 * @author: 文琛
 * @time: 2020/7/6 11:44
 */
public class lc210_课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //拓扑排序 -- BFS（队列） --
        int[] inDegree = new int[numCourses]; // 入度数组，存储index对应课程的入度
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            inDegree[arr[0]]++; // 更新入度
            edges.get(arr[1]).add(arr[0]); // 建立节点间的边界联系 index 指向 对应list中的元素
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(inDegree[i] == 0)
                queue.addLast(i);
        }
        while(!queue.isEmpty()){
            int n = queue.removeFirst();
            list.add(n);
            for(int i : edges.get(n)){
                if(--inDegree[i] == 0)
                    queue.addLast(i);
            }
        }
        if(list.size() < numCourses){
            return new int[0];
        }else{
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                res[i] = list.get(i);
            }
            return res;
        }

    }
}
