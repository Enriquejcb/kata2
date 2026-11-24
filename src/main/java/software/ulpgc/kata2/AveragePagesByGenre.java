package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AveragePagesByGenre {
    public Map<String, Double> calculate(List<Book> books) {
        Map<String, Integer> totalPages = new HashMap<>();
        Map<String, Integer> bookCount = new HashMap<>();
        for (Book book : books) {
            totalPages.merge(book.genre(), book.pages(), Integer::sum);
            bookCount.merge(book.genre(), 1, Integer::sum);
        }
        Map<String, Double> averages = new TreeMap<>();
        for (String genre : totalPages.keySet()) {
            averages.put(genre, (double)  totalPages.get(genre) / bookCount.get(genre));
        }
        return averages;
    }
}
