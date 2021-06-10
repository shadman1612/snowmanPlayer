package snowmanrunner;
import java.util.*;

public class SnowmanPlayer {
	private static List<String> myWords = new LinkedList<String>();
        private static int myLength = 0; 
        private static int size =0;
        private static List<String> words2 = new LinkedList<String>();
  
/**
 * This method returns the name of the player
 * @return name the name of the player
 */    
public static String getAuthor() {
   String name = "Md.Shadman, Baig";
    return name;
} 
/**
 * This method provides the player with information about the boundaries of the game
 * @param words an array containing all the possible words
 * @param minLength an minimum length of the secret word
 * @param maxLength the maximum length of the secret word
 * @param allowedChars a String containing the allowed characters 
 */
public static void startGame(String[] words, int minLength, int maxLength, String allowedChars) {
words2 = Arrays.asList(words);
}
/**
 * This method provides the player with length of the secret word
 * @param length an integer containing the length of the secret word
 */
public static void startNewWord(int length) {
    myLength = length;
for(int i=words2.size()-1; i>=0; i--){ // for loop adds evelemts to new arraylist based on length of the word
                 if((words2.get(i).length() == myLength))
                        myWords.add(words2.get(i));              
                 } 
}
/**
 * This method provides the player with information about the secret word allows the player to guess a character 
 * @param pattern a string containing the secret word with correctly guessed chars revealed
 * @param previousGuesses a string containing all the previous guesses, both hits and misses
 * @return the char the player wants to guess 
 */
public static char guessLetter(String pattern, String previousGuesses) {
 int max=0, count=0, count2=0, count3=0, a=0, v=0;
 char charSend ='a', r='y';
 String letters = "abcdefghijklmnopqrstuvwxyz";
 String let="", strSend = "", miss="", hit="", startLetter = "eai";
 int[] countAr = new int[26], countAr2 = new int[26];
 char[] letArr = letters.toCharArray();
 char[] pAr = pattern.toCharArray();
 char[] pGAr = previousGuesses.toCharArray();
 
 if((myLength>=5) && (myLength<=12))
     startLetter = "e";
 else 
     startLetter = "i";
  
 if (previousGuesses.equals("")){ //this sends the first letter as either e or i
        return startLetter.charAt(0);
}
else { 
     for(int q=0; q<pGAr.length; q++){//the previousGuesses is split into a Char Array and misses and hits are determined
         let = String.valueOf(pGAr[q]);
            if(!pattern.contains(let))
                miss+=let;
            else if(pattern.contains(let))
                hit+=let;
     }
    char[] missAr = miss.toCharArray();//the misses and hits and converted from a string to a char array to it is easier to loop through 
    char[] hitAr = hit.toCharArray();
    
    for(int n=0; n<letArr.length; n++){
        count=0; 
     for (int m=0; m<pAr.length; m++){//for loop counts how many times is letter is repeated in the appern
            if(pAr[m] == letArr[n])
                count++;
    }
        countAr2[n] = count;
    }
    for(int i=0; i<countAr2.length; i++){//for loop determines the word that is repeated the most
        if(countAr2[i]>=a){
            a=countAr2[i]; 
            r=letArr[i];
        }
    }
    
    for(int x=(myWords.size()-1); x>-1; x--){
     strSend = myWords.get(x);
     count2=0;
        for(int z=0; z<missAr.length; z++){//if word in array list of all possible words contain a missed word, it is removed
            let = String.valueOf(missAr[z]);      
                 if (strSend.contains(let))
                     myWords.remove(x);
               }
       
        for(int m=0; m<hitAr.length; m++){     
           if ((strSend.indexOf(hitAr[m])) != (pattern.indexOf(hitAr[m])))//if index of letter in pattern dont watch with the selected word, it is removed
               myWords.remove(x);
        }
        
        if(strSend.contains(String.valueOf(r))){//if the most repeated letter in pattern dont match with the most repeated letter in the selected work, it is removed
            for(int h=0; h<strSend.length(); h++){
                if(strSend.charAt(h) == r)
                    count2++;  
               }
        }
        if(count2 != a)
            myWords.remove(strSend);    
    }



    for(int n=0; n<letArr.length; n++){
        count3=0; 
        for (int m=(myWords.size()-1); m>-1; m--){
            if(myWords.get(m).contains(String.valueOf(letArr[n]))) //determines the most common char in the arraylist 
                count3++;
        }
        countAr[n] = count3;
    }
for(int i=0; i<countAr.length; i++){
    if(!(previousGuesses.contains(String.valueOf(letArr[i])))){
        if(countAr[i]>max){
            max=countAr[i];
            v=i;
                    }
        }
    charSend=letArr[v];
    }
if(!(previousGuesses.contains(String.valueOf(charSend)))) //this is a backup, just in case the above fails, it sends chars from the alphabet
return charSend;
else {
    for(int i=0; i<letArr.length; i++){
        if(!(previousGuesses.contains(String.valueOf(letArr[i]))))
            charSend = letArr[i];
    }
}
}
 return charSend;
}
}


 

    

    
 




