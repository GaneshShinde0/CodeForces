import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Palindromex {
    private static final int MOD = 1_000_000_007;
    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        long n = reader.nextInt();
        for(int i=0;i<n;i++){
            int t = reader.nextInt();
            int[] arr = readArr(t*2);
            out.println(getPalindromeMex(arr));
        }
        out.close();
    }
    public static int getPalindromeMex(int[] arr) {
        int n = arr.length / 2;

        // find two positions of 0
        int x = -1, y = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (x == -1) x = i;
                else y = i;
            }
        }

        int ans = 0;

        // case 1: center at first 0
        ans = Math.max(ans, solve(arr, x, x));

        // case 2: center at second 0
        ans = Math.max(ans, solve(arr, y, y));

        // case 3: center between two zeros
        ans = Math.max(ans, solve(arr, (x + y) / 2, (x + y + 1) / 2));

        return ans;
    }

    private static int solve(int[] arr, int l, int r) {
        int n = arr.length;

        // using boolean array instead of set (faster)
        boolean[] seen = new boolean[n + 1];

        while (l >= 0 && r < n && arr[l] == arr[r]) {
            int val = arr[l];
            if (val >= 0 && val <= n) {
                seen[val] = true;
            }
            l--;
            r++;
        }

        // find mex
        for (int i = 0; i <= n; i++) {
            if (!seen[i]) return i;
        }

        return n + 1;
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
