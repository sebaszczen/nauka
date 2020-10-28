package sebaszczen.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void size_returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void size_returnWithParameters(){
        when(mock.get(0)).thenReturn(2);
        assertEquals(2,mock.get(0));
        assertEquals(null,mock.get(3));
    }

    @Test
    public void size_returnWithAnyParameter(){
        when(mock.get(anyInt())).thenReturn(22);
        when(mock.get(3)).thenReturn("hej");
        assertEquals(22,mock.get(23));
        assertEquals(22,mock.get(5));
        assertEquals("hej",mock.get(3));
    }

    @Test
    public void verificationTest() {
        mock.get(222);
        mock.get(222);
        Mockito.verify(mock, new Times(2)).get(222);
        Mockito.verify(mock, times(2)).get(222);
        Mockito.verify(mock,  atLeast(1)).get(222);
        verify(mock, never()).get(3);
        verify(mock,times(2)).get(222);

    }

    @Test
    public void argumentCapuring() {
        //SUT
//        mock.add("test");
        mock.add("xx");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(argumentCaptor.capture());
        assertEquals("test",argumentCaptor.getValue());
    }

    @Test
    public void multipleArgumentCapuring() {
        //SUT
        mock.add("test");
        mock.add("test2");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(argumentCaptor.capture());
        List<String> captorAllValues = argumentCaptor.getAllValues();
        assertEquals("test", captorAllValues.get(0));
        assertEquals("test2", captorAllValues.get(1));
    }

    class person{
        String name;

        public person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List add(List list) {
        list.add(new Integer(22));
        return list;
    }

    @Test
    public void mocking() {
//        a method doesnt retain behaviour of the original(real) class
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        arrayListMock.add("test");
        arrayListMock.add(11);
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

    }

    @Test
    public void spying() {
        //a spy by default retains behaviour or the original class
        ArrayList arrayListSpy = spy(ArrayList.class);
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("test");
        arrayListSpy.add(11);
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
        verify(arrayListSpy).add(11);

    }

}



