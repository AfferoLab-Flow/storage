package net.afferolab;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

public abstract class Configuration {

    private static final Integer EXPIRATION = 60;

    public Date getExpirationDate(Optional<Integer> expiration) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(new Date());

        if (expiration.isPresent()) {
            calendar.add(Calendar.MINUTE, expiration.get());
        } else {
            calendar.add(Calendar.MINUTE, EXPIRATION);
        }

        return calendar.getTime();
    }

}
