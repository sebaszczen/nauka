package sebaszczen.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;


public class ThrowExeption implements CommandLineRunner {
    Logger logger = LogManager.getLogger(ThrowExeption.class);

    @Override
    public void run(String... strings) {
        try {
            throwException();
        } catch (MyException e) {
            logger.error("ojjoj",e);
        }
    }

    private void throwException() throws MyException {

    }

}
