import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

public class StockTradingPlatform {
    private Map<String, Stock> marketData;
    private final Map<String, Integer> portfolio;
    private double cash;

    public StockTradingPlatform() {
        this.marketData = new HashMap<>();
        this.portfolio = new HashMap<>();
        this.cash = 10000.0; // initial cash

        // sample market data
        marketData.put("AAPL", new Stock("AAPL", 150.0));
        marketData.put("GOOG", new Stock("GOOG", 2500.0));
        marketData.put("MSFT", new Stock("MSFT", 200.0));
    }

    public void displayMarketData() {
        System.out.println("Market Data:");
        for (Stock stock : marketData.values()) {
            System.out.println(stock.getSymbol() + ": " + stock.getPrice());
        }
    }

    public void buyStock(String symbol, int quantity) {
        if (marketData.containsKey(symbol)) {
            Stock stock = marketData.get(symbol);
            double totalCost = stock.getPrice() * quantity;
            if (totalCost <= cash) {
                cash -= totalCost;
                portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
                System.out.println("Bought " + quantity + " shares of " + symbol + " for $" + totalCost);
            } else {
                System.out.println("Insufficient cash");
            }
        } else {
            System.out.println("Stock not found");
        }
    }

    public void sellStock(String symbol, int quantity) {
        if (portfolio.containsKey(symbol)) {
            int currentQuantity = portfolio.get(symbol);
            if (currentQuantity >= quantity) {
                Stock stock = marketData.get(symbol);
                double totalRevenue = stock.getPrice() * quantity;
                cash += totalRevenue;
                portfolio.put(symbol, currentQuantity - quantity);
                System.out.println("Sold " + quantity + " shares of " + symbol + " for $" + totalRevenue);
            } else {
                System.out.println("Not enough shares to sell");
            }
        } else {
            System.out.println("Stock not in portfolio");
        }
    }

    public void displayPortfolio() {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            Stock stock = marketData.get(entry.getKey());
            double totalValue = stock.getPrice() * entry.getValue();
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares, value: $" + totalValue);
        }
        System.out.println("Cash: $" + cash);
    }

    public static void main(String[] args) {
        StockTradingPlatform platform = new StockTradingPlatform();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Display market data");
            System.out.println("2. Buy stock");
            System.out.println("3. Sell stock");
            System.out.println("4. Display portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> platform.displayMarketData();
                case 2 -> {
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    platform.buyStock(buySymbol, buyQuantity);
                }
                case 3 -> {
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    platform.sellStock(sellSymbol, sellQuantity);
                }
                case 4 -> platform.displayPortfolio();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}