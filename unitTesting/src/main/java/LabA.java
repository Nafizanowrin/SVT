import java.util.Arrays;

public class LabA {
    public static String reverse(String str) {
        if(str == null) return null;

        String result = "";
        for(int i=str.length()-1; i>=0; i--){
            result += str.charAt(i);
        }

        return result;
    }

    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int divide(int a, int b){
        return a/b;
    }

    public static int generate(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

    public static String getString(String str) {
        return str;
    }
}
