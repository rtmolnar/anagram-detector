import anagram.detector.AnagramDetector;

import java.util.Scanner;

public class AnagramDetectorMain {

  public static void main(String[] args) throws Exception {

    System.out.println("Welcome to he anagram detector");
    executeCli();
  }

  private static void executeCli(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please select one of the following options");
    System.out.println("1 - Comparison by String input in the console");
    System.out.println("2 - Comparison by text files present in the resources of the project");

    int option = scanner.nextInt();


    switch (option){
      case 1:
        comparisonByInputStrings(scanner);
        break;
      case 2:
        comparisonByResourceTextFiles(scanner);
        break;
      default:
        System.out.println("Option not recognized, try again please");
        executeCli();
    }
  }

  private static void comparisonByResourceTextFiles(Scanner scanner) {

    System.out.println("####################################################################################");
    System.out.println("The texts present in the resource folder of the project will be analysed");

    AnagramDetector anagramDetector = new AnagramDetector();
    printResult(anagramDetector.isAnagramByTextFiles("text1.txt", "text2.txt"));
  }

  private static void comparisonByInputStrings(Scanner scanner){
    System.out.println("####################################################################################");
    System.out.println("Please input Text 1");
    String text1 = scanner.next();
    System.out.println("Please input Text 2");
    String text2 = scanner.next();

    AnagramDetector anagramDetector = new AnagramDetector();
    printResult(anagramDetector.isAnagramByStrings(text1, text2));
  }

  private static void printResult(boolean isAnagram){
    if(isAnagram){
      System.out.println("###### IS ANAGRAM ######");
    }else {
      System.out.println("###### IS NOT ANAGRAM ######");
    }
  }
}
