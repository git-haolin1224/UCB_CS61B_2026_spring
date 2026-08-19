import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] matrix;
    private int n;
    private WeightedQuickUnionUF UF;
    private WeightedQuickUnionUF UFfull;
    private int size;

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        n = N;
        matrix = new boolean[N][N];
        this.UF = new WeightedQuickUnionUF(n * n + 2);
        this.UFfull = new WeightedQuickUnionUF(n * n + 1);
        size = 0;


    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        if (row < 0 || row > n-1 || col < 0 || col > n-1) {
            throw new IndexOutOfBoundsException();
        }
        if(!isOpen(row, col)) {
            matrix[row][col] = true;
            if (col - 1 >= 0 && matrix[row][col - 1]) {
                UF.union(xyto1D(row, col), xyto1D(row, col - 1));
                UFfull.union(xyto1D(row, col), xyto1D(row, col - 1));
            }
            if (col + 1 <= n-1 && matrix[row][col + 1]) {
                UF.union(xyto1D(row, col), xyto1D(row, col + 1));
                UFfull.union(xyto1D(row, col), xyto1D(row, col + 1));
            }
            if (row - 1 >= 0 && matrix[row - 1][col]) {
                UF.union(xyto1D(row, col), xyto1D(row - 1, col));
                UFfull.union(xyto1D(row, col), xyto1D(row - 1, col));
            }
            if (row + 1 <= n-1 && matrix[row + 1][col]) {
                UF.union(xyto1D(row, col), xyto1D(row + 1, col));
                UFfull.union(xyto1D(row, col), xyto1D(row + 1, col));
            }
            if (row == 0){
                UF.union(xyto1D(row , col), n * n);
                UFfull.union(xyto1D(row, col), n*n);
            }
            if (row == n-1){
                UF.union(xyto1D(row , col), n * n + 1);
            }
            size += 1;
        }
        else {
            return;
        }
    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        if (row < 0 || row > n-1 || col < 0 || col > n-1) {
            throw new IndexOutOfBoundsException();
        }
        return matrix[row][col];
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        if (row < 0 || row > n-1 || col < 0 || col > n-1) {
            throw new IndexOutOfBoundsException();
        }
        if(UFfull.connected(xyto1D(row, col), n*n)){
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return size;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return UF.connected(n * n, n * n + 1);
    }

    public int xyto1D(int x, int y) {
        return x * n + y;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
