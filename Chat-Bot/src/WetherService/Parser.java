package WetherService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO неиспользуемый класс
public class Parser {
    //  22.04  -  \d{2}\.\d{2}
    private Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");
    
    public void main(String[] args) throws Exception {
        // получаем страницу
        Document page = getPage();
        // забираем оттуда таблицу с классом wt
        Element tableWth = page.select("table[class=wt]").first();
        // выбираем из неё все строки (tr)
        Elements elements = tableWth.select("tr");
        // перебираем все полученные элементы (строки tr)
        for (Element name : elements) {
            // если у tr указан класс wth - то это дата
            if (name.hasClass("wth")) {
                // обрабатываем её
                printDate(name);
            } else
                // запрашиваем у строки элемент с атрибутом "valign = top"
                // если что-то возвращается (т.е. <> isEmpty)
                if (! name.getElementsByAttributeValue("valign","top").isEmpty() ) {
                // то выводим строчку с данными
                printLineTD(name);
            }
        }
    }
    // получаем страницу
    private Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    // извлекаем дату
    private String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        } else
            throw new Exception("Can't extract date from string!");
    }
    // вывод данных
    private void printLineTD(Element name) {
        // получаем список столбцов (td)
        for (Element td : name.select("td")) {
            //и выводим их содержимое
            System.out.print(td.text() + "   ");
        }
        // переходим на след строку
        System.out.println("");
    }
    // выводим дату
    private void printDate(Element name) throws Exception {
        String dateString = name.select("th[id=dt]").text();
        String date = getDateFromString(dateString);
        // отcтуп между данными и датой
        System.out.println();
        System.out.println(date + "     Явления    Температура     Давление     Влажность    Ветер");
    }
}
