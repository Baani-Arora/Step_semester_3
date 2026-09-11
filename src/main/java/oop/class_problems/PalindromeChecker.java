package oop.class_problems;

class PalindromeChecker {

    static boolean isPalindromeIterative(String text){

        int left=0,right=text.length()-1;

        while(left<right){
            if(text.charAt(left)!=text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text){
        return helper(text,0,text.length()-1);
    }

    static boolean helper(String text,int left,int right){

        if(left>=right) return true;

        if(text.charAt(left)!=text.charAt(right))
            return false;

        return helper(text,left+1,right-1);
    }

    static boolean isPalindromeArrayReversal(String text){

        char[] arr=text.toCharArray();

        int left=0,right=arr.length-1;

        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }

        return text.equals(new String(arr));
    }

    public static void main(String[] args){

        String text="madam";

        System.out.println("Iterative: "+isPalindromeIterative(text));
        System.out.println("Recursive: "+isPalindromeRecursive(text));
        System.out.println("Array Reversal: "+isPalindromeArrayReversal(text));
    }
}