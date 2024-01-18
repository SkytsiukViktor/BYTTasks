public class StockOffer {
    private int stockShares;
    private String stockSymbol="";
    private int colleagueCode;
    public StockOffer(int numOfShares,String stock,int collCode){
        this.colleagueCode=collCode;
        this.stockSymbol=stock;
        this.stockShares=numOfShares;
    }

    public int getColleagueCode() {
        return colleagueCode;
    }

    public int getStockShares() {
        return stockShares;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }
}
