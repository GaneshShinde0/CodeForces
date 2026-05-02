
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSnowFall {
    private static final int MOD = 1_000_000_007;
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        long n = reader.nextInt();
        for(int i=0;i<n;i++){
            int t = reader.nextInt();
            int[] arr = readArr(t);
            int[] res = new int[arr.length];
            List<Integer> multipleOfSix = new ArrayList<>();
            List<Integer> multipleOfTwo = new ArrayList<>();
            List<Integer> multipleOfThree = new ArrayList<>();
            List<Integer> others = new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                if(arr[j]%6==0){
                    multipleOfSix.add(arr[j]);
                }else if(arr[j]%3==0){
                    multipleOfThree.add(arr[j]);
                }else if(arr[j]%2==0){
                    multipleOfTwo.add(arr[j]);
                }else{
                    others.add(arr[j]);
                }
            }
            int j = 0;
            for(int x:multipleOfSix){
                res[j]=x;j++;
                out.print(x+" ");
            }
            for(int x:multipleOfTwo){
                res[j]=x;j++;
                out.print(x+" ");
            }
            for(int x:others){
                res[j]=x;j++;
                out.print(x+" ");
            }
            for(int x:multipleOfThree){
                res[j]=x;j++;
                out.print(x+" ");
            }
//            out.println(Arrays.toString(res));
            out.println();
        }
        out.close();
    }

    private static int[] readArr(int n) {
        if (reader == null) reader = new Reader();
        try {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            return arr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Custom Reader class for fast input
    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Reads the next integer from input
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Reads the next byte from the buffer
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        // Fills the buffer with new data
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
    }
}
