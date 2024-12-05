import java.sql.SQLOutput;

public class Calculator {

    public Integer add(int a, int b){
        return a+b;
    }

    public boolean checkCondition(int a, int b){
        return a > b;
    }

    public void getException() throws Exception {
        throw new Exception("Exception occurred!");
    }

    public int[] getArray() {
        return new int[]{1, 2, 3};
    }

    public void checkBool() {
        System.out.println("Condition checked");
    }

    public String getString(String str) {
        return str;
    }
}
