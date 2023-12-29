package longestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner; 

public class LongestIncreaseSubsequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int length = getLongestIncreasingSubsequence(arr);
        
        System.out.println("Length of the Longest Increasing Subsequence: " + length);
    }

    private static int getLongestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];

        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLength = Arrays.stream(lis).max().orElse(1);

        return maxLength;

	}

}
