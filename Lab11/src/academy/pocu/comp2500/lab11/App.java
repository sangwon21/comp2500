package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public final class App {
    private static final WarehouseType[] WAREHOUSE_TYPES = WarehouseType.values();
    private static final String WAREHOUSE = "WAREHOUSE: Choose your warehouse!";
    private static final String PRODUCT_LIST = "PRODUCT_LIST: Choose the product you want to buy!";
    private static final String EXIT = "exit";
    private static final String AUTH_ERROR = "AUTH_ERROR";
    private static final String BALANCE = "BALANCE: ";

    public App() {
    }

    public void run(final BufferedReader in, final PrintStream out, final PrintStream err) {
        User user = new User();
        Warehouse warehouse;
        SafeWallet wallet;

        while (true) {
            out.printf("%s%s", WAREHOUSE, System.lineSeparator());
            for (int i = 0; i < WAREHOUSE_TYPES.length; i++) {
                out.printf("%d. %s%s", i + 1, WAREHOUSE_TYPES[i].toString(), System.lineSeparator());
            }

            out.printf("%s", System.lineSeparator());

            int selectedWarehouseFromUser;
            try {
                String read = in.readLine();
                if (read.equals(EXIT)) {
                    in.close();
                    err.close();
                    out.close();
                    return;
                }

                selectedWarehouseFromUser = Integer.parseInt(read);
            } catch (Exception e) {
                continue;
            }

            if (1 <= selectedWarehouseFromUser && selectedWarehouseFromUser <= WAREHOUSE_TYPES.length) {
                warehouse = new Warehouse(WAREHOUSE_TYPES[selectedWarehouseFromUser - 1]);
                break;
            }
        }

        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.printf("%s%s", AUTH_ERROR, System.lineSeparator());
            try {
                in.close();
                err.close();
                out.close();
            } catch (Exception e1) {
                return;
            }
            return;
        }

        while (true) {
            out.printf("%s%d%s", BALANCE, wallet.getAmount(), System.lineSeparator());

            out.printf("%s%s", PRODUCT_LIST, System.lineSeparator());
            ArrayList<Product> products = warehouse.getProducts();

            for (int i = 0; i < products.size(); i++) {
                out.printf("%d. %-20s%5d%s", i + 1, products.get(i).getName(), products.get(i).getPrice(), System.lineSeparator());
            }

            int selectedWarehouseFromUser;
            try {
                String read = in.readLine();
                if (read.equals(EXIT)) {
                    in.close();
                    err.close();
                    out.close();
                    return;
                }

                selectedWarehouseFromUser = Integer.parseInt(read);
            } catch (Exception e) {
                continue;
            }

            if (1 <= selectedWarehouseFromUser && selectedWarehouseFromUser <= products.size()) {
                Product product = products.get(selectedWarehouseFromUser - 1);

                if (!wallet.withdraw(product.getPrice())) {
                    continue;
                }

                try {
                    warehouse.removeProduct(product.getId());
                } catch (ProductNotFoundException e) {
                    wallet.deposit(product.getPrice());
                }
            }
        }
    }
}
