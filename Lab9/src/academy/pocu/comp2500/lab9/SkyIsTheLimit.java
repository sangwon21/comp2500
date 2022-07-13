package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collections;

public class SkyIsTheLimit implements IPricingModel {
    private int minimumPrice;

    public SkyIsTheLimit(int price) {
        this.minimumPrice = price;
    }

    private double getSumLimitedByIndex(ArrayList<Book> books, int limit) {
        double sum = 0;
        for (int i = 0; i < limit; i++) {
            Book book = books.get(i);
            sum += book.getPrice();
        }

        return sum;
    }

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        double sum = 0;

        books.sort((a, b) -> a.getPrice() - b.getPrice());

        for (Book book : books) {
            sum += book.getPrice();
        }

        if (sum >= this.minimumPrice) {
            if (books.size() >= 2) {
                sum = getSumLimitedByIndex(books, books.size() - 2);
                sum += 0.5 * (books.get(books.size() - 1).getPrice() + books.get(books.size() - 2).getPrice());
                return (int) sum;
            }
            sum = getSumLimitedByIndex(books, books.size() - 1);
            sum += 0.5 * (books.get(books.size() - 1).getPrice());

            return (int) sum;
        }

        return (int) sum;
    }
}
