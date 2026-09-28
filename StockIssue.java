import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    int stock = 50;

    void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0)
            throw new InvalidQuantityException("Invalid quantity");

        if (qty > stock)
            throw new OutOfStockException(qty - stock);

        stock = stock - qty;
        System.out.println(item + " issued: " + qty);
    }
}

public class StockIssue {
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {"Eraser", "Pen", "Pencil", "Scale"};
        int[] qty = {3, 15, -2, 4};

        for (int i = 0; i < items.length; i++) {
            try {
                w.issue(items[i], qty[i]);
            }
            catch (OutOfStockException e) {
                System.out.println(items[i] + ": Out of stock. Shortfall = " + e.shortfall);
            }
            catch (InvalidQuantityException e) {
                System.out.println(items[i] + ": " + e.getMessage());
            }
        }
        
    }
}