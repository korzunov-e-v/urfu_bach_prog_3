package ru.ekorzunov.urfu_bach_prog_3.lr3.util;

import java.text.SimpleDateFormat;

public class DateTimeUtil {

    public static SimpleDateFormat getCustomFormat() {
        return new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
    }

}