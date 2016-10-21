/**
 * Created by Administrator on 2016-7-30.
 */
public class RuntimeExceptionTest {

    static class MyException extends RuntimeException{}

    public static void main(String[] args) {
        try {
            throwException();
        } catch (MyException e){
            System.out.println("throw my exception success!");
        } catch (RuntimeException e){
            System.out.println("throw runtime exception success!");
        } catch (Exception e){
            System.out.println("throw exception success!");
        }
    }

    public static void throwException(){
        throw new MyException();
    }
}
