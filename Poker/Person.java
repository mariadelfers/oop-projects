import java.util.*;
/**
	@autor Ma. Fernanda Hernández Enriquez
    @version 1.0

    Defines a person with their basic characteristics	
*/

public class Person
{
	private String name;
	private String lastName;
	private boolean gender; // true = f, false = m
	private char gender1;
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	
	/**
	     Blank constructor, initiates a person without attributes 
	*/
	public Person()
	{
		this.name = "";
		this.lastName = "";
		this.gender = true;
		this.dayOfBirth = 1;
		this.monthOfBirth = 1;
		this.yearOfBirth = 1900;
	}
	
	/**
	     No blank contructor, initiates a person with attributes
		 
		 @param name Name of the person
		 @param lastName Last name of the person
		 @param gender Gender of the person: true for women, false for men
		 @param dayOfBirth day 1 of the month
		 @param monthOfBirth month 1 of the year
		 @param yearOfBirth year in 1900
	*/
	
	public Person(String name, String lastName, boolean gender)
	{
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.dayOfBirth = 1;
		this.monthOfBirth = 1;
		this.yearOfBirth = 1900;
	}
	
	/**
	     No blank contructor, initiates a person with attributes
		 
		 @param name Name of the person
		 @param lastName Last name of the person
		 @param gender Gender of the person: true for women, false for men
		 @param dayOfBirth day of the month in which the person was born
		 @param monthOfBirth month of th year in which the person was born
		 @param yearOfBirth year in which the person was born 
	*/
	
	public Person(String name, String lastName, boolean gender, int dayOfBirth, int monthOfBirth, int yearOfBirth)
	{
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth ;
		this.yearOfBirth = yearOfBirth ;
		
	}
	
	/**
	     No blank contructor, initiates a person with attributes
		 
		 @param name Name of the person
		 @param lastName Last name of the person
		 @param gender Gender of the person: F or f is true and is for women, M or m is for men
		 @param dayOfBirth day 1 of the month
		 @param monthOfBirth month 1 of the year
		 @param yearOfBirth year in 1900
	*/

	public Person (String name, String lastName, char gender1)
	{
		this.name = name;
		this.lastName = lastName;
		this.dayOfBirth = 1;
		this.monthOfBirth = 1;
		this.yearOfBirth = 1900;
	    
       if 
	  (gender1 == 'F' || gender1 == 'f')
	   {
		   this.gender = true;
	   }
       if
	   (gender1 == 'M' || gender1 == 'm')
	   {
		   this.gender = false;
	   }	   
	}
	
	/**
	    Accesor for the name attribute
		@return the name of the person
    */
	public String getName()
	{
		return this.name;
	}
	
    /**
		Mutator for the name attribute
		@param name New name for the person
    */	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	    Accesor for the last name attribute
		@return the last name of the person
    */
	public String getLastName()
	{
		return this.lastName;
	}
	
    /**
		Mutator for the last name attribute
		@param last name New last name for the person
    */	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	    Accesor for the gender attribute
		@return the gender of the person
	*/
    
	public char getGender1()
	{
		return this.gender1;
	}
	
    /**
		Mutator for the gender attribute
		@param gender New gender for the person
	*/	
    	
	public char setGender1(char gender1)
	{
	   if (gender1 == 'F' || gender1 == 'f')
	   {
		   this.gender1 = gender1;
		   return 'F';
	   }
       else if (gender1 == 'M' || gender1 == 'm')
	   {
		   this.gender1 = gender1;
		   return 'M';
	   }   
	   else 
		   return 'N';
	}
	
	
	/**
	    Accesor for the dayOfBirth attribute
		@return the dayOfBirth of the person
    */
	public int getDayOfBirth()
	{
		return this.dayOfBirth;
	}
	
    /**
		Mutator for the dayOfBirth attribute
		@param dayOfBirth New day of birth for the person (only number from 1 to 31 restricted by the month)
    */	
	public boolean setDayOfBirth(int dayOfBirth)
	{
		if (dayOfBirth <= 28 && dayOfBirth > 0)
		{
			this.dayOfBirth = dayOfBirth;
			return true;
		}
		else if (dayOfBirth == 29)
		{
			if(this.monthOfBirth != 2)
			{
				this.dayOfBirth = dayOfBirth;
				return true;
			}
			else if (this.yearOfBirth % 4 == 0) //Multiplo de 4
			{
				this.dayOfBirth = dayOfBirth;
				return true;
			}
			else
				return false;
		}
		else if (dayOfBirth == 30)
		{
			if (this.monthOfBirth == 2)
				return false;
			
			else 
			{
				this.dayOfBirth = dayOfBirth;
				return true;
			}
		}
		else if (dayOfBirth == 31)
		{
			if (this.monthOfBirth == 1 || this.monthOfBirth == 3 || this.monthOfBirth == 5 || this.monthOfBirth == 7 || this.monthOfBirth == 8 || this.monthOfBirth == 10 || this.monthOfBirth == 12)
			{
				this.dayOfBirth = dayOfBirth;
				return true;//month of 31 day Jan, Mar, May, ...
			}
			else 
				return false;
		}
		else
			return false; //month of 32 days
	}
	
	/**
	    Accesor for the monthOfBirth attribute
		@return the monthOfBirth of the person
    */
	public int getMonthOfBirth()
	{
		/**switch (monthOfBirth)
		{
		case 1 : 
		    System.out.println ("January");
			break;
		case 2 : 
		    System.out.println ("Febraury");
			break;
		case 3 : 
		    System.out.println ("March");
			break;	
		case 4 : 
		    System.out.println ("April");
			break;
		case 5 : 
		    System.out.println ("May");
			break;
		case 6 : 
		    System.out.println ("June");
			break;
		case 7 : 
		    System.out.println ("Julio");
			break;
		case 8 : 
		    System.out.println ("August");
			break;
		case 9 : 
		    System.out.println ("September");
			break;
		case 10 : 
		    System.out.println ("October");
			break;
		case 11 : 
		    System.out.println ("November");
			break;
		case 12 : 
		    System.out.println ("December");
			break;	
		default:
             System.out.println ("No valid");	
			break; 
		}
		*/
	   return this.monthOfBirth;
	}
	
	
    /**
		Mutator for the dayOfBirth attribute
		@param dayOfBirth New day of birth for the person (only number from 1 to 31 restricted by the month)
    */	
	public boolean setMonthOfBirth(int monthOfBirth)
	{
		if (monthOfBirth >= 1 && monthOfBirth < 13)
		{
			this.monthOfBirth = monthOfBirth;
			return true;
		}
		else
			return false; 
	}
	
	/**
	    Accesor for the yearOfBirth attribute
		@return the yearOfBirth of the person
    */
	public int getYearOfBirth()
	{
		return this.yearOfBirth;
	}
	
    /**
		Mutator for the yearOfBirth attribute
		@param yearOfBirth New day of birth for the person (only number from 1 to 31 restricted by the month)
    */	
	public boolean setYearOfBirth(int yearOfBirth)
	{   
	    int yearCurr = Calendar.getInstance().get(Calendar.YEAR);
		if (yearOfBirth >= 1900 && yearOfBirth < 2016)
		{
			this.yearOfBirth = yearOfBirth;
			return true;
		}
		else
			return false; 
	}
	
	/**
	    Stringify version of the object 
		@return The object stringified as name_lastName_(G)
	*/
	public String toString()
	{
		String result = this.name + " " + this.lastName;
		
		if (this.gender==true)
		{
		   result += " (F)";
		}
		else 
		{
		   result += " (M)";
		}
		return result;
	}
	
	/**
	Gets the age of the onject based on the current date
	@return the object's age
	*/
	
	public int age()
	{
		int dayCurr = Calendar.getInstance().get(Calendar.DAY_OF_MONTH); //Just day, is of the year, we have to spefic what day
		int monthCurr = Calendar.getInstance().get(Calendar.MONTH) + 1; //Months start with 0
		int yearCurr = Calendar.getInstance().get(Calendar.YEAR);
		
		int age = yearCurr - this.yearOfBirth;
		if(this.monthOfBirth > monthCurr)
			age--;
		else if (this.monthOfBirth == monthCurr && this.dayOfBirth > dayCurr)
			age--;
		
		return age;
	}
		
}