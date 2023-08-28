package anagram.detector;

import anagram.detector.algorithms.AnagramDetectorAlgorithmSort;
import anagram.detector.fileReader.FileReader;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AnagramDetector {

  private static final Logger log = LogManager.getLogger(AnagramDetector.class);
  private static FileReader fileReader;
  AnagramDetectorAlgorithmSort anagramDetectorAlgorithm = new AnagramDetectorAlgorithmSort();

  /**
   * Compare two Strings using the <a href="#{@link}">{@link AnagramDetectorAlgorithmSort}</a> and
   * return the boolean representation if they are anagrams or not
   *
   * @param text1 first string for comparison
   * @param text2 second string for comparison
   * @return boolean value representing if text1 and text2 are anagrams
   */
  public boolean isAnagramByStrings(String text1, String text2){

    log.trace("Starting anagram algorithm by two strings");

    StopWatch watch = new StopWatch();
    watch.start();


    boolean isAnagram = anagramDetectorAlgorithm.isAnagram(text1, text2);

    watch.stop();
    log.info("The process was done using: " + anagramDetectorAlgorithm.getClass().getSimpleName());
    log.info("Time in milliseconds to finish the process: " + watch.getTime(TimeUnit.MILLISECONDS));
    return isAnagram;
  }

  /**
   * Tries to read the file in the paths sent as parameters. If files exists and if it is
   * a text file then it is transformed into a String and passed as parameter to
   * <a href="#{@link}">{@link AnagramDetectorAlgorithmSort}</a> in order to determine if it is
   * an anagram or not
   *
   * @param path1 path for the first text file
   * @param path2 path for the second text file
   * @return boolean value representing if the text on the files are anagrams or not
   */
  public boolean isAnagramByTextFiles(String path1, String path2){

    log.trace("Starting anagram algorithm by two strings");
    StopWatch watch = new StopWatch();
    watch.start();

    if(fileReader == null){
      fileReader = new FileReader();
    }

    try {
      String text1 = fileReader.readFile(path1);
      String text2 = fileReader.readFile(path2);

      boolean isAnagram = anagramDetectorAlgorithm.isAnagram(text1, text2);

      watch.stop();
      log.info("The process was done using: " + anagramDetectorAlgorithm.getClass().getSimpleName());
      log.info("Time in milliseconds to finish the process: " + watch.getTime(TimeUnit.MILLISECONDS));

      return isAnagram;

    } catch (Exception e) {
      log.error("It was not possible to find the file", e);
      return false;
    }
  }
}
