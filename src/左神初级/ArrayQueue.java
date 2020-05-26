package 左神初级;
//队列的数组实现
public class ArrayQueue{
    private int[] arr;
    private int size;
    private int start;
    private int end;
    public ArrayQueue(int initSize){
        if (initSize < 0)
            throw new IllegalArgumentException("the init size must more than 0");
        arr = new int[initSize];
        start = 0;
        end = 0;
        size = 0;
    }
 
    public void push(int obj) {
        if (size == arr.length)
            throw new  ArrayIndexOutOfBoundsException("The queue is full");
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end + 1;
        size++;
    }
 
    public int poll() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        size--;
        return arr[tmp];
    }
    public Integer peek(){
        if (size == 0)
            return null;
        return arr[start];
    }
}