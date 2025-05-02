public class  Array Util{
    public void printArray(int [] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }
    public void arrayDemo(){
        int [] myArray = new int [5]; //default values = 0 1 2 3 4 
        printArray(myArray);
        myArray[0] = 5;
        myArray[1] = 1;
        myArray[2] = 8;
        myArray[3] = 2;
        myArray[4] = 10;
        myArray[5] = 9;
        printArray(myArray);
        System.out.println(myArray.length);
        System.err.println(myArray[myArray.length-1]);//to access the last element of the array
    }
    public static void main(String[] args) {
        ArrayUtil arrUtil = new ArrayUtil();
        arrUtil.arrayDemo();
    }
}