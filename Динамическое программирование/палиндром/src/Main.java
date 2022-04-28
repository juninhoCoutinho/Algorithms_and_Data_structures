import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
class OneException extends Exception{
    String s;

    public OneException(String message){

        s=message;

    }
}


public class Main implements Runnable{
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 256 * 1024 * 1024).start();
    }
    public  void run(){
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            PrintWriter fw = new PrintWriter("output.txt");
            String str = br.readLine();
            int n = str.length();
            int[][] mas = new int[n][n];
            for (int i = 0; i < n; i++) {
                mas[i][i] = 1;
                if (i != n - 1) {
                    if (str.charAt(i) == str.charAt(i + 1))
                        mas[i][i + 1] = 2;
                    else
                        mas[i][i + 1] = 1;
                }
            }

            for (int k = 2; k < n; k++) {
                for (int i = 0; i + k < n; i++) {


                    if (str.charAt(i) == str.charAt(i + k))
                        mas[i][i + k] = mas[i + 1][i + k - 1] + 2;
                    else
                        mas[i][i + k] = Math.max(mas[i + 1][i + k], mas[i][i + k - 1]);
                }
            }




        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j]+" ");

            }
            System.out.println();

        }*/
            StringBuilder res = new StringBuilder();
            int i = 0, j = n - 1;
            if(mas[i][j]==1){
                res.insert(0,str.charAt(i));
                Integer r = res.length();
                fw.write(r.toString() + "\n");
                fw.write(res.toString());
            }
            else {
                while (mas[i][j] != 0) {
                    if (mas[i][j] > mas[i + 1][j] && mas[i][j] > mas[i][j - 1]) {
                        res.insert(res.length() / 2, str.charAt(i));
                        if (mas[i][j] != 1)
                            res.insert(res.length() / 2, str.charAt(i));
                        i++;
                        j--;
                    }
                    if (mas[i + 1][j] == mas[i][j] && mas[i][j - 1] < mas[i][j]) {
                        i++;
                    }
                    if (mas[i][j - 1] == mas[i][j])
                        j--;


                }
                Integer r = res.length();
                fw.write(r.toString() + "\n");
                fw.write(res.toString());
            }

            //System.out.println(res.toString());


            fw.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }














    }
}
