import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            PrintWriter fw = new PrintWriter("output.txt");

            int n = Integer.parseInt(br.readLine());
            Vector<Point> vector = new Vector<>();
            int ind = 0;
            while (ind != n) {
                String[] str = br.readLine().split(" ");
                Point point = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                vector.add(ind, point);
                ind++;
            }
            double[][] proizv= new double[n][n];
            for(int i=0;i<n;i++){
                for (int j = 0; j < n; j++) {
                    proizv[i][j]=0;
                }
            }
            for(int k=1;k<n;k++) {
                for (int i = 0, j = i + k; j < n; i++, j++) {
                    proizv[i][j] = Double.MAX_VALUE;
                    for (int a = i; a < j; a++) {
                        double tmp = vector.get(i).getX() * vector.get(a).getY() * vector.get(j).getY() + proizv[i][a] + proizv[a + 1][j];

                        if (proizv[i][j] > tmp)
                            proizv[i][j] = tmp;
                    }


                }
            }

            for(int i=0;i<n;i++){
                for (int j = 0; j < n; j++) {
                    System.out.print(proizv[i][j]+" ");
                }
                System.out.println();
            }
            Integer res=(int)proizv[0][n-1];
            fw.write(res.toString());


            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
