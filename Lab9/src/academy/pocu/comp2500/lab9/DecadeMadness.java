package academy.pocu.comp2500.lab9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DecadeMadness implements IPricingModel {
    private HashMap<Integer, ArrayList<Integer>> bookMap;

    public DecadeMadness() {
        bookMap = new HashMap<>();
    }

    private int getYearInDecade(int publishedAt) {
        int decades = publishedAt / 10;

        return decades * 10;
    }

    private void putPricesIntoMap(ArrayList<Book> books) {
        for (Book book : books) {
            int yearInDecade = getYearInDecade(book.getPublishedYear());

            if (bookMap.containsKey(yearInDecade)) {
                ArrayList<Integer> bookPrices = bookMap.get(yearInDecade);

                bookPrices.add(book.getPrice());
                continue;
            }
            ArrayList<Integer> bookPrices = new ArrayList();
            bookPrices.add(book.getPrice());

            bookMap.put(yearInDecade, bookPrices);
        }
    }

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        double sum = 0;

        putPricesIntoMap(books);

        for (int year : bookMap.keySet()) {
            ArrayList<Integer> bookPrices = bookMap.get(year);
            double localSum = 0;
            if (bookPrices.size() == 1) {
                sum += bookPrices.get(0);
                continue;
            }

            if (bookPrices.size() >= 2) {
                for (int bookPrice : bookPrices) {
                    localSum += bookPrice;
                }
            }

            sum += localSum * 0.8;
        }

        for (int year : bookMap.keySet()) {
            ArrayList<Integer> bookPrices = bookMap.get(year);
            bookPrices.clear();
        }
        bookMap.clear();

        return (int) sum;
    }
}
