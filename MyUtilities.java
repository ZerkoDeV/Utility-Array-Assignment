import java.util.Scanner;
import java.util.Arrays;

public class MyUtilities {

	public static void splitArray(int[] arr) {
		int highest = arr[0],secondHighest = arr[0],highestIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > highest){
                highest = arr[i];
                highestIndex = i;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] > secondHighest && arr[i] < highest){
                secondHighest = arr[i];
            }
        }
        int[] newArray = new int[arr.length+1];
        boolean reached = false;
        for(int i=0;i<newArray.length;i++){
            if(reached){
                newArray[i] = arr[i-1];
            }else if(i == highestIndex){
                newArray[i] = secondHighest;
                i++;
                newArray[i] = highest-secondHighest;
                reached = true;
            }else{
                newArray[i] = arr[i];
            }
        }
        Arrays.stream(newArray).mapToObj(e->e+" ").forEach(System.out::print);
		

	}

	public static void rotateArray(int[] arr ,int rotation) { 
		int[] newArray = new int[arr.length];
        int rotate = rotation % arr.length;
        for(int i=0;i<arr.length;i++){
            if(i < rotate){
                newArray[i] = arr[arr.length-1-(rotate-(i+1))];
            }else{
                newArray[i] = arr[i-rotate];
            }
        }
        Arrays.stream(newArray).mapToObj(e->e+" ").forEach(System.out::print);
		
		
	      
	}
	public static void symmetricMatrix(int[][] arr) {
		boolean isSymmetric = true;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if (arr[j][i] != arr[i][j]) {
                    isSymmetric = false;
                    break;
                }
            }
        }
        System.out.println(isSymmetric ? "Matrix is symetric" : "Matrix is not symetric");
	}
	public static void magicSquare(int n) {
		
		int[][] magicSquare = new int[n][n]; 
        
        // Initialize position for 1 
        int i = n/2; 
        int j = n-1; 
   
        // One by one put all values in magic square 
        for (int num=1; num <= n*n; ) 
        { 
            if (i==-1 && j==n) //3rd condition 
            { 
                j = n-2; 
                i = 0; 
            } 
            else
            { 
                //1st condition helper if next number  
                // goes to out of square's right side 
                if (j == n) 
                    j = 0; 
                      
                //1st condition helper if next number is  
                // goes to out of square's upper side 
                if (i < 0) 
                    i=n-1; 
            } 
              
            //2nd condition 
            if (magicSquare[i][j] != 0)  
            { 
                j -= 2; 
                i++; 
                continue; 
            } 
            else
                //set number 
                magicSquare[i][j] = num++;  
                  
            //1st condition 
            j++;  i--;  
        } 
        displayMagicSquare(n,magicSquare);
	}
	private static void displayMagicSquare(int n,int[][] magicSquare){
        System.out.println("The Magic Square for "+n+":");
        for(int[] i:magicSquare)
        {
            for(int j:i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

	}
}
