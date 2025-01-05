import java.util.Scanner;

public class ndv{
    double[] elements;
    int size;

    public ndv(int size) {
        this.size = size;
        elements = new double[size];
    }

    public void inputElements() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + size + " elements for the vector: ");
        for (int i = 0; i < size; i++) {
            elements[i] = sc.nextDouble();
        }
    }

    public ndv add(ndv v) {
        ndv result = new ndv(size);
        for (int i = 0; i < size; i++) {
            result.elements[i] = this.elements[i] + v.elements[i];
        }
        return result;
    }

    public ndv subtract(ndv v) {
        ndv result = new ndv(size);
        for (int i = 0; i < size; i++) {
            result.elements[i] = this.elements[i] - v.elements[i];
        }
        return result;
    }

    // Method to compute the dot product of two vectors
    public double dotProduct(ndv v) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += this.elements[i] * v.elements[i];
        }
        return result;
    }

    public void print() {
        System.out.print("Vector: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the vectors: ");
        int size = sc.nextInt();
        
        ndv v1 = new ndv(size);
        ndv v2 = new ndv(size);
        
        System.out.println("Input for first vector:");
        v1.inputElements();
        
        System.out.println("Input for second vector:");
        v2.inputElements();

        ndv sum = v1.add(v2);
        ndv diff = v1.subtract(v2);
        double dotProd = v1.dotProduct(v2);

        System.out.println("Sum of vectors:");
        sum.print();
        
        System.out.println("Difference of vectors:");
        diff.print();
        
        System.out.println("Dot product of vectors: " + dotProd);
    }
}
