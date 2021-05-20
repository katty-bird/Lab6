package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 */

public class JulianDate {

    //Class variables
    public static final LocalDateTime START_DATE = LocalDateTime.of(-4712, 1, 1, 12,0, 0, 0);


    public static void main (String args []) {

        System.out.println("Start date: " + START_DATE);
        System.out.println("Julian date: " + toJulianDate(1582, 10, 15));
    }


    //Fields

	public float julianDayNumber;


    //Constructors
    public JulianDate() {
    }

    public JulianDate(int year, int month, int day) {
    	this.julianDayNumber = this.toJulianDate(year, month, day);
    }


    //Methods
    public Float daysBetween(JulianDate otherDate) {
    	if (otherDate.julianDayNumber > this.julianDayNumber) {
    		 return otherDate.julianDayNumber - this.julianDayNumber;	
    	} else {
    		return this.julianDayNumber - otherDate.julianDayNumber;
    	}  
    }

    public void tomorrow() {

    }

    public void yesterday() {

    }
    
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
    	float jd = (float) (c + day + e + f - 1524.5);
    	return jd;	
    }
}