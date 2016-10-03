package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private static  int wordLength = DEFAULT_WORD_LENGTH;
    private Random random = new Random();

    private ArrayList<String> wordList = new ArrayList<String>();
    private HashSet<String> wordSet = new HashSet<String>();
    private HashMap<String, ArrayList<String>> lettersToWord = new HashMap<String,ArrayList<String>>();
    private HashMap<Integer, ArrayList<String>> sizeToWords = new HashMap<Integer,ArrayList<String>>();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();

            wordSet.add(word);
            wordList.add(word);

            ArrayList<String> temp_words1 = new ArrayList<String>();

            ArrayList<String> temp_words2 = new ArrayList<String>();
            // l takes the  size of the current word.
            // then we will use this 'l' as key
            //to get all possible words of that size
            int l = word.length();

            //if-else works similar to earlier concept of hashmap letterToWord 
            if(sizeToWord.containsKey(l))
            {
                temp_words2 = sizeToWord.get(l);
                temp_words2.add(word);
                sizeToWord.put(l,temp_words2);
            }
            else
            {
                temp_words2.add(word);
                sizeToWord.put(l,temp_words2);
            }


            String sortWord;
            sortWord = alphabeticalOrder(word);

            if(lettersToWord.containsKey(sortWord)){

                temp_words1 = lettersToWord.get(sortWord);
                temp_words1.add(word);
                lettersToWord.put(sortWord,temp_words1);
            }
            else{
                temp_words1.add(word);
                lettersToWord.put(sortWord,temp_words1);
            }


        }
    }

    public boolean isGoodWord(String word, String base) {
        
        if (wordSet.contains(word) && !word.contains(base))
            return true;
        else
            return false;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        
        ArrayList<String> result = new ArrayList<String>();
        //Sort the word first
        String sortedWord = alphabeticalOrder(word);
        String newWord;
        //for loop for adding one more character
        for(char c = 'a'; c<= 'z'; c++){
            //creating the new word
            newWord = c + sortedWord;
            //again sorting this word
            newWord = alphabeticalOrder(newWord);
            //Adding all words to array list (dont check isGoodWord)
            if(lettersToWord.containsKey(newWord)){
                result.addAll(lettersToWord.get(newWord));
            }
        }

        //Now in this array we will filter arraylist result
        //with the help of isGoodWord Method.
       for(int i = 0; i<result.size();i++){
           Log.d("AD list ",result.get(i));
           if(!isGoodWord(result.get(i),word)) {
            result.remove(i);
           }
       }

        return result;
    }

    public String pickGoodStarterWord() {

        //Creating a new word
        String word = new String();
        int j;

        //taking arrayList as lengthWords
        ArrayList<String> lengthWords =  new ArrayList<>();

        //our aim is that the word length should never exceed 7
        //getting all words of a fixed size into lengthWords 
        if(wordLength <= MAX_WORD_LENGTH){
            lengthWords = sizeToWord.get(wordLength);
        }

        //getting size of all possible words of a fixed size
        int i = random.nextInt(lengthWords.size());

        //now we will pick a random word from the arraylist
        for(j = i; j < lengthWords.size(); j++) {

            //Checking all the conditions and returning the word.
            if(getAnagramsWithOneMoreLetter(lengthWords.get(j)).size() >= MIN_NUM_ANAGRAMS)
            {
                //Log.d("word ",lengthWords.get(j));
                word = lengthWords.get(j);
                break;
            }
        }

        if(j == lengthWords.size() && word == null) {

            for (j = 0; j < i; j++) {
                if (getAnagramsWithOneMoreLetter(lengthWords.get(j)).size() >= MIN_NUM_ANAGRAMS) {
                    word = lengthWords.get(j);
                    break;
                }
            }

        }

        //Max wordLength can be & only.
        if(wordLength < MAX_WORD_LENGTH)
            wordLength++;

        return word;
    }
}
