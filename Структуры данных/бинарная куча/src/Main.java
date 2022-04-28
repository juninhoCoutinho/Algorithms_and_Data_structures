import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        PrintWriter fw = new PrintWriter("output.txt");

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> mas= new ArrayList<>();
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {

            mas.add(Integer.parseInt(str[i]));
        }
        boolean flag=true;
        for (int i = 0; 2*(i+1)<=n; i++) {
            if(2*i+2<n){
                if(mas.get(i)>mas.get(2*i+1) || mas.get(i)>mas.get(2*i+2) ){
                    flag=false;
                    break;
                }

            }
            if(2*i+2==n)
                if(mas.get(i)>mas.get(2*i+1))
                    flag=false;

        }
        if(flag || n==1){
            fw.write("Yes");
            System.out.println("Yes");
        }

        else {
            System.out.println("No");
            fw.write("No");
        }

        fw.close();

    }
}
