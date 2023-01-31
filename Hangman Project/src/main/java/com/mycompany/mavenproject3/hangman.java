package com.mycompany.mavenproject3;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Course Code: ICS 3U
 * Teacher Name: Mr.Tonet
 * Creator Name: Jack Yu
 * Date: January 30, 2023
 * Program Name: Hangman
 * Rationale of Program: This program is design to enable the user to play a game of hangman. Rather than two players, the user, themselves, will have to guess a words that generates randomly. There are several difficulties, each set with differing amounts of lives.
 */

public class hangman {

    private static final Scanner sc = new Scanner(System.in); //scanner object
    private static String userGuess; //string variable
    private static String callWordBank; //string variable
    private static char letter; //character variable
    private static int guesses; //int variable
    private static boolean isGuessed = true; //boolean variable
    private static String convertRandomWordtoString; //string variable

    private static final ArrayList<Character> usedLetters = new ArrayList<>(); //create an ArrayList object

    public static void main(String[] args) throws InterruptedException {

        gameStartMainMenu(); //call method gameStartMainMenu

    }

    public static void gameStartMainMenu() throws InterruptedException { //method for the main menu

        do { //executes the following lines of code at least once, regardless of any conditions
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed
            System.out.println("====================================="); //displays equality signs
            System.out.println("        Hangman Game: Main Menu      "); //displays menu title
            System.out.println("                                     "); //displays menu
            System.out.println("-------------------------------------"); //displays dashes 
            System.out.println("            P - Play Game            "); //displays menu options
            System.out.println("         I - Game Instructions       "); //displays menu options
            System.out.println("              E - Exit               "); //displays menu options 
            System.out.println("====================================="); //displays equality signs
            System.out.print("Choose: "); //prompts for user input
            String userChoice = sc.nextLine().toUpperCase(); //stores user input
            switch (userChoice) { //switch statement
                case "P": //if "P" is true, calls the method gameModeMenu
                    gameModeMenu(); //calls the method gameModeMenu
                    break; //break out of swtich
                case "I": //if "I" is true, calls the method gameInstructions
                    gameInstructions(); //calls the method gameInstructions
                    break; //break out of switch
                case "E": //if "E" is true, exits the current program
                    System.out.println("Exiting..."); //prints Exiting...
                    System.exit(0); //termintes the running Java virutal machine
                default: //if none of the cases are true, inform user to re-enter an existing option
                    System.out.println("Try again"); //inform user to re-etner an existing option
                    Thread.sleep(1500); //suspends execution for 1.5 seconds.
                    break; //break out of swtich
            }
        } while (true); //loops while condition is true
    }

    public static void gameInstructions() throws InterruptedException { //method for the game instructions

        do { //executes the following lines of code at least once, regardless of any conditions
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //new lines are printed
            System.out.println("==================================================================="); //displays equality signs
            System.out.println("                           How to Play                             "); //displays menu title
            System.out.println("-------------------------------------------------------------------"); //displays dashes
            System.out.println("Hangman is a simple word guessing game. Players try to figure out  "); //displays instructions
            System.out.println("an unknown word by guessing the letters. If too many letters which "); //displays instructions
            System.out.println("do not appear in the word are guessed, the player is hanged (and   "); //displays instructions
            System.out.println("loses). Depending on the level of difficulty you select, you will  "); //displays instructions
            System.out.println("receive a finite number of attempts to guess. Each incorrect guess "); //displays instructions
            System.out.println("will decrease the amount of attempts you have. While each correct  "); //displays instructions
            System.out.println("guess will leave the amount of attempts you have stagnant. The     "); //displays instructions
            System.out.println("player wins when they correctly identify all the letters of the    "); //displays instructions
            System.out.println("unknown word                                                       "); //displays instructions
            System.out.println("-------------------------------------------------------------------"); //displays dashes
            System.out.println("                             B - Back                              "); //displays menu options
            System.out.println("==================================================================="); //displays equality signs
            System.out.print("Choose: "); //prompts for user input
            String userChoice = sc.nextLine().toUpperCase(); //stores user input
            switch (userChoice) { //swtich statememt
                case "B": //if "P" is true, return to main menu 
                    gameStartMainMenu(); //calling the method gameStartMainMenu
                    break; //break out of switch
                default: //if none of the cases are true, inform user to re-enter an existing option
                    System.out.println("Try again"); //informs user to re-enter an existing option
                    Thread.sleep(1500); //suspends execution for 1.5 seconds
                    break; //break out of switch
            }
        } while (true); //loops while condition is true
    }

    public static void gameModeMenu() throws InterruptedException { //method for game mode menu

        boolean menuClose = false; //boolean variable is set to false
        do { //executes the following lines of code at least once, regardless of any conditions
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("====================================="); //displays equality signs
            System.out.println("       Hangman Game: Game Modes      "); //displays menu title
            System.out.println("-------------------------------------"); //displays dashes
            System.out.println("        E - Easy (11 Guesses)        "); //displays menu options
            System.out.println("        M - Medium (9 Guesses)       "); //displays menu options
            System.out.println("        H - Hard (7 Guesses)         "); //displays menu options
            System.out.println("        U - Unlimited Guesses        "); //displays menu options
            System.out.println("              B - Back               "); //displays menu options
            System.out.println("====================================="); //displays equality signs
            System.out.print("Choose: "); //prompts for user input
            String userChoice = sc.nextLine().toUpperCase(); //stores user input
            switch (userChoice) { //swtich statement 
                case "E": //if "E" is true, call the method easy
                    easy(); //calling the method easy
                    menuClose = true; //sets boolean menuClose to true
                    break; //break out of switch
                case "M": //if "E" is true, call the method medium
                    medium(); //calling the method medium
                    menuClose = true; //sets boolean menuClose to true
                    break; //break out of switch
                case "H": //if "E" is true, call the method hard
                    hard(); ///calling the method hard
                    menuClose = true; //sets boolean menuClose to true
                    break; //break out of switch
                case "U": //if "E" is true, call the method unlimited
                    unlimited(); //calling the method unlimited
                    menuClose = true; //sets boolean menuClose to true
                    break; //break out of switch
                case "B": //if "E" is true, call the method easy
                    menuClose = true; //sets boolean menuClose to true
                    break; //break out of switch
                default: //if none of the cases are true, inform user to re-enter an existing option
                    System.out.println("Try again"); //informs user to re-enter an existing option
                    Thread.sleep(1500); //suspends execution for 1.5 seconds
            }
        } while (!menuClose); //loops while menuClose is false
    }


    public static String wordList() { //method that generates a random word

        String[] wordBank = {"ACQUIESCE", "ACRONYM", "AMBIGUITY", "ANALOGY", "ANACHRONISM", "ANDRAGOGY", "ANTITHESIS", "ANTONYM", //array of words 
            "ARTICULATE", "ASSONANCE", "BENCHMARKING", "BRAINSTORMING", "CIRCUMSPECT", "CLANDESTINE", "COGNITION", "COLLABORATE",
            "COLLOQUIAL", "CONNOTATION", "CONTRIVED", "CONUNDRUM", "CORRELATION", "CRITERION", "CUMULATIVE", "CURRICULUM",
            "DEFERENCE", "DEVELOPMENTAL", "DIALECT", "DICTION", "DIDACTIC", "DISSERTATION", "DIVERGENT", "EGREGIOUS",
            "ELOQUENCE", "EMERGENT", "EMPATHY", "ENIGMA", "EPITOME", "EPIPHANY", "EPITAPH", "ERUDITE",
            "EXISTENTIAL", "EXPONENTIAL", "FORMATIVE", "HOLISTIC", "HOMONYM", "HUBRIS", "HYPERBOLE", "INCONGRUOUS",
            "INFAMY", "INITIATION", "INNATE", "INTELLECTUAL", "INTERACTIVE", "IRONY",  "JARGON", "JUXTAPOSITION",
            "MALAPROPISM", "MAGNANIMOUS", "MENTOR", "METAPHOR", "METICULOUS", "MNEMONIC", "MONOLOGUE", "MOTIF",
            "MYRIAD", "NEMESIS", "NOMINAL", "NORMS", "OBFUSCATE", "OBTUSE", "ONOMATOPOEIA", "OSTENTATIOUS",
            "OXYMORON", "PARADOX", "PARAPHRASE", "PEDANTIC", "PEDAGOGY", "PERUSAL", "PHONEMES", "PHONOLOGICAL",
            "PLAGIARISM", "PLETHORA", "POSTHUMOUSLY", "PREPOSITION", "PRETENTIOUS", "PSEUDONYM", "REFERENCES",
            "REFLECTION", "RUBRIC", "SARDONIC", "SATIRE", "SIMILE", "SOLILOQUY", "SUPERFLUOUS", "SYNTAX",
            "THESIS", "VALIDITY", "VERNACULAR", "VIRTUAL", "VOCATIONAL"};

         
        callWordBank = wordBank[(int) (Math.random() * wordBank.length)]; //assigns callWordBank an index of the wordbank
        return callWordBank; //returns the word
    }

    //Is the user's guess a letter? return true if it is or return false if it isn't
    public static boolean isLetter(String word) throws InterruptedException { //method for checking user's input

        if (word.length() > 1) {  //checks if the user's guess is a single letter
            System.out.println("Please enter only one character"); //informs user to enter only one letter
            Thread.sleep(1500); //suspends exeuction for 1.5 seconds
            return false; //returns false
        }

        if (!word.matches("[A-Za-z]")) { //checks if user's guess is not between A-Za-z
            System.out.println("Please enter only letters"); //informs user to enter only letters
            Thread.sleep(1500); //suspends exeuction for 1.5 seconds
            return false; //returns false
        }
        return true; //returns true
    }

    public static boolean isAvailable(char letter) { //method for checking user's input
     
        if (usedLetters.contains(letter)) { //checks if the letter has already been guessed
            return false; //returns false

        } else { //otherwise we'll add the the letter if it's not already in the arraylist
            usedLetters.add(letter); //add user's guess to an arraylist
            return true; //returns true

        }

    }


    public static void printPostGameState(String randomWord) { //method that tells the user their post game state and takes a parameter of the random word 

        if (convertRandomWordtoString.equals(randomWord)) { //evalutes if both values are identical
            System.out.println("YOU WIN!"); //informs user they have won
            System.out.println("Used letters: " + usedLetters + ""); //informs the user of the letters they have guessed
            System.out.println("You guessed it in " + guesses + " tries."); //prints # of guesses used
        } else { //otherwise, if both values are not identical
            System.out.println("Better luck next time"); //informs the user they have lost
            System.out.println("Used letters: " + usedLetters + ""); //informs the user of the letters they have guesseed
            System.out.println("The word was: " + randomWord); //prints the word
            System.out.println("You used " + guesses + " tries."); //prints # of guesses used
        }
    }

   
    public static void easy() throws InterruptedException { //method for easy game mode

        String randomWord = wordList(); //assign the returned value from the wordbank
        int maxGuesses = 11; //# of guesses
        boolean isGuessCorrect = false;  //default this to false
        char[] letters = new char[randomWord.length()]; //loops through the random word and replaces the letters with . and stores it into an array
        for (int i = 0; i < letters.length; i++) { //checks each character
            letters[i] = '.'; //replaces each character with a .
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //new lines are printed
        System.out.println("Quit: 1"); //to quit anytime during the game
        System.out.println("Difficulty Easy: "); //prints the difficulty of the game mode

        do { //executes the following lines of code at least once, regardless of any conditions
            hangmanGraphics(maxGuesses);  //prints graphics
            System.out.print("Remaining lives: " + maxGuesses); //prints the remaining guesses/lives
            System.out.print("  "); //prints nothing
            System.out.print("Letters used: " + usedLetters); //prints the user's unavailable options
            System.out.println(""); //prints nothing

            //loops through the random word and prints out the . in place of letters
            for (int i = 0; i < letters.length; i++) { //loops through each character of the unknown word
                System.out.print(letters[i]); //prints out the . in place of letters
                isGuessed = false; //isGuessed is set to false
            }

            
            convertRandomWordtoString = String.valueOf(letters); //converts the char array into a string

            
            if (maxGuesses == 0 || convertRandomWordtoString.equals(randomWord)) {//checks whether they lost or won and prints their stats
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed
                printPostGameState(randomWord); //prints their stats
                usedLetters.clear(); //resets for a new game
                convertRandomWordtoString = ""; //convert the random word into a string
                guesses = 0; //guesses is reset
                break; //breaks out of the for loop
            }

            System.out.print("\nEnter your letter: "); //prompts for guess from user
            userGuess = sc.nextLine().toUpperCase(); //stores user input; converts each input into upper case
            letter = userGuess.charAt(0); //converts user's guess into a char

            if (userGuess.equals("1")) { //evaluates whether userGuess is equal to one
                System.out.println("Exiting..."); //prints Exiting...
                System.exit(0); //termintes the running Java virutal machine
            }

            if (isLetter(userGuess) == true) { //check if the guess is only a single character
                if (isAvailable(letter) == true) { //check if the guess has not been guessed already
                    for (int i = 0; i < randomWord.length(); i++) { //loops through the unknown word
                        char l = randomWord.charAt(i); //loops through each character of the random work
                        if (l == letter) { //checks if the user guess has guessed the one of the letters of the random word
                            letters[i] = l; //reveals the letter of the unknown word
                            isGuessCorrect = true; //isGuessCorrect is set equal to true
                        }

                    }
                  
                    if (!isGuessCorrect) { //if the user doesn't get the letter right we'll deduct 1 from # of guesses and keep track of how many they've used by +1 on the guesses variable
                        maxGuesses--; //decreases one from maxGuesses
                    }
                    
                    isGuessCorrect = false; //resets the variable for the next guess

                } else {
                    System.out.println("You've already guess this letter"); //informs the user that their input has already been guessed
                    Thread.sleep(1500); //suspends execution for 1.5 seconds

                }

            } else { //otherwise if the condition was false
                //nothing is executed
            }

            guesses++; //number of guesses increases

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed

        } while (maxGuesses >= 0 || isGuessed == true); //will break out of the loop if the user's used all of their guesses or if they've won

        System.out.print("\nEnter any key to return to menu: ");  //return to main menu
        String returnToMenu = sc.nextLine(); //stores user input
    }

    
    public static void medium() throws InterruptedException { //method for medium game mode

        String randomWord = wordList(); //assign the returned value from the wordbank
        int maxGuesses = 9; //# of guesses
        boolean isGuessCorrect = false;  //default this to false
        char[] letters = new char[randomWord.length()]; //loops through the random word and replaces the letters with . and stores it into an array
        for (int i = 0; i < letters.length; i++) { //checks each character
            letters[i] = '.'; //replaces each character with a .
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //new lines are printed
        System.out.println("Quit: 1"); //to quit anytime during the game
        System.out.println("Difficulty Easy: "); //prints the difficulty of the game mode

        do { //executes the following lines of code at least once, regardless of any conditions
            hangmanGraphics(maxGuesses);  //prints graphics
            System.out.print("Remaining lives: " + maxGuesses); //prints the remaining guesses/lives
            System.out.print("  "); //prints nothing
            System.out.print("Letters used: " + usedLetters); //prints the user's unavailable options
            System.out.println(""); //prints nothing

            //loops through the random word and prints out the . in place of letters
            for (int i = 0; i < letters.length; i++) { //loops through each character of the unknown word
                System.out.print(letters[i]); //prints out the . in place of letters
                isGuessed = false; //isGuessed is set to false
            }

            
            convertRandomWordtoString = String.valueOf(letters); //converts the char array into a string

            
            if (maxGuesses == 0 || convertRandomWordtoString.equals(randomWord)) {//checks whether they lost or won and prints their stats
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed
                printPostGameState(randomWord); //prints their stats
                usedLetters.clear(); //resets for a new game
                convertRandomWordtoString = ""; //convert the random word into a string
                guesses = 0; //guesses is reset
                break; //breaks out of the for loop
            }

            System.out.print("\nEnter your letter: "); //prompts for guess from user
            userGuess = sc.nextLine().toUpperCase(); //stores user input; converts each input into upper case
            letter = userGuess.charAt(0); //converts user's guess into a char

            if (userGuess.equals("1")) { //evaluates whether userGuess is equal to one
                System.out.println("Exiting..."); //prints Exiting...
                System.exit(0); //termintes the running Java virutal machine
            }

            if (isLetter(userGuess) == true) { //check if the guess is only a single character
                if (isAvailable(letter) == true) { //check if the guess has not been guessed already
                    for (int i = 0; i < randomWord.length(); i++) { //loops through the unknown word
                        char l = randomWord.charAt(i); //loops through each character of the random work
                        if (l == letter) { //checks if the user guess has guessed the one of the letters of the random word
                            letters[i] = l; //reveals the letter of the unknown word
                            isGuessCorrect = true; //isGuessCorrect is set equal to true
                        }

                    }
                  
                    if (!isGuessCorrect) { //if the user doesn't get the letter right we'll deduct 1 from # of guesses and keep track of how many they've used by +1 on the guesses variable
                        maxGuesses--; //decreases one from maxGuesses
                    }
                    
                    isGuessCorrect = false; //resets the variable for the next guess

                } else {
                    System.out.println("You've already guess this letter"); //informs the user that their input has already been guessed
                    Thread.sleep(1500); //suspends execution for 1.5 seconds

                }

            } else { //otherwise if the condition was false
                //nothing is executed
            }

            guesses++; //number of guesses increases

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed

        } while (maxGuesses >= 0 || isGuessed == true); //will break out of the loop if the user's used all of their guesses or if they've won
       
        System.out.print("\nEnter any key to return to menu: ");  //return to main menu
        String returnToMenu = sc.nextLine(); //stores user input
    }

    //hard game mode
    public static void hard() throws InterruptedException {

        String randomWord = wordList(); //assign the returned value from the wordbank
        int maxGuesses = 7; //# of guesses
        boolean isGuessCorrect = false;  //default this to false
        char[] letters = new char[randomWord.length()]; //loops through the random word and replaces the letters with . and stores it into an array
        for (int i = 0; i < letters.length; i++) { //checks each character
            letters[i] = '.'; //replaces each character with a .
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //new lines are printed
        System.out.println("Quit: 1"); //to quit anytime during the game
        System.out.println("Difficulty Easy: "); //prints the difficulty of the game mode

        do { //executes the following lines of code at least once, regardless of any conditions
            hangmanGraphics(maxGuesses);  //prints graphics
            System.out.print("Remaining lives: " + maxGuesses); //prints the remaining guesses/lives
            System.out.print("  "); //prints nothing
            System.out.print("Letters used: " + usedLetters); //prints the user's unavailable options
            System.out.println(""); //prints nothing

            //loops through the random word and prints out the . in place of letters
            for (int i = 0; i < letters.length; i++) { //loops through each character of the unknown word
                System.out.print(letters[i]); //prints out the . in place of letters
                isGuessed = false; //isGuessed is set to false
            }

            
            convertRandomWordtoString = String.valueOf(letters); //converts the char array into a string

            
            if (maxGuesses == 0 || convertRandomWordtoString.equals(randomWord)) {//checks whether they lost or won and prints their stats
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed
                printPostGameState(randomWord); //prints their stats
                usedLetters.clear(); //resets for a new game
                convertRandomWordtoString = ""; //convert the random word into a string
                guesses = 0; //guesses is reset
                break; //breaks out of the for loop
            }

            System.out.print("\nEnter your letter: "); //prompts for guess from user
            userGuess = sc.nextLine().toUpperCase(); //stores user input; converts each input into upper case
            letter = userGuess.charAt(0); //converts user's guess into a char

            if (userGuess.equals("1")) { //evaluates whether userGuess is equal to one
                System.out.println("Exiting..."); //prints Exiting...
                System.exit(0); //termintes the running Java virutal machine
            }

            if (isLetter(userGuess) == true) { //check if the guess is only a single character
                if (isAvailable(letter) == true) { //check if the guess has not been guessed already
                    for (int i = 0; i < randomWord.length(); i++) { //loops through the unknown word
                        char l = randomWord.charAt(i); //loops through each character of the random work
                        if (l == letter) { //checks if the user guess has guessed the one of the letters of the random word
                            letters[i] = l; //reveals the letter of the unknown word
                            isGuessCorrect = true; //isGuessCorrect is set equal to true
                        }

                    }
                  
                    if (!isGuessCorrect) { //if the user doesn't get the letter right we'll deduct 1 from # of guesses and keep track of how many they've used by +1 on the guesses variable
                        maxGuesses--; //decreases one from maxGuesses
                    }
                    
                    isGuessCorrect = false; //resets the variable for the next guess

                } else {
                    System.out.println("You've already guess this letter"); //informs the user that their input has already been guessed
                    Thread.sleep(1500); //suspends execution for 1.5 seconds

                }

            } else { //otherwise if the condition was false
                //nothing is executed
            }

            guesses++; //number of guesses increases

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed

        } while (maxGuesses >= 0 || isGuessed == true); //will break out of the loop if the user's used all of their guesses or if they've won

        System.out.print("\nEnter any key to return to menu: ");  //return to main menu
        String returnToMenu = sc.nextLine(); //stores user input
    }

    //unlimited game mode
    public static void unlimited() throws InterruptedException { //method for unlimited game mode
        String randomWord = wordList(); //assign the returned value from the wordbank
        boolean isGuessCorrect = false; //default this to false
        char[] letters = new char[randomWord.length()]; //loops through the random word and replaces the letters with . and stores it into an array
        for (int i = 0; i < letters.length; i++) { //checks each character
            letters[i] = '.'; //replaces each character with a .
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //new lines are printed
        System.out.println("Quit: 1"); //to quit anytime during the game
        System.out.println("Difficulty Unlimited: "); //prints the difficulty of the game mode

        do { //executes the following lines of code at least once, regardless of any conditions
            System.out.print("Letters used: " + usedLetters); //prints the user's unavailable options
            System.out.println(""); //prints nothing
            for (int i = 0; i < letters.length; i++) { //loops through each character of the unknown word
                System.out.print(letters[i]); //prints out the . in place of letters
                isGuessed = false; //isGuessed is set to false
            }

            convertRandomWordtoString = String.valueOf(letters); //converts the char array into a string

            if (convertRandomWordtoString.equals(randomWord)) { //checks whether they lost or won and prints their stats
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed
                printPostGameState(randomWord); //prints their stats
                usedLetters.clear(); //resets for a new game
                convertRandomWordtoString = ""; //convert the random word into a string
                guesses = 0; //guesses is reset
                break; //breaks out of the for loop
            }
            System.out.print("\nEnter your letter: "); //prompts for guess from user
            userGuess = sc.nextLine().toUpperCase(); //stores user input; converts each input into upper case
            letter = userGuess.charAt(0); //converts user's guess into a char

            if (userGuess.equals("1")) { //evaluates whether userGuess is equal to one
                System.out.println("Exiting..."); //prints Exiting...
                System.exit(0); //termintes the running Java virutal machine
            }

            if (isLetter(userGuess) == true) { //check if the guess is only a single character
                if (isAvailable(letter) == true) { //check if the guess has not been guessed already
                    for (int i = 0; i < randomWord.length(); i++) { //loops the length of the word
                        char l = randomWord.charAt(i); //loops through each character of the random work
                        if (l == letter) { //checks if the user guess has guessed the one of the letters of the random word
                            letters[i] = l; //reveals the letter of the unknown word
                            isGuessCorrect = true; //isGuessCorrect is set equal to true
                        }

                    }

                    isGuessCorrect = false; //resets the variable for the next guess

                } else {
                    System.out.println("You've already guess this letter"); //informs the user that their input has already been guessed
                    Thread.sleep(1500); //suspends execution for 1.5 seconds

                }

            } else { //otherwise if the condition was false
                //nothing is executed

            }

            guesses++; //number of guesses increases

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //news lines are printed

        } while (true); //will break out of the loop if the user's used all of their guesses or if they've won
       
        System.out.print("\nEnter any key to return to menu: "); //return to main menu
        String returnToMenu = sc.nextLine(); //stores user input
    }

    
    public static void hangmanGraphics(int value) { //method for graphics of the hangman
        if (value == 0) { //if value is equal to 0, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("  /|\\ |"); //displays hangman
            System.out.println("  / \\ |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 1) { //if value is equal to 1, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("  /|\\ |"); //displays hangman
            System.out.println("  /    |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 2) { //if value is equal to 2, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("  /|\\ |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 3) { //if value is equal to 3, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("  /|   |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 4) { //if value is equal to 4, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 5) { //if value is equal to 5, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("   O   |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 6) { //if value is equal to 6, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("   |   |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 7) { //if value is equal to 7, prints out the hangman
            System.out.println("   _____"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 8) { //if value is equal to 8, prints out the hangman
            System.out.println("        "); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 9) { //if value is equal to 9, prints out the hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("       |"); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 10) { //if value is equal to 10, prints out the hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman 
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("_______|"); //displays hangman
        } else if (value == 11) { //if value is equal to 11, prints out the hangman
            System.out.println("        "); //displays hangman 
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("_______ "); //displays hangman
        } else { //if the other conditions were false
            System.out.println("        "); //displays hangman 
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
            System.out.println("        "); //displays hangman
        }
    }

}
