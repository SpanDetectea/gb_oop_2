public class program {

    public static void main(String[] args) {
        Human igor = new Human("Игорь");
        Human zhenya = new Human("Женя");
        Human pavel = new Human("Павел");
        Human Anton = new Human("Антон");
        Human Alex = new Human("Саша");

        Market marketName = new Market();

        marketName.acceptToMarket(igor);
        marketName.acceptToMarket(zhenya);
    
        marketName.giveOrders(igor);
        marketName.giveOrders(zhenya);
        marketName.acceptToMarket(pavel);

        marketName.update();

        marketName.acceptToMarket(Anton);
        marketName.acceptToMarket(Alex);
        marketName.update();

        marketName.takeOrders();
        marketName.allLeave();
        // marketName.releaseFromQueue();
    }
}