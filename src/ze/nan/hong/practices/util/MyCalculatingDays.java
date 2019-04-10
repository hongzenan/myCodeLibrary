package ze.nan.hong.practices.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyCalculatingDays {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = "23 01 1997";
        String inputString2 = "27 04 1997";

        try {
            Date date1 = simpleDateFormat.parse(inputString1);
            Date date2 = simpleDateFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

