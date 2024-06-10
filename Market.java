import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Human> actors = new ArrayList<Human>();
    private List<Actor> humanInQueue = new ArrayList<Actor>();

    public void allLeave() {
        if (humanInQueue.size() > 0) {
            while (humanInQueue.size() > 0) {
                takeOrders();
            }
        }
        if (actors.size()>0) {
            while (actors.size() > 0) {
                releaseFromMarket();
            }
        }
    }

    @Override
    public void acceptToMarket(Human actor) {
        actors.add(actor);
        System.out.println(actor.getName() + " Вошел в магазин");
    }

    @Override
    public void releaseFromMarket() {
        System.out.println(actors.getFirst().getName() + " Вышел из магазина");
        actors.remove(0);
    }

    @Override
    public void update() {
        if (humanInQueue.size() > 0) {
            System.out.println("\n");
            System.out.println("В очереди находятся: " + humanInQueue.size());
            for (Human actor : actors) {
                if (actor.isMakeOrder()) {
                    System.out.println(actor.getName() + " Ожидает свой заказ в очереди");
                }
                if (actor.isTakeOrder()) {
                    System.out.println(actor.getName() + " Получил заказ");
                }
            }
            System.out.println("\n");
        }
        System.err.println("Всего в магазине находится: " + actors.size() + " людей");
        System.out.println("\n");
    }

    @Override
    public void giveOrders(Human actor) {
        System.out.println(actor.getName() + " Сделал заказ");
        takeInQueue(actor);
        actor.setMakeOrder(true);
    }

    @Override
    public void releaseFromQueue() {
        System.out.println(humanInQueue.getFirst().getName() + " Вышел из очереди");
        humanInQueue.remove(0);
        releaseFromMarket();
    }

    @Override
    public void takeInQueue(Human actor) {
        System.out.println(actor.getName() + " Встал в очередь");
        humanInQueue.add(actor);
    }

    @Override
    public void takeOrders() {
        humanInQueue.getFirst().setTakeOrder(true);
        System.out.println(humanInQueue.getFirst().getName() + " Получил заказ");
        releaseFromQueue();
    }

}