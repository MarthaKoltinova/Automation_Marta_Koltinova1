package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private String area;
    private String numberOfPanels;
    private String numberOfBPackage;
    private String price;
    private String remains;
    private String segments;

    public Results(String area, String numberOfPanels, String numberOfBPackage, String price, String remains, String segments) {
        this.area = "Площадь укладки: " + area + " м2.";
        this.numberOfPanels = "Кол-во панелей: " + numberOfPanels + " шт.";
        this.numberOfBPackage = "Кол-во упаковок: " + numberOfBPackage + " шт.";
        this.price = "Стоимость: " + price + " руб.";
        this.remains = "Остатки: " + remains + " шт.";
        this.segments = "Отрезки: " + segments + " шт.";
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        results.add(area);
        results.add(numberOfPanels);
        results.add(numberOfBPackage);
        results.add(price);
        results.add(remains);
        results.add(segments);

        return results;
    }
}
