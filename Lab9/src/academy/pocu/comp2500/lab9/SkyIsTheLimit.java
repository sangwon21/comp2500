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

        for (Book book : books) {
            sum += book.getPrice();
        }

        if (sum < minimumPrice) {
            return (int) sum;
        }

        if (books.size() < 5) {
            return (int) sum;
        }

        books.sort((a, b) -> a.getPrice() - b.getPrice());

        int limit = books.size() - 2;
        sum = 0;

        for (int i = 0; i < limit; i++) {
            sum += (double) books.get(i).getPrice();
        }

        for (int i = limit; i < books.size(); i++) {
            sum += (double) (books.get(i).getPrice()) * 0.5;
        }

        return (int) sum;
    }
}
