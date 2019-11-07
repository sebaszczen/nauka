package sebaszczen.unittesting.business;

import org.junit.Test;
import org.mockito.Mock;
import sebaszczen.unittesting.repository.DataService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{1, 2, 3});
        int expectedREsult = 6;
        assertEquals(expectedREsult,actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedREsult = 0;
        assertEquals(expectedREsult,actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        int x[] = {1, 2, 3};
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{5});
        int expectedREsult = 5;
        assertEquals(expectedREsult,actualResult);
    }

    @Test
    public void calculateSumUsingDataService() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.getData()).thenReturn(new int[]{1, 2, 3});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setDataservice(dataServiceMock);
        int suma = someBusiness.calculateSumUsingDataService();
        assertEquals(6,suma);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.getData()).thenReturn(new int[]{});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setDataservice(dataServiceMock);
        int suma = someBusiness.calculateSumUsingDataService();
        assertEquals(0,suma);
    }
}