import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class HashTable {

public static void printStats(Hashtable<String, String> dictTable,
           int numberOfWords) {

       int min = dictTable.size();
       int max = numberOfWords;
       double mean = (min + max) / 2.f;
       System.out.println("minimum maximum mean");
       System.out.println(" "+min+" \t "+max+" \t "+mean);
   }

   @SuppressWarnings("resource")
   public static void main(String[] args) throws FileNotFoundException {

       int numberOfWords = 0;
       int count = 1;
       Hashtable<String, String> dictionaryTable = null;
       Hashtable<String, String> wordsNotFound = new Hashtable<String, String>();

       Scanner scan = new Scanner(new File("dictionary.txt"));
       if (scan.hasNextLine()) {
           numberOfWords = Integer.parseInt(scan.nextLine());
           dictionaryTable = new Hashtable<String, String>(numberOfWords);
       }
       while (scan.hasNextLine()) {
           String word = scan.nextLine();
           dictionaryTable.put(word, word);
       }


       scan = new Scanner(new File("document.txt"));
       while (scan.hasNextLine()) {
           String docWord = scan.nextLine();

           String fromDic = dictionaryTable.get(docWord);

           if (fromDic == null) {
               wordsNotFound.put(docWord, docWord);
           }
       }
       System.out.println("Words not found in dictionary: ");
       Set<String> keys = wordsNotFound.keySet();
       for(String key: keys){
           System.out.println(count+++": "+wordsNotFound.get(key));
       }

  printStats(dictionaryTable, numberOfWords);

   }

}

