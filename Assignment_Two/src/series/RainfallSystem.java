package series;
import java.util.regex.Pattern;

public class RainfallSystem {

		    public static void main(String[] args) {
		        System.out.println(returnTheLengthOfTheString("")); //0
		        System.out.println(returnTheLengthOfTheString("a")); //1
		        System.out.println(returnTheLengthOfTheString("The Annual Convention of UPE will held in cyberspace on Friday, March 25, 2022, from 1- 3 PM")); //92
		        System.out.println(returnTheLengthOfTheString(null)); //-1
		        
		        System.out.println(returnTheCharacterAtTheGivenIndex("1999", 2)); //9
		        System.out.println(returnTheCharacterAtTheGivenIndex("CSCI1302", 0)); //C
		        System.out.println(returnTheCharacterAtTheGivenIndex("Chicken Wrap", 7)); // white space

		        System.out.println(returnTheSubStringStartingAtTheGivenIndex("1999", 2)); //99
		        System.out.println(returnTheSubStringStartingAtTheGivenIndex("CSCI1302", 0)); //CSCI1302
		        System.out.println(returnTheSubStringStartingAtTheGivenIndex("Chicken Wrap", 7)); // (white space)Wrap

		        System.out.println(returnTheSubStringBetweenStartAndEndIndex("1999", 2,3)); //9
		        System.out.println(returnTheSubStringBetweenStartAndEndIndex("CSCI1302", 0,4)); //CSCI
		        System.out.println(returnTheSubStringBetweenStartAndEndIndex("Chicken Wrap", 4,7)); // ken

		        System.out.println(changeAllOccurancesOf1999To2022("1999")); //2022
		        System.out.println(changeAllOccurancesOf1999To2022("1999 was all about 1999"));
		        System.out.println(changeAllOccurancesOf1999To2022("Two thousand zero zero party over, oops, out of time\r\n"
		                + "(No, no)\r\n"
		                + "So tonight I'm gonna party like it's 1999\r\n"
		                + "Alright, 1999\r\n"
		                + "You say it, 1999\r\n"
		                + "Mmm 1999\r\n"
		                + "(Oww, 1999)")); 

		        System.out.println(checkIfPasswdIsValid("Winter11a")); //true
		        System.out.println(checkIfPasswdIsValid("Wint11a")); //false - less than minimum length
		        System.out.println(checkIfPasswdIsValid("WinterWonderland11a")); //false - more than max length
		        System.out.println(checkIfPasswdIsValid("winter11a")); //false -  does not start with uppercase letter
		        System.out.println(checkIfPasswdIsValid("Winter11A")); //false - does not end with lowercase letter
		        System.out.println(checkIfPasswdIsValid("Winter1_a")); //false - the second to last letter is not a number or !
		        System.out.println(checkIfPasswdIsValid("Winter1!a")); //true
		        System.out.println(checkIfPasswdIsValid("Metere!d")); //true
		        System.out.println(checkIfPasswdIsValid("Secondary!2s")); //true
		        System.out.println(checkIfPasswdIsValid("Breaded!x")); //true

		        System.out.println(countNumberOfValidEmailAddresses("a@b.comjamaicawhatever jam@jammer.edu")); //2
		        System.out.println(countNumberOfValidEmailAddresses("a@b")); //0
		        System.out.println(countNumberOfValidEmailAddresses(".net")); //0
		        System.out.println(countNumberOfValidEmailAddresses("bb@a.net")); //1
		        System.out.println(countNumberOfValidEmailAddresses("forever.and.ever@justdoit.net csciinstructor@georgiasouthern.edu, micromanager@igotnothingbettertodo.com")); //3
		    }
		    
		    /*
		     * return the length of a given string
		     * return -1 is the string is null
		     */
		    
		    public static int returnTheLengthOfTheString(String word) {
		    	if(word==null)// checks for blanks and invalid atatements)
		    		return -1; // returning an int value
		    	else
		    		return word.length();
			        
	
		    }
		    
		   /*
		    *return the character at the given index in word 
		   */
		    public static int returnTheCharacterAtTheGivenIndex(String word, int index) {
		        return word.charAt(index);

		    }
		    
		    /*
		     * return the substring starting from the given index
		     */
		    public static String returnTheSubStringStartingAtTheGivenIndex(String word, int index) {
		        return word.substring(index);
		    }
		    
		    /*
		     * return the substring from the start index to the end index
		     */
		    public static String returnTheSubStringBetweenStartAndEndIndex(String word, int startIndex, int endIndex) {
		        return word.substring(startIndex, endIndex);
		    }
		    
		    /*
		     * if there are occurrences of 1999 in the paragraph, replace with 2022
		     */
		    public static String changeAllOccurancesOf1999To2022(String paragraph) {
		        return paragraph.replaceAll("1999", "2022");// replaces characters
		    }
		    
		    /*
		     * A valid password has the following pattern
		     * - starts with an uppercase letter
		     * - ends with a lowercase letter
		     * - the second to last character is either a number or !
		     * - the length is at least 8 but no more than 12  
		     */
		    public static boolean checkIfPasswdIsValid(String passwd) {
		        if (passwd.length()<8 || passwd.length()>12)//checks password length
		        	return false;
		        int len=passwd.length();
		        if(!Character.isUpperCase(passwd.charAt(0))|| !Character.isLowerCase(passwd.charAt(len-1)))
		        	return false;
		        if (!(passwd.charAt(len - 2)== '!')&& !Character.isDigit(passwd.charAt(len - 2)))
		        	return false;
		        return true;
		    }
		    
		    /*
		     * For the purposes of this assignment, assume a valid email address has the following pattern
		     * - four parts:
		     * -- Recipient name - made up of uppercase and lowercase letters, digits 0 to 9. Length at least 1, but no more than 32 
		     * -- @ symbol
		     * -- Domain name - made up of uppercase and lowercase letters, digits 0 to 9. Length at least 1, but no more than 32
		     * -- Top-level domain -  either .com or .net or .edu
		     */
		    public static int countNumberOfValidEmailAddresses(String fileDump) {
		      String emailList[] = fileDump.split("");// retreives files 
		      final String EMAIL="[A-za-z0-9+_.-]{1,32}+@(?:a-zA-Z0-9-}+\\.)+[a-zA-Z]{1,32}$";//check email address algo
		      final Pattern p =Pattern.compile(EMAIL);
		      
		      int count =0;
		      for (String string :emailList) {
		    	  if (p.matcher(string).matches())//see if it matches
		    		  count++;// counts in order/ scans
		    	  
		      }
		      return count;
		    }
		  
		    

		

	}


