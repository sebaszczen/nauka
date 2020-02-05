package sebaszczen.quartzScheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.Calendar;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;
import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerKey.triggerKey;


public class QuartMain {

    static class Rower{
        private List partsList =new ArrayList();

        private List getPartsList() {
            return partsList;
        }

    }

    public static void main(String[] args) throws SchedulerException, ParseException, IOException {

        LocalDate lastDayofCurrentMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayofCurrentMonth.getDayOfMonth());

        for (int i = 0; i <5; i++) {
            System.out.println(i);
        }

        TimeZone tz = TimeZone.getTimeZone("Poland");
        TimeZone usa = TimeZone.getTimeZone("America/New_York");
        System.out.println(usa.getDisplayName());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date dateBeforeDST = df.parse("2018-03-25 01:55");
//        Calendar cal = Calendar.getInstance(tz);
//        cal.setTime(dateBeforeDST);
//
//        System.out.println(cal.getTime());
//        cal.add(Calendar.MINUTE, 5);
//        System.out.println(cal.getTime());
//        TimeZone.setDefault(cal.getTimeZone());
//        System.out.println(new Date());
//        System.out.println(cal.getTime());
//        cal.add(Calendar.MINUTE, -20);
//        System.out.println(cal.getTime());


        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).build();
        JobDetail jobDetail2 = JobBuilder.newJob(QuartzJob2.class).build();
//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("t1").startNow().build();

//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("t1").withSchedule(CronScheduleBuilder.
//                cronSchedule("0 0/1 * 1/1 * ? *")).build();


        Date startScheduler = df.parse("2018-03-20 03:00");
        Date startScheduler2 = df.parse("2019-12-04 13:48");
        Calendar start = Calendar.getInstance(Locale.US);
        start.setTime(startScheduler2);

        CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder = calendarIntervalSchedule();

        TriggerBuilder<Trigger> triggerTriggerBuilder = newTrigger();
        Trigger build = triggerTriggerBuilder.build();

        System.out.println(start.getTime()+ " should start");
        Trigger t1 = newTrigger().startAt(start.getTime()).withIdentity("t1").
                withSchedule(calendarIntervalSchedule().withIntervalInDays(1).withMisfireHandlingInstructionDoNothing().preserveHourOfDayAcrossDaylightSavings(false)).build();

        System.out.println("czas startu "+t1.getStartTime());

        Trigger simpleTrigger = newTrigger().startAt(start.getTime()).withIdentity("t1").
                withSchedule(calendarIntervalSchedule().withIntervalInDays(1).withMisfireHandlingInstructionDoNothing().preserveHourOfDayAcrossDaylightSavings(true)).build();

        System.out.println(t1.getStartTime());

//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("t1").withSchedule(CronScheduleBuilder.
//                cronSchedule(" 0 0,4 0,4 ? * * *").inTimeZone(usa)).build();

//        Trigger t2 = TriggerBuilder.newTrigger().startNow().withIdentity("t2").
//                withSchedule(calendarIntervalSchedule().withIntervalInMinutes(1).withMisfireHandlingInstructionDoNothing()).build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, t1);
//        scheduler.scheduleJob(jobDetail2, t2);
    }
}
