package br.com.sitedoph.uniph.infraestrutura.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by paulohl on 22/02/2016.
 */
public class DataUtil {

    public static java.sql.Date converteDataCalendarSQL(final Calendar data) {

        final java.sql.Date dataSQL = new java.sql.Date(data.getTimeInMillis());

        return dataSQL;
    }

    public static Calendar converteDataSQLCalendar(final java.sql.Date data) {

        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(data.getTime());

        return cal;
    }

    public static Calendar converteDataStringCalendar(final String dataString) {

        if (dataString == null) {
            throw new RuntimeException("Data Inválida");
        }

        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(dataString);
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            return cal;
        } catch (final ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Data Inválida");
        }

    }

    public static Calendar converteDataUtilCalendar(final Date date) {

        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }

    public static String formataDataCalendarDDMMYYYY(final Calendar data) {

        final String DATE_FORMAT = "dd/MM/yyyy";
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(data.getTime());
    }

}
