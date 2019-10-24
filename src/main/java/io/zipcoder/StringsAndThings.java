package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive).
     * We'll say that y or z is at the end of a word if there is not an alphabetic letter immediately following it.
     * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */



    //count the number of words ending in 'y' or 'z'
    //i have a sentence.
    public Integer countYZ(String input) {
        Integer result = 0;
        //split input on spaces to find words
        String[] words = input.split(" ");
        for (int currentIndex = 0; currentIndex < words.length; currentIndex++) {
            //look at each word
            String word = words[currentIndex];
            //get last index of word
            int lastIndex = word.length()-1;

            //get last character of word
            char lastChar = word.charAt(lastIndex);

            //check  if they're y or z
            if (lastChar == 'y' || lastChar == 'z') {
                result++;
            }
        }
        return result;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    //return a version of the base string where all instances of the remove string have
    //been removed
    //given
    public String removeString(String base, String remove) {
        //String .replace will replace all characters in base from remove with an empty string
        //when
        String result = base.replace(remove, "" );
        //then
        return result;

    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    //given
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int numberOfIs = getNumberOfOccurrences(input, "is");
        int numberOfNot = getNumberOfOccurrences(input, "not");
        return numberOfIs == numberOfNot;
    }

    private int getNumberOfOccurrences(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
    }
    /**
         * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
         * Return true if all the g's in the given string are happy.
         * example : gHappy("xxggxx") // Should return  true
         * gHappy("xxgxx") // Should return  false
         * gHappy("xxggyygxx") // Should return  false
         */
    //given
    public Boolean gIsHappy(String input) {
        boolean happy = false;
        // makes a loop through input
        for (int currentindex = 0; currentindex < input.length()-2; currentindex++) {
            //checks if 'g' is at current index && next index for a 'g'
            if (input.charAt(currentindex) == 'g' && input.charAt(currentindex + 1) == 'g') {
                happy = true;
                //checks if 'g' is at current index && index before 'g' is a 'g'
            }else if(input.charAt(currentindex) == 'g' && input.charAt(currentindex - 1) != 'g'){
                happy = false;
                break;
            }
        }
        return happy;
    }

    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        int count = 0;

        for(int i = 0; i <= input.length() - 3; i++) {
            if(input.charAt(i) == input.charAt(i+1) &&
                    input.charAt(i) == input.charAt(i+2))
                count++;
        }

        return count;

    }

}

