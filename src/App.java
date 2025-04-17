import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
  //HANG-MAN


  String filePath = "src\\resources\\EasyLevel.txt";
  String filePath2 = "src\\resources\\MediumLevel.txt";
  String filePath3 = "src\\resources\\HardLevel.txt";

  ArrayList<String> wordList = new ArrayList<>();
  Random random = new Random();
  char letter;
  int choice;
  String playAgain;
  Scanner scanner = new Scanner(System.in);

  System.out.println();
  System.out.println("******** WELCOME TO HANG-MAN ********");
  do{
  System.out.println("Available level: ");
  System.out.println("1. Easy Level");
  System.out.println("2. Intermediate Level");
  System.out.println("3. Hard Level");

  try {
    System.out.print("\nEnter between (1-3): ");
    choice = scanner.nextInt();
    scanner.nextLine();
} catch (InputMismatchException e) {
    System.out.println("Invalid input. You should choose between (1-2-3).");
    scanner.close();
    return;
}

  switch (choice) {
    case 1:
    readFile(filePath, wordList);
    break;

        case 2:
        readFile(filePath2, wordList);
        break;

             case 3:
             readFile(filePath3, wordList);
             break;

    default:
    System.out.println("Invalid choice.");
        break;
  }


  
 
  
  
      String word = wordList.get(random.nextInt(wordList.size()));
      System.out.println();
      
      ArrayList<Character> wordState = new ArrayList<>();

      for(int i=0;i<word.length();i++){

        wordState.add(('_'));
      }
      
   

      int wrongChoice = 0;

      ArrayList<Character> usedLetter = new ArrayList<>();
 
      

        while (wrongChoice < 6 && wordState.contains('_')) {
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }

            System.out.print("\nGuess a letter: ");
            letter = scanner.next().toUpperCase().charAt(0);
        
            if(usedLetter.contains(letter)){
                    System.out.println("You already pick this letter");
                    continue;          
            }
            usedLetter.add(letter);
           
           

             if(word.indexOf(letter) >=0){
                System.out.println("Correct Guess!");

              
            
            
            for (int i = 0; i < wordState.size(); i++) {
                if (word.charAt(i) == letter) {
                    wordState.set(i, letter);
                    
                    
                }
                
        }

              }else{
                wrongChoice++;
                System.out.println("Wrong guess!");
                display(wrongChoice,word);
            }
        }
    

        if (!wordState.contains('_')) {
            System.out.println("You WIN! The word was: " + word);
        } else if(wrongChoice==6) {
            System.out.println("GAME OVER! The word was: " + word);
        }

      
        System.out.print("You wanna play again? (Si/No): ");
        playAgain = scanner.next().toLowerCase();

    }while(playAgain.equals("si"));
        
      

scanner.close();
   
}


    public static void display(int contWrong,String word){
        switch (contWrong) {
            case 1:
        System.out.println("  ___");
        System.out.println(" |   |");
        System.out.println(" |   O ");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println("_|_");
        break;

    case 2:
    System.out.println("  ___");
    System.out.println(" |   |");
    System.out.println(" |   O ");
    System.out.println(" |   |");
    System.out.println(" |");
    System.out.println("_|_");
        break;

    case 3:
    System.out.println("  ___");
    System.out.println(" |   |");
    System.out.println(" |   O ");
    System.out.println(" |   |");
    System.out.println(" |  /");
    System.out.println("_|_");
        break;

    case 4:
    System.out.println("  ___");
    System.out.println(" |   |");
    System.out.println(" |   O ");
    System.out.println(" |   |");
    System.out.println(" |  / \\");
    System.out.println("_|_");
        break;

    case 5:
    System.out.println("  ___");
    System.out.println(" |   |");
    System.out.println(" |   O ");
    System.out.println(" |  /|");
    System.out.println(" |  / \\");
    System.out.println("_|_");
        break;

    case 6:
    System.out.println("  ___");
    System.out.println(" |   |");
    System.out.println(" |   O ");
    System.out.println(" |  /|\\");
    System.out.println(" |  / \\");
    System.out.println("_|_");

        break;

            default:
                break;
        } 



    }


    public static void readFile(String filePath, ArrayList<String> list){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                
                list.add(line.trim().toUpperCase()); //aggiungo la parola ma tolgo eventuali spazi 
        
            }
        
        
          }
          
          catch(FileNotFoundException ex){
            System.out.println("Could not locate the file");
        
          }
          
          
          catch(IOException e){
            System.out.println("Error occured: " +e.getMessage());
        
          }
          
      
    
    



    }




}


