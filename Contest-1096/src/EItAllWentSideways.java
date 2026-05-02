import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class EItAllWentSideways {
    private static final int MOD = 1_000_000_007;
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        long n = reader.nextInt();
        for(int i=0;i<n;i++){
            int t = reader.nextInt();
            int[] arr = readArr(t);
            out.println(getSum(arr));
        }
        out.close();
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        int minHeight = arr[arr.length-1];
        int chose = 0;
        for(int j=arr.length-1;j>=0;j--){
            if(chose<1 && arr[j]==1){
                minHeight = 0;
                sum-=1;
                chose++;
            }
            sum += Math.max(arr[j]-minHeight,0);
            minHeight = Math.min(minHeight,arr[j]);
        }
        return sum;
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
