package practise;



	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class Mask1 {
//	    public static void main(String[] args) {
//	        String input = "123-45678-90 and 98765-4321 are examples";
//	        String result = maskDigitsBetweenHyphens(input);
//
//	        System.out.println("Result: " + result);
//	    }
//
//	    private static String maskDigitsBetweenHyphens(String input) {
//	        // Define a regex pattern to match digits between hyphens
//	        String numberRegex = "(?<=-)(\\d+)(?=-)";
//
//	        // Compile the pattern
//	        Pattern pattern = Pattern.compile(numberRegex);
//
//	        // Create a matcher with the input string
//	        Matcher matcher = pattern.matcher(input);
//
//	        // Find and replace each matched number
//	        StringBuffer resultBuffer = new StringBuffer();
//	        while (matcher.find()) {
//	            String matchedNumber = matcher.group();
//	            String maskedNumber = maskDigits(matchedNumber);
//	            matcher.appendReplacement(resultBuffer, maskedNumber);
//	        }
//	        matcher.appendTail(resultBuffer);
//
//	        return resultBuffer.toString();
//	    }
//
//	    private static String maskDigits(String number) {
//	        // Mask all digits except the last 4
//	        int length = number.length();
//	        StringBuilder maskedNumber = new StringBuilder();
//	        for (int i = 0; i < length - 4; i++) {
//	            maskedNumber.append('*');
//	        }
//	        maskedNumber.append(number.substring(length - 4));
//
//	        return maskedNumber.toString();
//	    }
		
		 public static void main(String[] args) {
		        String input = "Phone: 123-45-6789, +1212345-6789, Another Phone: 987-65-4321";
		        String result = maskDigitsBetweenHyphens(input);

		        System.out.println("Result: " + result);
		    }

		    private static String maskDigitsBetweenHyphens(String input) {
		        // Define a regex pattern to match phone numbers and SSNs
		        String regex = "\\d{1,7}\\-?\\d{1,3}\\-?\\d{4}";

		        // Compile the pattern
		        Pattern pattern = Pattern.compile(regex);

		        // Create a matcher with the input string
		        Matcher matcher = pattern.matcher(input);

		        // Find and replace each matched phone number or SSN
		        StringBuffer resultBuffer = new StringBuffer();
		        while (matcher.find()) {
		            String matchedValue = matcher.group();
		            String maskedValue = maskDigitsBetweenHyphens1(matchedValue);
		            System.err.println(maskedValue);
		            matcher.appendReplacement(resultBuffer, maskedValue);
		        }
		        matcher.appendTail(resultBuffer);

		        return resultBuffer.toString();
		    }

		    private static String maskDigitsBetweenHyphens1(String value) {
		    	StringBuffer maskedValue= new StringBuffer("");  
		        // Mask digits between hyphens
		        String[] parts = value.split("-");
		        if (parts.length == 3) {
		            // Assuming the format is xxx-xx-xxxx
		        	if(parts[0] != null) {
		        		maskedValue = mask(maskedValue, parts[0].toCharArray());
		        	}
		        	maskedValue.append("-");
		        	
		        	if(parts[1] != null && parts[1].length() > 0 ) {
		        		maskedValue = mask(maskedValue, parts[1].toCharArray());
		        	}
		            maskedValue.append(parts[2]);
		            
		        	
		            return maskedValue.toString();
		        } if (parts.length == 2) {
		            // Assuming the format is xxx-xx-xxxx
		        	if(parts[0] != null) {
		        		maskedValue = mask(maskedValue, parts[0].toCharArray());
		        	}
		        	maskedValue.append("-");
		        	
		        	
		            maskedValue.append(parts[1]);
		            
		        	
		            return maskedValue.toString();
		        } else {
		            // If not in the expected format, return the original value
		            return value;
		        }
		    }

			private static StringBuffer mask(StringBuffer maskedValue, char[] parts) {
				for(int i=0;i<parts.length ;i++) {
					maskedValue.append("X");
				}
				return maskedValue;
			}
	}

