import java.util.ArrayList;

public class StockMediator implements Mediator{
    private ArrayList<Colleague>colleagues;
    private ArrayList<StockOffer>stockBuyOffers;
    private ArrayList<StockOffer>stockSellOffers;
    public int colleagueCodes=0;
    public StockMediator(){
        colleagues=new ArrayList<Colleague>();
        stockBuyOffers=new ArrayList<StockOffer>();
        stockSellOffers=new ArrayList<StockOffer>();

    }
    public void addColleague(Colleague newcolleague) {
        colleagues.add(newcolleague);
        colleagueCodes++;
        newcolleague.setColleagueCode(colleagueCodes);
    }
    public void saleOffer(String stock, int shares, int collCode) {
        boolean stockSold=false;

        for (StockOffer offer: stockBuyOffers){
            if ((offer.getStockSymbol()==stock) && (offer.getStockShares()==shares)){
                System.out.println(shares+ " shares of "+stock+" sold to colleague code "+offer.getColleagueCode() );
                stockBuyOffers.remove(offer);
                stockSold=true;
            }
            if (stockSold){break;}

        }
        if (!stockSold){
            System.out.println(shares+ " shares of "+stock+"added to inventory");
            StockOffer newOffer= new StockOffer(shares,stock,collCode);
            stockSellOffers.add(newOffer);
        }

    }
    public void buyOffer(String stock, int shares, int collCode) {
        boolean stockBought=false;

        for (StockOffer offer: stockSellOffers){
            if ((offer.getStockSymbol()==stock) && (offer.getStockShares()==shares)){
                System.out.println(shares+ " shares of "+stock+" bought by colleague code "+offer.getColleagueCode() );
                stockSellOffers.remove(offer);
                stockBought=true;
            }
            if (stockBought){break;}

        }
        if (!stockBought){
            System.out.println(shares+ " shares of "+stock+"added to inventory");
            StockOffer newOffer= new StockOffer(shares,stock,collCode);
            stockBuyOffers.add(newOffer);
        }
    }
    public void getStockOfferings(){
        System.out.println("\nStocks for sale");
        for (StockOffer offer:stockSellOffers){
            System.out.println(offer.getStockShares()+" of "+offer.getStockSymbol());
        }
        System.out.println("\nStocks to buy");
        for (StockOffer offer:stockBuyOffers){
            System.out.println(offer.getStockShares()+" of "+offer.getStockSymbol());
        }
    }



}
