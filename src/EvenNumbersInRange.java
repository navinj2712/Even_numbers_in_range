import java.util.Scanner;

public class EvenNumbersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array A : ");
        int sizeA = scanner.nextInt();
        int[] arrayA = new int[sizeA];
        System.out.println("Enter elements of array A : ");
        for(int i = 0; i < sizeA; i++){
            arrayA[i] = scanner.nextInt();
        }
        System.out.println("Enter the number of queries : ");
        int queries = scanner.nextInt();
        int[][] arrayB = new int[queries][2];
        for(int i = 0; i < queries; i++){
            for(int j = 0; j < 2; j++){
                arrayB[i][j] = scanner.nextInt();
            }
        }
        int[] outputArray = findEvenNumbersInRange(arrayA, arrayB);
        System.out.println("Output : ");
        for (int i = 0; i < outputArray.length; i++){
            System.out.println(outputArray[i] + " ");
        }
    }

    private static int[] findEvenNumbersInRange(int[] arrayA, int[][] arrayB) {
        int evenArraySize = arrayA.length;
        int query = arrayB.length;
        int[] evenArray = new int[evenArraySize];
        evenArray[0] = (arrayA[0] % 2 == 0) ? 1 : 0;
        for(int i = 1; i < arrayA.length; i++){
            evenArray[i] = (arrayA[i] % 2 == 0) ? evenArray[i - 1] + 1 : evenArray[i - 1] + 0;
        }

        int[] outputArray = new int[query];
        for(int i = 0; i < query; i++){
            if(arrayB[i][0] == 0){
                outputArray[i] = evenArray[arrayB[i][1] - 1];
            }
            else {
                outputArray[i] = evenArray[arrayB[i][1]] - evenArray[arrayB[i][0] - 1];
            }
        }

        return outputArray;
    }
}
