package com.finance.common.utils;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
    private static final ZoneId zoneId = ZoneId.systemDefault();
    // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
    public static LocalDate from(Date date){
        Objects.requireNonNull(date);
        final Instant instant = date.toInstant();
        return instant.atZone(zoneId).toLocalDate();
    }
}
