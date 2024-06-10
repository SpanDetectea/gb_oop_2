public interface QueueBehaviour {

    void takeInQueue(Human actor);

    void takeOrders();

    void giveOrders(Human actor);

    void releaseFromQueue();
    

    
}