package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created By poplar on 2019/9/16
 * 用于解析student.xml文件
 */
public class StudentParser {
    public static void main(String[] args) throws IOException {

        //1.根据xml文档获取Document对象
        //1.1获取student.xml的path
        String path = StudentParser.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);
        //1.2解析xml文档,加载文档进内存,获取dom树 Document
        Document document = Jsoup.parse(new File(path), "UTF-8");
        //2.获取元素对象
        Elements elements = document.getElementsByTag("name");
        Element element = elements.get(0);
        String text = element.text();
        System.out.println(text);
    }

}
