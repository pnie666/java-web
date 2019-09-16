package annotation;

/**
 * Created By poplar on 2019/9/16
 * 计算器类
 */
public class Calculator {

    @Check
    public void add() {
        String hello = null;
        hello.toString();
        System.out.println("1 + 3=" + (1 + 3));
    }

    @Check
    public void sub() {
        System.out.println("1 - 3=" + (1 - 3));
    }

    @Check
    public void mul() {
        System.out.println("2 * 3=" + (2 * 3));
    }

    @Check
    public void div() {
        System.out.println("9 / 0=" + (9 / 0));
    }

    public void show() {
        System.out.println("hello ~~~~");
    }
}
