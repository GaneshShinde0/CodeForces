
import java.io.*;
import java.util.Arrays;

public class RangeMinimumQueryNsqrtN {
    private static final int MOD = 1_000_000_007;
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        long t = reader.nextInt();
        for(int i=0;i<t;i++){
            int n = reader.nextInt();
            int[] arr = readArr(n);
            int sRoot = (int) Math.ceil(Math.sqrt(n));
            int[] rmq = new int[sRoot];
            Arrays.fill(rmq,Integer.MAX_VALUE);
            for(int j=0;j<n;j++){
                rmq[j/sRoot] = Math.min(arr[j], rmq[j/sRoot]);
            }
            int q = reader.nextInt();
            while(q>0){
                int start = reader.nextInt();
                int end = reader.nextInt();
                int ans = Integer.MAX_VALUE;
                while(start<=end){
                    if(start%sRoot==0 && start+sRoot<=end){
                        ans = Math.min(ans, rmq[start/sRoot]);
                        start+=sRoot;
                    }else{
                        ans = Math.min(ans, arr[start++]);
                    }
                }
                out.println(ans);
                q--;
            }
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
