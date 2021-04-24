package test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/6/28 20:04
 */
public class StringTest1 {
    public static void main(String[] args) {
        String a = "A";
        String a1= new String("A");
        String a2 = "A";
        //String b = new String("B");
        String c = "C";
        String d = "A" + c;
        String e = "A" + "C";
        String f;
        final String g;
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        ConcurrentHashMap<String, Integer> ccmap = new ConcurrentHashMap<>();


        System.out.println(a == a1);
        System.out.println(a.equals(a1));
        System.out.println(a == a1.intern());
        System.out.println(a == a2);
        System.out.println(d == e);

    }
}
class test1{
    String b;
    final String a;
    public test1(){
        a = "";
    }
}
