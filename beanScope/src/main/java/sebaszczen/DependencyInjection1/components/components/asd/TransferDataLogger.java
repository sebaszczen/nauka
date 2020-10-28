package sebaszczen.DependencyInjection1.components.components.asd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.atomic.AtomicBoolean;



public class TransferDataLogger {

    public static void main(String[] args) {
        System.out.println(Day.valueOf("MONDAY"));
    }

enum Day{
        MONDAY, FRIDAY;
    }

}