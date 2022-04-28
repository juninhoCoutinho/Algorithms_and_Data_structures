import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
 class MyException extends Exception{


}

public class Main  implements Runnable{

    public static void main(String[] args) {
        new Thread(null, new Main(), "", 256 * 1024 * 1024).start();
    }
    public  void run() {
        try {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> f = new ArrayList<>();
            int total_max = 0;

            String[] str = sc.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
                //System.out.print(list.get(i)+" ");

            }
            if(n==1)
            {
                throw new MyException();
            }
            f.add(0, 1);
            int max;

            for (int i = 1; i < n; i++) {
                max = 0;
                for (int j = 0; j < i; j++) {

                    if (list.get(j) !=0 && list.get(i) % Math.abs(list.get(j)) == 0 && max < f.get(j)) {
                        max = f.get(j);

                    }

                }
                f.add(i, max + 1);
                if (total_max < f.get(i))
                    total_max = f.get(i);
            }
            //System.out.println();
            Integer res=f.size() - total_max;

            System.out.print(res.toString());

        }

        catch (MyException ex){
            System.out.print(0);
        }
    }

}
