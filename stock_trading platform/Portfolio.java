import java.util.HashMap;

class Portfolio {

    HashMap<String, Integer> holdings = new HashMap<>();
    double balance = 10000;

    void buyStock(String stockName, double price, int quantity) {

        double totalCost = price * quantity;

        if (totalCost > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= totalCost;

        if (holdings.containsKey(stockName)) {
            holdings.put(stockName,
                    holdings.get(stockName) + quantity);
        } else {
            holdings.put(stockName, quantity);
        }

        System.out.println("Stock Purchased Successfully!");
    }

    void sellStock(String stockName, double price, int quantity) {

        if (!holdings.containsKey(stockName)) {
            System.out.println("Stock not found in portfolio.");
            return;
        }

        int currentQuantity = holdings.get(stockName);

        if (quantity > currentQuantity) {
            System.out.println("Not enough shares to sell.");
            return;
        }

        holdings.put(stockName, currentQuantity - quantity);

        if (holdings.get(stockName) == 0) {
            holdings.remove(stockName);
        }

        balance += price * quantity;

        System.out.println("Stock Sold Successfully!");
    }

    void showPortfolio() {

        System.out.println("\n===== PORTFOLIO =====");

        if (holdings.isEmpty()) {
            System.out.println("No stocks purchased.");
        } else {

            for (String stock : holdings.keySet()) {

                System.out.println("Stock Name : " + stock);
                System.out.println("Quantity   : "
                        + holdings.get(stock));

                System.out.println("----------------------");
            }
        }

        System.out.println("Available Balance : ₹" + balance);
    }
}