import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TradingPlatform tp = new TradingPlatform();
        Portfolio pf = new Portfolio();

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");

            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    tp.displayMarketData();
                    break;

                case 2:

                    tp.displayMarketData();

                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.nextLine();

                    double buyPrice =
                            tp.getStockPrice(buyStock);

                    if (buyPrice == -1) {

                        System.out.println("Invalid Stock Name!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    pf.buyStock(buyStock,
                            buyPrice,
                            buyQty);

                    break;

                case 3:

                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.nextLine();

                    double sellPrice =
                            tp.getStockPrice(sellStock);

                    if (sellPrice == -1) {

                        System.out.println("Invalid Stock Name!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    pf.sellStock(sellStock,
                            sellPrice,
                            sellQty);

                    break;

                case 4:

                    pf.showPortfolio();
                    break;

                case 5:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}