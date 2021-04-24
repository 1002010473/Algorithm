package test;

import java.util.*;

/**
 * @description:
 * 两门选修课， 每个选修的学生都有成绩， 找出同时选修两门课的学生
 * 两个list， list中放置的是对象 -- name - score
 * 学生选出来之后，排序
 * 按照成绩和降序，name降序排列
 * 返回name-- list
 * @author: 文琛
 * @time: 2020/8/27 14:51
 */
public class Main1 {
    public static void main(String[] args) {

    }
    public static List<String> method(List<Student> list1, List<Student> list2){
        //确定都选的student 集合
        Map<String, Student> map = new HashMap<>();
        for(Student s : list1){
            map.put(s.name, s);
        }
        List<Student> list = new ArrayList<>();//放入的是list2里面的student对象
        for(Student s: list2){
            if(map.containsKey(s.name)){
                list.add(s);
            }
        }
        //通过大根堆实现按照score和降序获取
        PriorityQueue<Student> maxPQ = new PriorityQueue<>((a,b) -> b.score - a.score);
        //将score和计算出来
        for(Student s: list){
            Student s1 = map.get(s.name);
            s.score += s1.score;
            maxPQ.add(s);
        }
        Student[] students = new Student[list.size()];
        int i = 0;
        while(!maxPQ.isEmpty()){
            students[i++] = maxPQ.remove();
        }
        //统计分数相同的范围
        int j  = 0;
        while(j < students.length){
            int start = j;
            while(j + 1 < students.length && students[j + 1].score == students[j].score){
                j++;
            }
            if(j != start){
                fun(students, start, j);
            }
        }
        List<String> res = new ArrayList<>();
        for(Student s : students){
            res.add(s.name);
        }
        return res;
    }

    private static void fun(Student[] students, int start, int j) {
        //按照字典序排列
        String[] strs = new String[j - start + 1];
        int k = 0;
        for(int i = start; i <= j; i++){
            strs[k++] = students[i].name;
        }

        //先写一个排序

    }

}
class Student {
    String name;
    int score;
    public Student(String name, int score){
        this. name  = name ;
        this.score = score;
    }
}
