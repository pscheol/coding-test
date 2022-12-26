package coding.programmers.level0;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Date {
    public static void main(String[] args) {
        LocalDateTime nowDtm = LocalDateTime.now();
        LocalDate nowDate = nowDtm.toLocalDate();
//        LocalTime nowTime = nowDtm.toLocalTime();
        LocalTime nowTime = LocalTime.of(0, 0, 0);

        LocalTime startTime = LocalTime.of(10, 0, 0);
        LocalTime endTime = LocalTime.of(6, 0, 0);

        //10:00 ~ 06:00
        if (!(((nowTime.isAfter(startTime) || nowTime.equals(startTime)) && (nowTime.isBefore(LocalTime.MAX) || nowTime.equals(LocalTime.MAX)))
                || ((nowTime.isAfter(LocalTime.MIDNIGHT) || nowTime.equals(LocalTime.MIDNIGHT)) && nowTime.isBefore(endTime)))) {
            return;
        }
        if ((nowTime.isAfter(LocalTime.MIDNIGHT) || nowTime.equals(LocalTime.MIDNIGHT)) && nowTime.isBefore(endTime)) {
            System.out.println("자정넘음");
        }
        if ((nowTime.isAfter(startTime) || nowTime.equals(startTime)) && (nowTime.isBefore(LocalTime.MAX) || nowTime.equals(LocalTime.MAX))) {
            System.out.println("자정전");
        }
    }
}
