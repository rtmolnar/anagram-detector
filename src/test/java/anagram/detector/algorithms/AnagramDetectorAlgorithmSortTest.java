package anagram.detector.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramDetectorAlgorithmSortTest {

	@Test
	public void isAnagramShouldReturnTrueForSameString() {
		AnagramDetectorAlgorithmSort a = new AnagramDetectorAlgorithmSort();
		String text1 = "abc";
		String text2 = "abc";

		assertTrue(a.isAnagram(text1, text2));
	}

	@Test
	public void isAnagramShouldReturnTrueForAnagramString() {
		AnagramDetectorAlgorithmSort a = new AnagramDetectorAlgorithmSort();
		String text1 = "abc";
		String text2 = "cab";

		assertTrue(a.isAnagram(text1, text2));
	}

	@Test
	public void isAnagramShouldReturnTrueForAnagramStringWthSpace() {
		AnagramDetectorAlgorithmSort a = new AnagramDetectorAlgorithmSort();
		String text1 = "abc";
		String text2 = "c ab";

		assertTrue(a.isAnagram(text1, text2));
	}

	@Test
	public void isAnagramShouldReturnTrueForAnagramStringWithDifferentCase() {
		AnagramDetectorAlgorithmSort a = new AnagramDetectorAlgorithmSort();
		String text1 = "ABC";
		String text2 = "cab";

		assertTrue(a.isAnagram(text1, text2));
	}

	@Test
	public void isAnagramShouldReturnFalseForDifferentSizeStrings() {
		AnagramDetectorAlgorithmSort a = new AnagramDetectorAlgorithmSort();
		String text1 = "abc";
		String text2 = "abcd";

		assertFalse(a.isAnagram(text1, text2));
	}
}
