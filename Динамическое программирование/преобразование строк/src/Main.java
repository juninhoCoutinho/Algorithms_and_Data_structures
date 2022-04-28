import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable{
    public static int delta(char i,char j){
        if(i==j)
            return 0;
        else
            return 1;
    }
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 256 * 1024 * 1024).start();
    }

    @Override
    public void run() {
        try {
            FileReader fr = new FileReader("in.txt");
            BufferedReader br = new BufferedReader(fr);
            PrintWriter fw = new PrintWriter("out.txt");
            int price_delete=Integer.parseInt(br.readLine());
            int price_insert=Integer.parseInt(br.readLine());
            int price_replace=Integer.parseInt(br.readLine());

            String A=br.readLine();
            String B=br.readLine();

            int mas[][]=new int[A.length()+1][B.length()+1];
            /*for (int i = 0; i < A.length()+1; i++) {
                mas[i][0] = i*price_delete;
            }
            for (int i = 0; i < B.length()+1; i++) {
                mas[0][i]=i*price_insert;

            }*/
            for (int i = 0; i < A.length()+1; i++) {
                for (int j = 0; j <B.length()+1 ; j++) {
                    if(i==0)
                        mas[i][j]=j*price_insert;
                    if(j==0)
                        mas[i][j]=i*price_delete;
                    if(i!=0 && j!=0) {
                        int tmp = Math.min(mas[i - 1][j] + price_delete, mas[i][j - 1] + price_insert);
                        mas[i][j] = Math.min(tmp, mas[i - 1][j - 1] + delta(A.charAt(i - 1), B.charAt(j - 1)) * price_replace);
                    }
                }
            }



            Integer res= mas[A.length()][B.length()];
            fw.write(res.toString());
            fw.close();




        }
        catch (IOException ex){
            System.out.println("ERROR");
        }

    }
}
