package ee.bcs.java.demo.tasks;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeLearning {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today + "                  today");
        //System.out.println(today.toString());
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS); //рассчитаем новую дату = отнимем/прибавим дни
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(tomorrow + "                 tomorrow");
        System.out.println(yesterday + "                 yesterday");

        LocalDate myBirthday = LocalDate.of(1984, Month.MAY, 18);
        System.out.println(myBirthday + "               my birthday");
        //System.out.println(myBirthday.toString());

        System.out.println();
        System.out.println("all available timexones:");
        // prints all available timezone ids
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Tallinn");
        ZoneId zone2 = ZoneId.of("Europe/Berlin");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //парсинг
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2020", germanFormatter);
        System.out.println(xmas);   // 2020-12-24

        ////////////////////////////////////////////////////////
        System.out.println();

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false
        System.out.println(now1 + "             time of zone Europe/Tallinn");
        System.out.println(now2 + "             time of zone Europe/Berlin");
        System.out.println(now1.getHour());
        System.out.println(now1.getMinute());
        now1 = now1.withSecond(6); // 20:30:06
        System.out.println(now1);
        now1 = now1.plusMinutes(3); // 20:33:06
        System.out.println(now1);

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween + "           hours between Berlin and Tallinn");       // -1
        System.out.println(minutesBetween + "          minutes between Berlin and Tallinn");     // -60

        LocalTime late = LocalTime.of(23, 59, 59); //парсинг строк
        System.out.println(late);       // 23:59:59

        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter1);
        System.out.println(leetTime);   // 13:37

        LocalDate independenceDay = LocalDate.of(2020, Month.FEBRUARY, 24);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek + "           independece day in 2020");    // Monday

        ////////////////////////////////////////////////////////
        System.out.println();

        LocalDateTime alice = LocalDateTime.of(2012, Month.JUNE, 7, 23, 59, 59);

        DayOfWeek dayOfWeek1 = alice.getDayOfWeek();
        System.out.println(dayOfWeek1);      // WEDNESDAY

        Month month = alice.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = alice.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

/*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 06, 2020 - 13:24", formatter);
        String string = parsed.format(formatter);
        System.out.println(string);     // Nov 03, 2014 - 07:13

*/


    }
}
