package pl.basic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrasowanieDat {

    public static void main(String[] args) {

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime currentDate = LocalDateTime.now().withNano(0);

        LocalDateTime toSql = LocalDateTime.parse("2018-08-11 11:10:33",formatter);
//        toSql=currentDate;
        System.out.println(toSql);
    }
}
