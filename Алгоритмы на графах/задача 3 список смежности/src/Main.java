import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        PrintWriter fw = new PrintWriter("output.txt");
        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);



        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());

        }

        for (int i = 0; i < m; i++) {
            str=br.readLine().split(" ");

            list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));



        }
        for (int i = 1; i <= n; i++) {
            fw.write(list.get(i).size()+" ");

                for (int j = 0; j < list.get(i).size(); j++) {
                    fw.write(list.get(i).get(j)+" ");
                }


            fw.write("\n");

        }









        fw.close();

    }



}
