import java.util.*;

public class storeValue	implements Comparable<storeValue> {
	String word;	//the word
	int length;	//length of the word
	int rank;	//frequency - ranking based on how often it appears

	public storeValue()	{	//basic constructor
		word = "";
		length = 0;
		rank = 0;
	}

	public storeValue(String s, int freq)	{	//constructor for new words
		word = s;
		length = s.length();
		rank = freq;
	}

	public void incFreq()	{	//increase frequency method
		rank++;
	}

	public String getWord() {	//retrieve the word method
		return word;
	}

	public int getLength() {	//get length of the word method
		return length;
	}

	public int getRank() {	//retrieve the rank of the word method
		return rank;
	}

	public String toString() {	//convert the word to a string
		return word + "";
	}

	public int compareTo(storeValue a) {	//sorting the words once they are in the table
		if(this.getRank() != a.getRank()) {
			return this.getRank() - a.getRank();
		}
		return a.getWord().compareTo(this.getWord());
	}
}
