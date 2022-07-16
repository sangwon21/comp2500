package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;

public class DecadeMadness implements IPricingModel {
    private HashMap<Integer, ArrayList<Book>> bookMap;

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
                ArrayList<Book> bookPrices = bookMap.get(yearInDecade);

                bookPrices.add(book);
                continue;
            }
            ArrayList<Book> bookPrices = new ArrayList<>();
            bookPrices.add(book);

            bookMap.put(yearInDecade, bookPrices);
        }
    }

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        double sum = 0;

        putPricesIntoMap(books);

        for (int year : bookMap.keySet()) {
            ArrayList<Book> bookPrices = bookMap.get(year);
            double localSum = 0;
            if (bookPrices.size() == 1) {
                sum += bookPrices.get(0).getPrice();
                continue;
            }

            if (bookPrices.size() >= 2) {
                for (Book bookPrice : bookPrices) {
                    localSum += bookPrice.getPrice();
                }
            }

            sum += localSum * 0.8;
        }

        for (int year : bookMap.keySet()) {
            ArrayList<Book> bookPrices = bookMap.get(year);
            bookPrices.clear();
        }
        bookMap.clear();

        return (int) sum;
    }
}
