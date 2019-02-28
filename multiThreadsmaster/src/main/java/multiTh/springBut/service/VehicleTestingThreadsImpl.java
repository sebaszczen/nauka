package multiTh.springBut.service;

import multiTh.springBut.domain.VehicleMake;
import multiTh.springBut.domain.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Service
public class VehicleTestingThreadsImpl {

    @Autowired
    private VehicleApiRetriever vehicleApiRetriever;
    private final int[] ids = {442, 443, 445, 450, 461, 465, 469, 471, 482, 523, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500, 7600, 8000};

//    public Map<Integer, List<VehicleModel>> getModelsNoExecutor(int numberOfBrands) {
//        List<VehicleMake> vehicleModelList = new ArrayList<>();
//        Map<Integer, List<VehicleModel>> vehMap = new HashMap<>();
//        IntStream.range(0, numberOfBrands).forEach(m -> {
//            Integer makeID = vehicleModelList.get(new Random().nextInt(vehicleModelList.size() + 1)).getMakeID();
//            vehMap.put(makeID, vehicleApiRetriever.vehicleMakeList(makeID));
//        });
//        return vehMap;
//    }

    public Map<Integer, List<VehicleModel>> getModelsNoExecutor() {
        Map<Integer, List<VehicleModel>> vehMap = new HashMap<>();
        Arrays.stream(ids)
                .forEach(t -> {
                    vehMap.put(t, vehicleApiRetriever.vehicleMakeList(t));
                });
        return vehMap;
    }

    public Map<Integer, List<VehicleModel>> getModelsParallel() {
        Map<Integer, List<VehicleModel>> vehMap = new HashMap<>();
        Arrays.stream(ids)
                .parallel()
                .forEach(t -> {
                    vehMap.put(t, vehicleApiRetriever.vehicleMakeList(t));
                });
        return vehMap;
    }

    public Map<Integer, List<VehicleModel>> getModelsParallelFixedThredPool() {
        Map<Integer, List<VehicleModel>> vehMap = new HashMap<>();
        ForkJoinPool fjp = new ForkJoinPool(4 * Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(4 * Runtime.getRuntime().availableProcessors());
        try {
            fjp.submit(() -> Arrays.stream(ids)
                    .parallel()
                    .forEach(t -> {
                       vehMap.put(t, vehicleApiRetriever.vehicleMakeList(t));
                    }));
            //tak executor zadziałał na fixedThredPool

            Arrays.stream(ids)
                    .forEach(t -> {
                        Callable<List<VehicleModel>> listCallable = () -> vehMap.put(t, vehicleApiRetriever.vehicleMakeList(t));
                        Future<List<VehicleModel>> submit = executorService.submit(listCallable);
                        try {
                            submit.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            fjp.shutdown();
        }
        try {
            fjp.awaitTermination(1, TimeUnit.DAYS);
//            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vehMap;
    }

    public Map<Integer, CompletableFuture<List<VehicleModel>>> getModelsExecutorAsync() {
        Map<Integer, CompletableFuture<List<VehicleModel>>> vehMap = new HashMap<>();
        Arrays.stream(ids).forEach(t -> {
            vehMap.put(t, vehicleApiRetriever.vehicleMakeListAsync(t));
        });

        return vehMap;
    }
}
