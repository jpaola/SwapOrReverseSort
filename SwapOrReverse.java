/**
 * Given an array with n elements, this program checks the possibility of
 * sorting this array using only one of the following operations in ascending
 * order: i) Swapping two elements ii) Reverse one sub-segment
 *
 * INPUT: From stdin, the first line contains a single integer N, denoting the
 * size of the array. The next line contains n integers separated by spaces n
 * d1, d2...dn
 *
 * CONSTRAINTS: 2<= n<= 100000, 0<= d <= 1000000 (All elements on the array are
 * distinct)
 *
 * OUTPUT: If the array is already sorted, output YES on the first line. ELSE if
 * the array can be sorted by swapping 2 elements, output swap l r in second
 * line l and r are the indices of the elements to be swapped, assuming that the
 * array is indexed from 1 to n OR if it is possible to sort the array by
 * reversing the segmentd[l...r], output reverse l r in the second line. l and r
 * are the first and last elements of the subsequence to be reversed, assuming
 * that the array is indexed from 1 to n. d[l...r] represents the sub-sequence
 * of the array, beginning at index l and ending at index r, both inclusive. IF
 * the array can be sorted by EITHER swapping or reversing, consider the swap
 * -based method. If the array cannot be sorted in either of the above ways, NO
 * is output in the first line.
 */
package SwapReverse;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Paola Jiron
 */
public class SwapOrReverse
{
    /* Determines if swap, reverse was the solution, or if the array was originally
       sorted or if there is no solution using these two methods */
    static void results(int[] arr1, int[] arr2, int i, int left, int right){
        int element;
        if (i == 0){
            System.out.println("yes");
        }else{ 
            if(i == 2){
                System.out.println("yes\nswap " + left + " " + right);
            }else{
                for(element = left-1;element<=right-1;++element){
                    if(arr1[element] != arr2[right-1-element+left-1]){
                        System.out.println("no");
                        return;
                    }
                }
                System.out.println("yes\nreverse " + left + " " + right);
            }
        }
    }
    
    /* Read for standard input */
    public static void main (String args[]){
        int N,d; /* N is length of the array, d are the values in the array */
        int[] arr;  /* input array */
        int[] arrCopy;  /* sorted version of input array */
        int element;    /* loop traversal pointer */
        int temp = 0, left = -1, right = -1;
        
        Scanner stdin = new Scanner(System.in);
        N = stdin.nextInt();
        arr = new int[N];
        arrCopy = new int[N];
        
        /* populate the array and it's copy, then sort the copy */
        for(element = 0; element < N; element++){
            arr[element]= stdin.nextInt();
        }
        arrCopy = Arrays.copyOf(arr, N);
        Arrays.sort(arrCopy);
        
        /* check if the array is initially sorted */
        for(element = 0; element<arr.length; ++element){
            if(arr[element] != arrCopy[element]){
                if(temp == 0){
                    left = element+1;
                    temp++;
                }else{
                    right = element+1;
                    temp++;
                }
            }
        }
        results(arr, arrCopy, temp, left, right);   /* get the results */
    }
}