package academy.pocu.comp2500.lab9.app;

import academy.pocu.comp2500.lab9.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        UUID sku0 = UUID.randomUUID();

        Book book0 = new Book(sku0, "Hello", 10, 1980);
        Book book1 = new Book(sku0, "Hello", 10, 1980);
        Book book2 = new Book(sku0, "Hello", 10, 1980);
        Book book3 = new Book(sku0, "Hello", 10, 1980);
        Book book4 = new Book(sku0, "Hello", 10, 1980);
        Book book5 = new Book(UUID.randomUUID(), "Millenium", 15, 2001);
        Book book6 = new Book(UUID.randomUUID(), "Halfway Millenium", 21, 2005);
        Book book7 = new Book(UUID.randomUUID(), "Decade almost over", 17, 2009);
        Book book8 = new Book(UUID.randomUUID(), "FIFA", 17, 2002);
        Book book9 = new Book(UUID.randomUUID(), "University", 5, 2008);

        ArrayList<Book> books = new ArrayList<>();

        books.add(book0);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);

        HashSet<UUID> skus = new HashSet<>();
        skus.add(sku0);

        BuyOneGetOneFree model0 = new BuyOneGetOneFree(skus);
        DecadeMadness model1 = new DecadeMadness();
        SkyIsTheLimit model2 = new SkyIsTheLimit(100);

        assert (model0.getTotalPrice(books) == 105);
        assert (model1.getTotalPrice(books) == 100);
        assert (model2.getTotalPrice(books) == 106);

        testSkyIsTheLimit();
    }

    private static void testSkyIsTheLimit() {
        Book book0 = new Book(UUID.randomUUID(), "Galactic War", 10, 1991);
        Book book1 = new Book(UUID.randomUUID(), "You and me", 15, 1995);
        Book book2 = new Book(UUID.randomUUID(), "Me and you", 10, 1996);
        Book book3 = new Book(UUID.randomUUID(), "R2D2", 20, 2011);
        Book book4 = new Book(UUID.randomUUID(), "The Rebels", 20, 2003);
        Book book5 = new Book(UUID.randomUUID(), "Teehee", 10, 2001);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book0);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        IPricingModel pricingModel = new SkyIsTheLimit(86);
        assert (pricingModel.getTotalPrice(books) == 85);

        pricingModel = new SkyIsTheLimit(80);
        assert (pricingModel.getTotalPrice(books) == 65);

        pricingModel = new SkyIsTheLimit(85);
        assert (pricingModel.getTotalPrice(books) == 65);

        //All same prices
        Book book6 = new Book(UUID.randomUUID(), "Galactic War", 10, 1991);
        Book book7 = new Book(UUID.randomUUID(), "You and me", 10, 1995);
        Book book8 = new Book(UUID.randomUUID(), "Me and you", 10, 1996);
        Book book9 = new Book(UUID.randomUUID(), "R2D2", 10, 2011);
        Book book10 = new Book(UUID.randomUUID(), "The Rebels", 10, 2003);
        Book book11 = new Book(UUID.randomUUID(), "Teehee", 10, 2001);

        books.clear();
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        books.add(book11);

        pricingModel = new SkyIsTheLimit(65);
        assert (pricingModel.getTotalPrice(books) == 60);

        pricingModel = new SkyIsTheLimit(40);
        assert (pricingModel.getTotalPrice(books)) == 50;

        pricingModel = new SkyIsTheLimit(60);
        assert (pricingModel.getTotalPrice(books)) == 50;


        //All different prices
        Book book12 = new Book(UUID.randomUUID(), "Galactic War", 11, 1991);
        Book book13 = new Book(UUID.randomUUID(), "You and me", 12, 1995);
        Book book14 = new Book(UUID.randomUUID(), "Me and you", 13, 1996);
        Book book15 = new Book(UUID.randomUUID(), "R2D2", 14, 2011);
        Book book16 = new Book(UUID.randomUUID(), "The Rebels", 15, 2003);
        Book book17 = new Book(UUID.randomUUID(), "Teehee", 16, 2001);

        books.clear();
        books.add(book12);
        books.add(book13);
        books.add(book14);
        books.add(book15);
        books.add(book16);
        books.add(book17);

        pricingModel = new SkyIsTheLimit(100);
        assert (pricingModel.getTotalPrice(books)) == 81;

        pricingModel = new SkyIsTheLimit(40);
        assert (pricingModel.getTotalPrice(books)) == 65;

        pricingModel = new SkyIsTheLimit(60);
        assert (pricingModel.getTotalPrice(books)) == 65;
    }
}
