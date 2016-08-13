import java.util.Arrays;
import java.util.List;

/**
 * Created by SBTJavastudent on 13.08.2016.
 */
public class TruckDaoMemoryImpl implements TruckDao{
    @Override
    public List<Truck> list(){
        return Arrays.asList(
                new Truck(1, 10),
                new Truck(2, 30),
                new Truck(3, 1),
                new Truck(4, 50),
                new Truck(5, 5)
        );
    }
}
