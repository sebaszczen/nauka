package multiTh.springBut.supplier;

import org.springframework.stereotype.Service;

public class ApiSupplier {

        public final static String NTHSA_ALL_MAKES = "https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json";
        public final static String NTHSA_MODELS_BY_ID = "https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeId/";
}
