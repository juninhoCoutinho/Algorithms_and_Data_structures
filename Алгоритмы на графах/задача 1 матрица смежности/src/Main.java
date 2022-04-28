import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        PrintWriter fw = new PrintWriter("output.txt");
        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        int[][] mas=new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j]=0;

            }

        }
        for (int i = 0; i < m; i++) {
            String[] str1=br.readLine().split(" ");
            mas[Integer.parseInt(str1[0])-1][Integer.parseInt(str1[1])-1]=1;
            mas[Integer.parseInt(str1[1])-1][Integer.parseInt(str1[0])-1]=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                Integer res=mas[i][j];
                fw.write(res.toString()+" ");

            }
            fw.write("\n");

        }
        fw.close();

    }
}
