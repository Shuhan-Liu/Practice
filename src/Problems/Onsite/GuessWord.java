package Problems.Onsite;

import Tool.Printer;

import java.util.*;

/**
 * Created by shuhanliu on 3/26/19.
 */
public class GuessWord {

    static class Master{

        String secretWord;
        int numTry;

        public Master(String[] wordlist) {
            Random rand = new Random();
            secretWord = wordlist[rand.nextInt(wordlist.length)];
            numTry = 1;
            System.out.println("WORDLIST: ");
            Printer.printArr(wordlist);
            System.out.println("SECRET: " + secretWord);
        }

        public int guess(String word) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == secretWord.charAt(i))
                    count++;
            }
            System.out.println("TRY: " + numTry);
            System.out.println("GUESS: " + word);
            System.out.println("NUM MATCHES: " + count);
            numTry ++;
            return count;
        }
    }

    public static void main(String[] args) {
        String[] wordlist = {"acckzz","ccbazz","eiowzz","abcczz"};
        Master master = new Master(wordlist);
        guessWord(wordlist, master);
    }

    public static void guessWord(String[] wordlist, Master master) {
        List<String> wordList = Arrays.asList(wordlist);
        List<String> toKeep = new ArrayList<>();
        int numMatches = 0;
        int wordLength = wordList.get(0).length();

        while (numMatches != wordLength && wordList.size() > 0) {
            Map<String, Integer> map = new HashMap<>();
            for (String w1 : wordList) {
                for (String w2 : wordList) {
                    if (countMatch(w1, w2) == 0) {
                        map.put(w1, map.getOrDefault(w1, 0) + 1);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            String guess = wordList.get(0);

            for (String key : map.keySet()) {
                if (map.get(key) < min) {
                    min = map.get(key);
                    guess = key;
                }
            }

            numMatches = master.guess(guess);

            if (numMatches == wordLength)
                return;

            for (String w : wordList) {
                if (countMatch(w, guess) == numMatches) {
                    toKeep.add(w);
                }
            }

            wordList = new ArrayList<>(toKeep);
            toKeep.clear();
        }

    }

    public static int countMatch(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i))
                count++;
        }
        return count;
    }
}
