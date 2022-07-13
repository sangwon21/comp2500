package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collections;

public class SkyIsTheLimit implements IPricingModel {
    private int minimumPrice;
    private int minimumPriceBookCount;

    public SkyIsTheLimit(int price) {
        this.minimumPrice = price;
        this.minimumPriceBookCount = 0;
    }

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        double sum = 0;

        books.sort((a, b) -> a.getPrice() - b.getPrice());

        for (int i = books.size() - 1; i >= 0; i--) {
            Book book = books.get(i);
            int price = book.getPrice();

            if (price >= minimumPrice && minimumPriceBookCount < 2) {
                sum += price * 0.5;
                minimumPriceBookCount++;
                continue;
            }

            sum += price;
        }

        return (int) sum;
    }
}
