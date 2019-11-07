package sebaszczen.unittesting.business;

import sebaszczen.unittesting.repository.DataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private DataService dataservice;

    public void setDataservice(DataService dataservice) {
        this.dataservice = dataservice;
    }

    public int calculateSum(int[] data) {
        Arrays.stream(data).parallel().forEach(System.out::println);
        Arrays.stream(data).reduce(Integer::sum);
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = dataservice.getData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
