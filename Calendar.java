/**
 * Created by chuck on 5/11/17.
 * Return date after n days from defaut date
 */
public class Calendar {
    int year;
    int month;
    int day;
    static final int[] MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] LEAP_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDay(int days) {
        int curDay = day;
        int curMon = month;
        int curYear = year;

        // Add year
        // The year after leap year doesn't has 2.29

        while (days >= 366) {
            if (curMon == 2 && curDay == 29) {
                curDay--;
                days++;
            }
            if (isLeapYear(curYear) && curMon <= 2 && curDay <= 28 || (isLeapYear(curYear + 1) && curMon > 2)) {
                days -= 366;
            } else {
                days -= 365;
            }
            curYear++;
        }

        int daysLeft = getLeftDays(curYear, curMon, curDay);
        if (daysLeft < days) {
            days -= daysLeft;
            curYear++;
            curMon = 1;
            curDay = 1;
        }

        // Add month
        int[] months;
        if (isLeapYear(curYear)) {
            months = LEAP_MONTH;
        } else {
            months = MONTH;
        }

        if (days > 31) {
            days -= months[curMon - 1] - curDay + 1;
            curMon++;
            curDay = 1;

            while (days > 31) {
                days -= months[curMon - 1];
                curMon++;
            }
        }
        // Add day
        if (curDay + days > months[curMon - 1]) {
            curDay = days - (months[curMon - 1] - curDay);
            curMon++;
        } else {
            curDay += days;
        }
        System.out.println(curYear + "-" + curMon + "-" + curDay);
    }

    private int getLeftDays(int y, int m, int d) {
        int[] months;
        int curMonth = m;

        if (isLeapYear(y)) {
            months = LEAP_MONTH;
        } else {
            months = MONTH;
        }

        int days = 0;
        days += months[curMonth - 1] - d;

        curMonth++;
        while (curMonth <= 12) {
            days += months[curMonth - 1];
            curMonth++;
        }
        return days;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Calendar c = new Calendar(2016, 1, 4);
        for (int i = 1; i < 100; i++) {
            c.addDay(i);
        }
    }
}
