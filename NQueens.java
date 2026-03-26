import java.util.Scanner;

public class NQueens {
    static int[] x;

    public static boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            // Check if another queen is in the same column (i) 
            // or on the same diagonal
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public static void nqueen(int k, int n) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    write(n);
                } else {
                    nqueen(k + 1, n);
                }
            }
        }
    }

    public static void write(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print("|Q|");
                } else {
                    System.out.print("|_|");
                }
            }
            System.out.println(); // Moves to next line after printing one row
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of queens to place:");
        if(sc.hasNextInt()) {
            int n = sc.nextInt();
            x = new int[n + 1];
            nqueen(1, n);
        }
    }
} // Added missing class brace
