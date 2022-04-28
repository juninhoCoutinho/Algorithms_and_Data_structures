import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args)throws Exception {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        PrintWriter fw = new PrintWriter("output.txt");

        int n=Integer.parseInt(br.readLine());
        int[][] mas=new int[n][n];
        int[] p=new int[n];
        for (int i = 0; i < n; i++) {
            String[] str=br.readLine().split(" ");
            for (int j = 0; j <n ; j++) {
                mas[i][j]=Integer.parseInt(str[j]);

            }
            p[i]=0;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mas[i][j]==1)
                    p[j]=i+1;




            }


        }
        for (int i = 0; i < n; i++) {
            Integer res=p[i];
            fw.write(res.toString()+" ");

        }
        fw.close();

    }
}
