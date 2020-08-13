package test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/2 9:46
 */
public class TEST {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];*/
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        LinkedList<Integer> ll = (LinkedList<Integer>) l;
        Integer first = ll.getFirst();
        System.out.println(first);
        Deque<Integer> l1 = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(-2147483648 > 2147483647);
        HashMap<Integer, Integer> map1 = new HashMap<>();
        Vector<Integer> v = new Vector<>();
        ConcurrentHashMap<Integer, Integer> ccmap = new ConcurrentHashMap<>();
        ccmap.putIfAbsent(1,1);
        ConcurrentMap<Integer, Integer> cmap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        /*FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }

        });
        futureTask.cancel();*/
    }
}
