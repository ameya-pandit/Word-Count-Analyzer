//These are the imports needed to run the program
import java.io.*;
import java.util.*;

public class Bard   {
    static Hashtable<String, storeValue> table = new Hashtable<String, storeValue>();  //initializing the hash table
    static ArrayList<ArrayList<storeValue>> sort;  //creating an arrayList of arrayList

    static int inputLength; //the length of the word from the input file
    static int inputFreq;   //the frequency of the word from the input file

    public static void main(String [] args) throws IOException  {
        if(args.length < 2){
            System.out.println("Usage: java –jar Bard.jar <input file> <output file>");
            System.exit(1);
        }

        Scanner in = new Scanner(new File("shakespeare.txt"));  //reading in the shakespeare.txt file
        Scanner fileInput = new Scanner(new File(args[0])); //reading in the input file
        PrintWriter out = new PrintWriter(new File(args[1])); //printWriter to print out file

        int maxLength = 0;  //length of the biggest word
        
        while (in.hasNextLine())    {  //while shakespeare.txt has words
            String convert = in.nextLine();    //using this string to convert punctuation to white space
            convert = convert.replace("?", " ");
            convert = convert.replace(",", " ");
            convert = convert.replace(".", " ");
            convert = convert.replace("!", " ");
            convert = convert.replace(":", " ");
            convert = convert.replace(";", " ");
            convert = convert.replace("[", " ");
            convert = convert.replace("]", " ");
            convert = convert.toLowerCase();   //converting string to lower case characters

            String [] input = convert.split("\\s+");   //splitting by whitespace

            for (int i = 0; i < input.length; i++)  {               
                String temp = input[i];   //putting elements of the array into a string
                
                storeValue word = table.get(temp);    //process of putting the individual words into the hash table

                if (word == null)   {   //if the word doesn't exist
                    word = new storeValue(temp, 1);  //this is a new word
                    if(word.getLength() > maxLength) {   //if the word is the biggest word encountered
                        maxLength = word.getLength();   //take note of how big this word is                        
                    }
                    table.put(temp, word);  //put this word object into the table
                } else  {
                    word.incFreq();  //if the word exists, increase the frequency
                }
            }       
        }

        //process of adding elements and sorting the elements so that they are easily accessible
        sort = new ArrayList<ArrayList<storeValue>>(maxLength+1);   //initialize this sort array
        for(int i = 0; i < maxLength+1; i++) {
            sort.add(i, new ArrayList<storeValue>());   //basically initializing every element of this big array - you're adding stuff to it
        }

        for (storeValue s: table.values())  {
            int index = addInOrder(sort.get(s.getLength()), s);
            (sort.get(s.getLength())).add(index, s);
        }

        //process of parsing the input file - user input/output
        while (fileInput.hasNextLine()) {   
            String [] parseFileInput = fileInput.nextLine().split(" ");
            inputLength = Integer.parseInt(parseFileInput[0]);  //the first input is the word length
            inputFreq = Integer.parseInt(parseFileInput[1]);    //second input is the frequency
            
            if ((inputLength >= 0) && (inputFreq >= 0)) {   //in case of negative numbers
                if ((inputLength < sort.size()) && (inputFreq < (sort.get(inputLength).size())))    {   //if the length is lower than the max length and frequency lower 
                                                                                                    //than the most frequent word of that length
                    out.println(sort.get(inputLength).get(inputFreq));
                } else {
                    out.println("-");
                }
            } else {
                out.println("-");
            }
            
        }
        in.close(); //closing scanners
        fileInput.close(); //closing scanners
        out.close();    //closing scanners
    }

    public static int addInOrder (ArrayList<storeValue> order, storeValue s) {  //adding elements to array using compareTo function written in storeValue
        int index = 0;
        while(index < order.size() && order.get(index).compareTo(s) > 0) {
            index++;
        }
        return index;
    }
}
