import java.util.ArrayList;

class TradingPlatform {

    ArrayList<Stock> marketStocks = new ArrayList<>();

    TradingPlatform() {

        marketStocks.add(new Stock("TCS", 3500));
        marketStocks.add(new Stock("Infosys", 1500));
        marketStocks.add(new Stock("Reliance", 2800));
        marketStocks.add(new Stock("HDFC", 1700));
    }

    void displayMarketData() {

        System.out.println("\n===== MARKET DATA =====");

        for (Stock s : marketStocks) {

            System.out.println("Stock Name : " + s.stockName);
            System.out.println("Price      : ₹" + s.price);

            System.out.println("----------------------");
        }
    }

    double getStockPrice(String stockName) {

        for (Stock s : marketStocks) {

            if (s.stockName.equalsIgnoreCase(stockName)) {
                return s.price;
            }
        }

        return -1;
    }
}