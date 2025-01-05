import java.util.*;

public class folding {
    public static int[][] foldMatrix(int N) {
       
        int[][] matrix = generateMatrix(N);
        
        int[][] foldedMatrix = performHorizontalFold(matrix, N);
        foldedMatrix = performVerticalFold(foldedMatrix, N);

        int[][] productMatrix = calculateProductMatrix(foldedMatrix);
        
        return productMatrix;
    }
    
    private static int[][] generateMatrix(int N) {
        Random random = new Random();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = random.nextInt(9) + 1;
            }
        }
        return matrix;
    }
    
    private static int[][] performHorizontalFold(int[][] matrix, int N) {
        int[][] foldedMatrix;
        if (N % 2 == 0) {
            int[][] topHalf = new int[N/2][N];
            int[][] bottomHalf = new int[N/2][N];
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    topHalf[i][j] = matrix[i][j];
                    bottomHalf[i][j] = matrix[N-1-i][j];
                }
            }
            foldedMatrix = new int[N][N];
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    foldedMatrix[i][j] = Math.max(topHalf[i][j], bottomHalf[i][j]);
                    foldedMatrix[N-1-i][j] = Math.max(topHalf[i][j], bottomHalf[i][j]);
                }
            }
        } else {
            int[][] topHalf = new int[N/2][N];
            int[][] middleRow = new int[1][N];
            int[][] bottomHalf = new int[N/2][N];
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    topHalf[i][j] = matrix[i][j];
                    bottomHalf[i][j] = matrix[N-1-i][j];
                }
            }
            for (int j = 0; j < N; j++) {
                middleRow[0][j] = matrix[N/2][j];
            }
            foldedMatrix = new int[N][N];
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N; j++) {
                    foldedMatrix[i][j] = Math.max(topHalf[i][j], bottomHalf[i][j]);
                    foldedMatrix[N/2][j] = middleRow[0][j];
                    foldedMatrix[N-1-i][j] = Math.max(topHalf[i][j], bottomHalf[i][j]);
                }
            }
        }
        return foldedMatrix;
    }
    
    private static int[][] performVerticalFold(int[][] foldedMatrix, int N) {
        if (N % 2 == 0) {
            int[][] leftHalf = new int[N][N/2];
            int[][] rightHalf = new int[N][N/2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    leftHalf[i][j] = foldedMatrix[i][j];
                    rightHalf[i][j] = foldedMatrix[i][N-1-j];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    foldedMatrix[i][j] = Math.max(leftHalf[i][j], rightHalf[i][j]);
                    foldedMatrix[i][N-1-j] = Math.max(leftHalf[i][j], rightHalf[i][j]);
                }
            }
        } else {
            int[][] leftHalf = new int[N][N/2];
            int[][] middleColumn = new int[N][1];
            int[][] rightHalf = new int[N][N/2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    leftHalf[i][j] = foldedMatrix[i][j];
                    rightHalf[i][j] = foldedMatrix[i][N-1-j];
                }
                middleColumn[i][0] = foldedMatrix[i][N/2];
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    foldedMatrix[i][j] = Math.max(leftHalf[i][j], rightHalf[i][j]);
                    foldedMatrix[i][N/2] = middleColumn[i][0];
                    foldedMatrix[i][N-1-j] = Math.max(leftHalf[i][j], rightHalf[i][j]);
                }
            }
        }
        return foldedMatrix;
    }
    
    private static int[][] calculateProductMatrix(int[][] foldedMatrix) {
        int N = foldedMatrix.length;
        int[][] productMatrix = new int[N][1];
        for (int i = 0; i < N; i++) {
            int product = 1;
            for (int j = 0; j < N; j++) {
                product *= foldedMatrix[i][j];
            }
            productMatrix[i][0] = product;
        }
        return productMatrix;
    }
    
    public static void main(String[] args) {
        int N = 5;
        int[][] result = foldMatrix(N);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
