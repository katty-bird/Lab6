package main;

import java.util.Scanner;
import java.time.LocalDate;


/**
 * This class gives the age of the person in days 
 * and tells on which day of the week he was born
 * @author katja
 * @author lucas
 * @version 0.1
 */

public class BirthdayChecker {
	/** variables and fields **/
	public static JulianDate currentJulianDate = JulianDate.today();
	private static Scanner in = new Scanner(System.in);

	public static void main (String args []) {
		System.out.println("Julian time today: " + currentJulianDate.julianDayNumber);
		JulianDate birthday1 = checkBirthday();
		JulianDate birthday2 = checkBirthday();
		
		//compares who's older
		if (birthday1.isAfter(birthday2)) {
			System.out.println("\nPerson1 is younger than Person2");
		} else {
			System.out.println("\nPerson1 is older than Person2");
		}
		
		in.close();
    }
	
    //Methods
    /**
     * Returns the age of the person in days
     * @param 
     * @return Julian date at time of birth
     */
	public static JulianDate checkBirthday() {
		System.out.print("Enter your birthday (according to the format yyyy mm dd): ");
		
		int input;
		int[] birth = new int[3];
		for (int i = 0; i<birth.length; i++) {
			input = in.nextInt();
			birth[i] += input;
		}
		
		JulianDate birthday = new JulianDate(birth[0], birth[1], birth[2]);	
			
		Float ageIntoDays = currentJulianDate.daysBetween(birthday);
		System.out.println("You are " + ageIntoDays + " days old.");
		
		LocalDate currentDay = LocalDate.now();
		if (currentDay.getMonthValue() == birth[1] && currentDay.getDayOfMonth() == birth[2]) {
			System.out.println("Happy birthday to you!");
		}
		
		if (ageIntoDays % 100 == 0) {
			System.out.println("Days lived: 100 x " + (int) (ageIntoDays/100) + " times");
		}
		dayOfWeek(birthday.julianDayNumber);
		return birthday;
	}
	
    /**
     * Calculates the day of the week 
     * @param 
     * @return the day of the week on which the person was born
     */
	public static void dayOfWeek(float birthday) {
		int dayOfWeek = (int) birthday % 7; 
		
		String dayOfWeek1 = null;
	
        switch(dayOfWeek)
        {
        	case 0:
            dayOfWeek1 = "Tuesday\n" + "Tuesday's child is full of grace";
            break;

            case 1:
            dayOfWeek1 = "Wednesday\n" + "Wednesday's child is full of woe";
            break;

            case 2:
            dayOfWeek1 = "Thursday\n" + "Thursday's child has far to go";
            break;

            case 3:
            dayOfWeek1 = "Friday\n" + "Friday's child is loving and giving";
            break;

            case 4:
            dayOfWeek1 = "Saturday\n" + "Saturday's child must work hard for a living";
            break;

            case 5:
            dayOfWeek1 = "Sunday\n" + "The child who was born on the Sabbath day\n" 
            			 + "Is fair and wise and good and gay";
            break;

            case 6:
            dayOfWeek1 = "Monday\n" + "Monday's child is fair of face";
            break;

        } 
        String output ="\nYou were born on a " + dayOfWeek1;
        System.out.println(output);
	}
	
}
