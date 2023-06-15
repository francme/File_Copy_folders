import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String htmlFile = parseFile("data/code.html");

//        System.out.println(htmlFile); //вывести в консоль весь код

        //парсим html-файл с помощью Jsoup:
        Document document = Jsoup.parse(htmlFile);

        //выбираем все элементы span с классом dropdown__link-text:
        Elements elements = document.select(""); //span.dropdown__link-text, span.town-name


        //для каждого найденного элемента выводим его текст в консоль:
        elements.forEach(element -> {
            System.out.println(element.text());
        });
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> stringList = Files.readAllLines(Paths.get(path));
            stringList.forEach(l -> builder.append(l + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}