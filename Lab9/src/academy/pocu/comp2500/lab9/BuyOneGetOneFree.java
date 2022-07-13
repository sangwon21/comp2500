package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class BuyOneGetOneFree implements IPricingModel {
    private final HashMap<UUID, Boolean> skuFlagMap;

    public BuyOneGetOneFree(final HashSet<UUID> skus) {
        this.skuFlagMap = new HashMap<>();
        for (UUID sku : skus) {
            skuFlagMap.put(sku, false);
        }
    }

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        int sum = 0;

        for (Book book : books) {
            if (this.skuFlagMap.containsKey(book.getSku())) {
                if (this.skuFlagMap.get(book.getSku())) {
                    this.skuFlagMap.put(book.getSku(), false);
                    continue;
                }

                this.skuFlagMap.put(book.getSku(), true);
            }

            sum += book.getPrice();
        }

        for (final UUID sku : this.skuFlagMap.keySet()) {
            skuFlagMap.put(sku, false);
        }
        
        return sum;
    }
}
