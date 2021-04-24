package test;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/27 9:11
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        Integer i5 = 127;
        Integer i6 = 127;
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i5 == i6);
        System.out.println(i7 == i8);
    }
}
