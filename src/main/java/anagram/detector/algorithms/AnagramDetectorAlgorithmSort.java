package anagram.detector.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class AnagramDetectorAlgorithmSort {

  private final Logger log = LogManager.getLogger(AnagramDetectorAlgorithmSort.class);

  /**
   * Returns a boolean value that represents if the String text1 and String text2 are anagrams.
   * <p>
   *This method filters the non letter characters from the Strings and sorts it in order to
   * compare them. If they are equals then they are an anagram.
   *
   * @param text1 first string for comparison
   * @param text2 second string for comparison
   * @return boolean value representing if text1 and text2 are anagrams
   */
  public boolean isAnagram(String text1, String text2) {

    log.trace("Starting anagram detector sort algorithm");

    boolean isAnagram = false;

    log.trace("Eliminating non letters on text1");
    String filteredText1 = text1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    log.trace("Eliminating non letters on text2");
    String filteredText2 = text2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    if (filteredText1.length() != filteredText2.length()) {
      log.info("Texts are not an anagram due to the difference on the number of letters");
      return isAnagram;
    }

    log.trace("Sorting text1");
    filteredText1 = sortString(filteredText1);

    log.trace("Sorting text2");
    filteredText2 = sortString(filteredText2);

    if (filteredText1.equals(filteredText2)) {
      log.trace("Texts are the same after eliminating non letters and sorting the letters therefore they are an anagram");
      isAnagram = true;
    }

    return isAnagram;
  }

  private String sortString(String inputString) {
    char[] charArray = inputString.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }
}
