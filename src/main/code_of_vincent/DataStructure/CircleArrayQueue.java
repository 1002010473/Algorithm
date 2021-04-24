package DataStructure;

public class CircleArrayQueue {
     int size;//队列的长度
     int[] queue; //队列
     int head; //后指针
     int tail; //可以放置的第一个位置
     int length;//数组长度
     final int DEFALUT_Length = 10;
    
     public CircleArrayQueue() {
         this.length = DEFALUT_Length;
         head = 0;
         tail = 0;
         size = 0;
     }
    
     public CircleArrayQueue(int queueSize) {
         if (queueSize <= 0 ) {
             length = DEFALUT_Length;
         } else {
             length = queueSize;
         }
         queue = new int[length];
         head = 0;
         tail = 0;
         size = 0;
     }
    
     private boolean isFull() {
         //return (tail + 1) % size == head;
         return length == size;
     }
    
     public boolean isEmpty() {
         return size == 0;
     }
    
     public int size() {
         return size;
     }
    
     public void add(int num) {
         if (isFull()) {
             throw new RuntimeException("队列已满，不能再添加元素!!");
         }else{
             queue[tail] = num;
             size++;
             tail = (tail + 1) % length;
         }

     }
    
     public int poll() {
         if (isEmpty()) {
             throw new RuntimeException("队列为空~~~");
         }else{
             int num = queue[head];
             size--;
             head = (head + 1) % size;
             return num;
         }
     }
    
     public int peek() {
         if (isEmpty()) {
             throw new RuntimeException("队列为空~~~");
         }else{
             return queue[head];
         }
     }
    
     public void list() {
         for (int i = head; i < head + size; i++) {
             System.out.printf("queue[%d] = %d,", i % length, queue[i % length]);
         }
         System.out.println();
     }

    public static void main(String[] args) {
        CircleArrayQueue cq = new CircleArrayQueue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.list();
        System.out.println(cq.poll());
        System.out.println(cq.peek());
        cq.list();
    }
}