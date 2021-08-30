public class StringOccurencesExample {

		
		public static Integer valueOccurences(final String input, final String value) {
			
			char[] inputCharArray = input.toCharArray();
			char[] valueCharArray = value.toCharArray();
			
			int occurences = 0;
			for (int i = 0; i < inputCharArray.length; i++) {
				
				int count = 0;
				
				for (int j = 0; j < valueCharArray.length; j++) {
					
					
					if (inputCharArray[i+j] == valueCharArray[j]) {
						count++;
					}else {
						break;
					}
					
					if (count == valueCharArray.length) {
						occurences++;
					}
					
				}
			}
			return occurences;
			
		}
		
	    public static void main(String[] args) throws Exception {

	    	
	    	String input = "abcattdfcattgh";
	    	String value = "catt";
	    	System.out.println(valueOccurences(input, value));
	    }
	}
