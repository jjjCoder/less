/**
 * Created by SBTJavastudent on 13.08.2016.
 */
public class Truck {
    private long id;
    private String type;//kamaz, maz...
    private int capacity;
    public Truck(long id, int capacity){
        this.id = id;
        this.capacity=capacity;
    }

    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
}
