package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created By poplar on 2019/9/16
 */
public class VolleyBallParser {

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = VolleyBallParser.class.getClassLoader().getResource("love.html").getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//span[@class='comp-txt']|//div[@class='rt-time' or @class='rt-cc-time']/..//span[@class='pt']/text()|//div[@class='rt-time' or @class='rt-cc-time']/(@id|span/text())|//div[@class='rt-time' or @class='rt-cc-time']/../following-sibling::div[1]//td[@class='r-odds' or @class='r-odds b']");
        System.out.println(jxNodes);
    }
}
