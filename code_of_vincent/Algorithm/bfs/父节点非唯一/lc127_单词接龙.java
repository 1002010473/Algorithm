package Algorithm.bfs.父节点非唯一;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给定两个单词（beginWord 和 endWord）和一个字典数组，找到
 * 从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变 一个字母 。
 * 转换过程中的中间单词 必须 是字典中的单词。
说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 endword必须要在字典中，如果不在无法完成转换
 * @author: 文琛
 * @time: 2020/6/15 12:50
 */
public class lc127_单词接龙 {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength1(begin, end,list));
        System.out.println(ladderLength(begin, end,list));
    }
    //DFS : 深度优先遍历，递归压栈，返回path最小值
    //由于遍历数组和遍历字符串判断过于耗时而超时，lc题解中有相关改进，此处未更新
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        boolean[] flags = new boolean[wordList.size()];
        int res = fun1(beginWord, endWord, wordList, flags) ;
        return  res == wordList.size()+2 ? 0 : res;
    }

    private static int fun1(String beginWord, String endWord, List<String> wordList, boolean[] flags) {
        if(beginWord.equals(endWord))
            return 1;
        int res = wordList.size()+1;
        for(int i = 0; i < wordList.size(); i++){
            if(!flags[i] && besides(beginWord, wordList.get(i))){
                flags[i] = true;
                int j = fun1(wordList.get(i), endWord, wordList, flags);
                res = Math.min(res, j);
                flags[i] = false;
            }
        }
        return res+1;
    }

    private static boolean besides(String beginWord, String s) {
        boolean flag = false;
        for(int i = 0; i < beginWord.length(); i++){
            if(beginWord.charAt(i) != s.charAt(i)){
                if(!flag){
                    flag = true;
                }else{
                    return false;
                }
            }
        }
        return flag;
    }

    //BFS：广度优先遍历，通过队列来实现，碰到endword立即返回
    //通过
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        boolean[] flags = new boolean[wordList.size()];
        Deque<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        int length = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            length++;
            while(size-- > 0){
                String s = queue.removeFirst();
                if(endWord.equals(s))
                    return length;
                for(int i = 0; i < wordList.size(); i++){
                    if(!flags[i] && besides(s, wordList.get(i))){
                        queue.addLast(wordList.get(i));
                        flags[i] = true; //此处BFS对于flags的应用
                    }
                }
            }
        }
        return 0;
    }


}
