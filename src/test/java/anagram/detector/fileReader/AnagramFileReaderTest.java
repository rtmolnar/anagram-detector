package anagram.detector.fileReader;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class AnagramFileReaderTest {

	@Test
	public void readFileShouldReturnStringContentOfFile() throws IOException, InvalidPathException {
		AnagramFileReader f = new AnagramFileReader();
		String path1 = "testFileAnagram1.txt";

		String fileContent = f.readFileFromClassLoader(path1);
		assertEquals("abc", fileContent);
	}

	@Test
	public void readFileShouldThrowExceptionForExtensionNotAccepted() throws IOException, InvalidPathException {
		AnagramFileReader f = new AnagramFileReader();
		String path1 = "testFileNotValidExtension.png";

		assertThrows(IOException.class, () -> f.readFileFromClassLoader(path1));
	}

	@Test
	public void readFileShouldThrowExceptionIfFileIsNotFound() throws IOException, InvalidPathException {
		AnagramFileReader f = new AnagramFileReader();
		String path1 = "notFound";

		assertThrows(FileNotFoundException.class, () -> f.readFileFromClassLoader(path1));
	}

	@Test
	public void readFileShouldReturnStringContentOfFileForGivenPath() throws IOException, InvalidPathException {
		AnagramFileReader f = new AnagramFileReader();

		Path temp = Files.createTempFile("test", ".txt");
		PrintWriter out = new PrintWriter(temp.toString());
		out.println("test");
		out.close();

		String fileContent = f.readFileFromPath(temp.toString());
		assertEquals("test", fileContent);
	}

}
