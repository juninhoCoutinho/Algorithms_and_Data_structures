import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main implements Runnable{
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 128 * 1024 * 1024).start();
    }
    public void run() {
        try {
            FileReader fr = new FileReader("huffman.in");
            BufferedReader br = new BufferedReader(fr);
            PrintWriter fw = new PrintWriter("huffman.out");

            int n = Integer.parseInt(br.readLine());
            String[] str=br.readLine().split(" ");
            PriorityQueue<Long> keys= new PriorityQueue<>();
            long res=0;
            for (int i = 0; i < n; i++) {
                keys.add(Long.parseLong(str[i]));


            }
            long tmp=0;
            while (keys.size()!=1) {
                tmp=keys.poll()+keys.poll();
                res+=tmp;
                keys.add(tmp);
            }
            System.out.println(res);
            Long r=res;
            fw.write(r.toString());
            fw.close();
        }

        catch (IOException ex){
            System.out.println("ERROR");
        }


    }
}
