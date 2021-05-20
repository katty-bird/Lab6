package result.main;

import java.time.LocalDateTime;

/**
 * This class contains the new datatype JulianDate
 * @author katja
 * @author lucas
 * @version 0.1
 */

public class JulianDate {

    /** variables and fields **/
    public static final LocalDateTime START_DATE = LocalDateTime.of(-4712, 1, 1, 12,0, 0, 0);
    public float julianDayNumber;


    /** Constructors **/
    public JulianDate() {
    }

    public JulianDate(int year, int month, int day) {
    	this.julianDayNumber = this.toJulianDate(year, month, day);
    }

    /**
     * Returns the days between given date and Julian day
     * @param compareDate
     * @return
     */
    public Float daysBetween(JulianDate compareDate) {
    	if (compareDate.julianDayNumber > this.julianDayNumber) {
    		 return compareDate.julianDayNumber - this.julianDayNumber;
    	} else {
    		return this.julianDayNumber - compareDate.julianDayNumber;
    	}  
    }

    /**
     * Returns tomorrow in Julian date
     */
    public void tomorrow() {
        //TODO Methode erstellen
    }

    /**
     * Returns yesterday in Julian date
     */
    public void yesterday() {
        //TODO Methode erstellen
    }

    /**
     * Converts the given date to Julian date
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static float toJulianDate(int year, int month, int day) {
    	if (month == 1 || month == 2) {
    		year -= 1;
    		month += 12; // Thus, we are thinking of January and February 
    		             // as being the 13th and 14th month of the previous year
    	}
    	int a = year / 100;
    	int b = a / 4;
    	int c = 2 - a + b;

    	int e = (int)(365.25 * (year + 4716));
    	int f = (int) (30.6001 * (month + 1));

    	float julianDay = (float) (c + day + e + f - 1524.5);

    	return julianDay;
    }
}