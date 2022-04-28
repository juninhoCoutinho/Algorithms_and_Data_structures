import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class TwoException extends Exception{


    public TwoException(String message){

        super(message);

    }
}
class OneException extends Exception{
    String s;

    public OneException(String message){

        s=message;

    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());


            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> f = new ArrayList<>();
            ArrayList<Integer> numbers = new ArrayList<>();
            String[] str = sc.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            if(n==1) throw  new OneException(list.get(0).toString()) ;
            if (n == 2) throw new TwoException(" ");

            f.add(0, list.get(0));
            f.add(1, -1);

            f.add(2, list.get(2) + list.get(0));
            for (int i = 3; i < n; i++) {
                f.add(i, Math.max(f.get(i - 2), f.get(i - 3)) + list.get(i));
            }
            int N = n - 1;
            numbers.add(0, N + 1);

            while (N != 0) {
                if (N == 2) {
                    numbers.add(0, 1);
                    N = 0;

                } else {
                    if (f.get(N - 2) >= f.get(N - 3)) {
                        numbers.add(0, N - 1);
                        N = N - 2;
                    } else {
                        numbers.add(0, N - 2);
                        N = N - 3;

                    }
                }


            }
            System.out.println(f.get(n - 1));
            for (int i : numbers) {
                System.out.print(i + " ");
            }
        }
        catch (TwoException ex){
            System.out.println(-1);
        }
        catch (OneException ex){
            System.out.println(ex.s);
            System.out.println(1);
        }



    }
}
