
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AKoshary {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine().trim());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] a = new long[2];
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long min = Math.min(x,y);
            long max = Math.max(x,y);
            if(max%2==1 && min%2==1){
                out.println("NO");
            }else{
                out.println("YES");
            }
        }
        out.close();
    }

    private static int getInteger(){
        return sc.nextInt();
    }
    private static int[] readArrayFromLength(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
