package jp.ac.nig.ddbj.wabi.imputation.util;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class IdGenerator {

    static public String generate() {
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        LocalTime timeObj = LocalTime.now();
        String time = String.format("%02d%02d", timeObj.getHour(), timeObj.getMinute());

        UUID uuidv4 = UUID.randomUUID();

        return String.join("_", date, time, uuidv4.toString());
    }



}
