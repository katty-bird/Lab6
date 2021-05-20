package main;

import java.time.LocalDateTime;

/**
 *
 */
public class JulianDate {

    //Class variables
    public static final LocalDateTime START_DATE = LocalDateTime.of(-4712, 1, 1, 12,0, 0, 0);
    public static int JGREG = 15 + 31*(10+12*1582);
    public static double HALFSECOND = 0.5;

    public static void main (String args []) {

        //Spielbereich, dass muss später noch weg

        JulianDate jd = new JulianDate();

        int[] ymd = {2021, 5 ,19};
        int[] date = jd.convertToCalendar(jd.convertToJulianDate(19,5,2021));

        System.out.println(date[2] + "/" + date[1] + "/" + date[0]);


        System.out.println();

    }

    /** Constructors **/

    public JulianDate() {
    }

    public JulianDate(int year, int month, int day) {
    }


    /**
     * Converts the given date to Julian date.
     * @param day
     * @param month
     * @param year
     * @return Julian Date as double (like 2459354.0)
     */
    public double convertToJulianDate(int day, int month, int year) {

        int julianYear = year;
        int julianMonth = month;
        double julian = 0;

        if (year < 0) julianYear++;
            if (month > 2) {
                julianMonth++;
            }
            else {
                julianYear--;
                julianMonth += 13;
            }

        julian = (java.lang.Math.floor(365.25 * julianYear) + java.lang.Math.floor(30.6001*julianMonth) + day + 1720995.0);

        if (day + 31 * (month + 12 * year) >= JGREG) {

            // change over to Gregorian calendar
            int ja = (int)(0.01 * julianYear);
            julian += 2 - ja + (0.25 * ja);
        }
        return java.lang.Math.floor(julian);
    }


    /**
     * Converts a Julian date to calendar date
     * @param julianDate
     * @return
     */
    public int[] convertToCalendar (double julianDate) {

        int jMain,ja,jb,jc,jd,je,year,month,day;

        double julian = julianDate + HALFSECOND / 86400.0;
        ja = (int) julian;
        if (ja>= JGREG) {
            jMain = (int) (((ja - 1867216) - 0.25) / 36524.25);
            ja = ja + 1 + jMain - jMain / 4;
        }

        jb = ja + 1524;
        jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
        jd = 365 * jc + jc / 4;
        je = (int) ((jb - jd) / 30.6001);
        day = jb - jd - (int) (30.6001 * je);
        month = je - 1;

        if (month > 12) month = month - 12;
            year = jc - 4715;

        if (month > 2) year--;
        if (year <= 0) year--;

        return new int[] {year, month, day};
    }


    /**
     * Return the days since Julian day
     */
    public void daysBetween() {

    }

    /**
     * Return the tomorrow day
     */
    public void tomorrow() {

    }

    /**
     * Returns yesterday
     */
    public void yesterday() {

    }
}
