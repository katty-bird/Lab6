package main;

public class BirthdayChecker {
	
	public static void main (String args []) {
		JulianDate birthday = new JulianDate(1986, 10, 4);
		JulianDate birthday2 = new JulianDate(1993, 2, 21);
		//float older = birthday2.daysBetween();
        System.out.println("Your birthday in Julian time: " + birthday.julianDayNumber);
        //System.out.println("Age difference: " + older);   
    }
}
