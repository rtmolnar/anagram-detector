package anagram.detector;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramDetectorTest {
	@Test
	public void isAnagramByStringsShouldReturnTrueForAnagramString() {
		AnagramDetector a = new AnagramDetector();
		String text1 = "abc";
		String text2 = "abc";
		boolean expected = true;
		boolean actual = a.isAnagramByStrings(text1, text2);

		assertEquals(expected, actual);
	}

	@Test
	public void isAnagramByTextFilesShouldReturnTrueIfFileContentIsAnagram() {
		AnagramDetector a = new AnagramDetector();
		String path1 = "testFileAnagram1.txt";
		String path2 = "testFileAnagram2.txt";

		assertTrue(a.isAnagramByTextFiles(path1, path2));
	}

	@Test
	public void isAnagramByTextFilesShouldReturnFalseIfFileContentIsNotAnagram() {
		AnagramDetector a = new AnagramDetector();
		String path1 = "testFileNotAnagram1.txt";
		String path2 = "testFileNotAnagram2.txt";

		assertFalse(a.isAnagramByTextFiles(path1, path2));
	}

	@Test
	public void isAnagramByTextFilesShouldReturnFalseIfFileIsNotFound() {
		AnagramDetector a = new AnagramDetector();
		String path1 = "notFound1.txt";
		String path2 = "testFileNotAnagram2.txt";

		assertFalse(a.isAnagramByTextFiles(path1, path2));
	}
}
