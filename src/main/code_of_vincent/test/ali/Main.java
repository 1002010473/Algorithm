package test.ali;

import java.util.*;

/**
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] strings = new String[n];
            for(int i = 0 ; i < n; i++){
                strings[i] = sc.next();
            }
            List<String> list = new ArrayList<>();
            while(true){
                String s = sc.nextLine();
                if(s.endsWith(".")) {
                    list.add(s.substring(0, s.length() - 1));
                    break;
                }else{
                    list.add(s);
                }
            }
            System.out.println("   ");

        }



    }
}