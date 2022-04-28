import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        PrintWriter fw = new PrintWriter("output.txt");
        int n=Integer.parseInt(br.readLine());


        int[] p=new int[n];
        for (int i = 0; i < n-1; i++) {

            String[] str=br.readLine().split(" ");
            p[Integer.parseInt(str[1])-1]=Integer.parseInt(str[0]);

        }
        for (int i = 0; i < n; i++) {
            Integer res=p[i];
            fw.write(res.toString()+" ");

        }
        fw.close();
    }


}
