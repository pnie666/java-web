package annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created By poplar on 2019/9/16
 * 测试类
 */
public class TestCheck {

    public static void main(String[] args) throws IOException {

        //获取字节码文件
        Calculator calculator = new Calculator();
        Class cls = calculator.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        //出现异常的次数
        int number = 0;
        for (Method method : methods) {
            //判断当前方法上面是否有此注解
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    number++;
                    //把异常信息存储到某个文件中
                    bufferedWriter.write(method.getName() + " 方法出现异常");
                    bufferedWriter.newLine();//换行
                    bufferedWriter.write("异常名称: " + e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();//换行
                    bufferedWriter.write("异常原因: " + e.getCause().getMessage());
                    bufferedWriter.newLine();//换行
                }
            }
        }
        bufferedWriter.write("本次测试共出现【" + number + "】次异常");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
