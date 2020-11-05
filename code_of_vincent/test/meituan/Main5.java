package test.meituan;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/9/6 10:59
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < m; i++){
            stack.addFirst(sc.nextInt());
        }
        Set<Integer> set = new HashSet<>();
        while(!stack.isEmpty()){
            int j = stack.removeFirst();
            if(!set.contains(j)){
                System.out.println(j);
                set.add(j);
            }
        }
    }
}
