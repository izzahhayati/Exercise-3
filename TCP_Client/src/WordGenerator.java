
/**
 * This class to count number of words.
 * 
 * by  Izzah Hayati 
 *
 */
public class WordGenerator {

	public int countTotalWords(String sentence) {
		int wordscount=0;
		for(int i = 0; i < sentence.length()-1; i++) {  
			//Calculation: include space in string
			//First space cant be included
			if(sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i+1)) && (i > 0)) {  
				wordscount++;  
			}  
		}  
		//To count the last word present in the string, increment wordCount by 1  
		wordscount++;  

		return wordscount;
	}
} 
