import java.util.*;

/**
 * Created by SBTJavastudent on 13.08.2016.
 */
public class Application {
    private Map<Long, Truck> truckRegistry;
    //multimap!
    private Map<String, List<Truck>> truckRegistryByType;

    public Application(TruckDao truckDao) {
        List<Truck> list = truckDao.list();
        truckRegistry = new HashMap<>();
        for (Truck truck : list) {
            Truck previousValue = truckRegistry.put(truck.getId(), truck);
            if (null != previousValue) {
                throw new IllegalArgumentException("dva traktora s odnim Id");
            }
        }
    }

    void viewTruckRegistry() {
        System.out.println(truckRegistry);
    }

    public Truck getTruckById(long truckId) {
        Truck truck = truckRegistry.get(truckId);
        if (truck == null) {
            throw new IllegalArgumentException("truck not found with Id " + truckId);
        }
        return truck;
    }
    public Truck getTruckByType(){return null;}

    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            System.exit(1);
        }
        TruckDao truckDao = new TruckDaoMemoryImpl();
        Application application = new Application(truckDao);
        long truckId = Long.parseLong(args[0]);
        Truck truckById = application.getTruckById(truckId);
        System.out.println(truckById.getCapacity());
    }

    private static void printHelp() {
        System.out.println("Use first argument as truck Id");
    }
}
