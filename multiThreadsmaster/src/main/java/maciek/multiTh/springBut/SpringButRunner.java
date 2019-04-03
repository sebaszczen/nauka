package maciek.multiTh.springBut;

import maciek.multiTh.springBut.domain.VehicleModel;
import maciek.multiTh.springBut.service.VehicleApiRetriever;
import maciek.multiTh.springBut.service.VehicleTestingThreadsImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class SpringButRunner implements CommandLineRunner {

    private static Logger LOGGER = LogManager.getLogger(SpringButRunner.class);

    @Autowired
    private VehicleApiRetriever vehicleApiRetriever;
    @Autowired
    private VehicleTestingThreadsImpl vehicleTestingThreads;

    @Override
    public void run(String... args) throws Exception {
//        oneThreadRandomId();
//        oneThred();
//        defaultThredPoolSizeParallel();
//        fixedThredPoolSizeParallel();
        multiThredsAsFuture();


    }


//    public void oneThreadRandomId() {
//        long startTime = System.currentTimeMillis();
//        Map<Integer, List<VehicleModel>> modelsNoExecutor = vehicleTestingThreads.getModelsNoExecutor(3);
//        modelsNoExecutor.forEach((k, v) -> System.out.println("MakeID: " + k + ", " + "models: " + v));
//        LOGGER.info("\u001B[34mTime tneeded to get " + modelsNoExecutor.size() + "vehicle brands ->  "
//                + (System.currentTimeMillis() - startTime) + "ms\u001B[0m");




    public void oneThred() {
        long startTime = System.currentTimeMillis();
        Map<Integer, List<VehicleModel>> modelsNoExecutor = vehicleTestingThreads.getModelsNoExecutor();
//        modelsNoExecutor.forEach((k, v) -> System.out.println("MakeID: " + k + ", " + "models: " + v));
        LOGGER.info("\u001B[34mTime needed to get " + modelsNoExecutor.size() + " vehicle brands ->  "
                + (System.currentTimeMillis() - startTime) + "ms\u001B[0m");
    }

    public void defaultThredPoolSizeParallel() {
        long startTime = System.currentTimeMillis();
        Map<Integer, List<VehicleModel>> modelsNoExecutor = vehicleTestingThreads.getModelsParallel();
//        modelsNoExecutor.forEach((k, v) -> System.out.println("MakeID: " + k + ", " + "models: " + v));
        LOGGER.info("\u001B[34mTime needed to get " + modelsNoExecutor.size() + " vehicle brands ->  "
                + (System.currentTimeMillis() - startTime) + "ms\u001B[0m");
    }

    public void fixedThredPoolSizeParallel() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Map<Integer, List<VehicleModel>> modelsNoExecutor = vehicleTestingThreads.getModelsParallelFixedThredPool();
        LOGGER.info("\u001B[34mTime needed to get " + modelsNoExecutor.size() + " vehicle brands ->  "
                + (System.currentTimeMillis() - startTime) + "ms\u001B[0m");
    }

    public void multiThredsAsFuture() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Map<Integer, CompletableFuture<List<VehicleModel>>> modelsNoExecutor15Async = vehicleTestingThreads.getModelsExecutorAsync();
        modelsNoExecutor15Async.entrySet().forEach(t-> CompletableFuture.allOf(t.getValue()).join());
//        map.forEach((k, v) -> System.out.println("MakeID: " + k + ", " + "models: " + v));

        LOGGER.info("\u001B[34mTime needed to get " + modelsNoExecutor15Async.size() + " vehicle brands ->  "
                + (System.currentTimeMillis() - startTime) + "ms \u001B[0m");
    }
}
