package sebaszczen.unittesting.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sebaszczen.unittesting.repository.DataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
    @Mock
    DataService dataServiceMock;
    @InjectMocks
    SomeBusinessImpl someBusiness = new SomeBusinessImpl();

//    @Before
//    public void beforee() {
//        someBusiness.setDataservice(dataServiceMock);
//    }

    @Test
    public void calculateSumUsingDataService() {
        when(dataServiceMock.getData()).thenReturn(new int[]{1, 2, 3});
        int suma = someBusiness.calculateSumUsingDataService();
        assertEquals(6,suma);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.getData()).thenReturn(new int[]{});
        int suma = someBusiness.calculateSumUsingDataService();
        assertEquals(0,suma);
    }
}