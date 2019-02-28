package multiTh.springBut.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import multiTh.springBut.domain.VehicleModel;
import multiTh.springBut.domain.VehicleModelResponseAll;
import multiTh.springBut.supplier.ApiSupplier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class VehicleApiRetriever {

    private static final Logger LOGGER = LogManager.getLogger(VehicleApiRetriever.class);
    private RestTemplate restTemplate = new RestTemplate();

//    public List<VehicleMake> vehicleModelList() {
//        LOGGER.info("\u001B[33mLOOOKIG FOR Vehicles makes, \nTHREAD ID: " + Thread.currentThread().getId()
//                + "\nTHREAD NAME: " + Thread.currentThread().getName() + "\u001B[0m");
//        String nthsaAllMakesURL = ApiSupplier.NTHSA_ALL_MAKES;
//        ResponseEntity<VehicleMakeResponseAll> responseEntity = restTemplate.getForEntity(nthsaAllMakesURL, VehicleMakeResponseAll.class);
//        List<VehicleMake> results = responseEntity.getBody().getResults();
//        System.out.println("KING SIZE: " + results.size());
//        return results;
//    }

    public List<VehicleModel> vehicleMakeList(int makeID) {
        String nthsaModelsByIdUrl = ApiSupplier.NTHSA_MODELS_BY_ID + makeID+"?format=json";
        LOGGER.info("\u001B[32mLOOOKIG FOR Vehicles models for make ID-> , "+ makeID + "\n THREAD ID: " + Thread.currentThread().getId()
                + "\nTHREAD NAME: " + Thread.currentThread().getName()+  "\n URL " + nthsaModelsByIdUrl + "\u001B[0m");
        ResponseEntity<VehicleModelResponseAll> responseAllResponseEntity = restTemplate.getForEntity(nthsaModelsByIdUrl,VehicleModelResponseAll.class);
        List<VehicleModel> results = responseAllResponseEntity.getBody().getResults();
        return results;
    }

    @Async
    public CompletableFuture<List<VehicleModel>> vehicleMakeListAsync(int makeID) {
        String nthsaModelsByIdUrl = ApiSupplier.NTHSA_MODELS_BY_ID + makeID+"?format=json";
        LOGGER.info("\u001B[31mLOOOKIG FOR Vehicles models for make ID-> , "+ makeID + "\n THREAD ID: " + Thread.currentThread().getId()
                + "\nTHREAD NAME: " + Thread.currentThread().getName() + "\n URL " + nthsaModelsByIdUrl + "\u001B[0m");
        ResponseEntity<VehicleModelResponseAll> responseAllResponseEntity = restTemplate.getForEntity(nthsaModelsByIdUrl,VehicleModelResponseAll.class);
        List<VehicleModel> results = responseAllResponseEntity.getBody().getResults();

        return CompletableFuture.completedFuture(results);
    }

//    @Async
//    public CompletableFuture<List<VehicleModel>> vehicleMakeListN(int makeID) {
//        String nthsaModelsByIdUrl = ApiSupplier.NTHSA_MODELS_BY_ID + makeID+"?format=json";
//        LOGGER.info("\u001B[31mLOOOKIG FOR Vehicles models for make ID-> , "+ makeID + "\n THREAD ID: " + Thread.currentThread().getId()
//                + "\nTHREAD NAME: " + Thread.currentThread().getName() + "\n URL " + nthsaModelsByIdUrl + "\u001B[0m");
//        ResponseEntity<VehicleModelResponseAll> responseAllResponseEntity = restTemplate.getForEntity(nthsaModelsByIdUrl,VehicleModelResponseAll.class);
//        List<VehicleModel> results = responseAllResponseEntity.getBody().getResults();
//        return CompletableFuture.completedFuture(results);
//    }
}
