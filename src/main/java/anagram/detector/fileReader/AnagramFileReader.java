package anagram.detector.fileReader;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class AnagramFileReader {

  private static final List<String> ACCEPTED_MIME_TYPES = Collections.singletonList("text/plain");

  /**
   * Asserts if the file pointed by the filePath is the right type and try to get
   * it's content in a String
   *
   * @param filePath filePath to the file
   * @return String content of the file
   * @throws IOException Throws in case the file doesn't exist or if the mimeType is not accepted
   * @throws InvalidPathException Throws in case the filePath doesn't contain a file
   */
  public String readFileFromClassLoader(String filePath) throws IOException, InvalidPathException {

   validateFilePath(filePath);

    return IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filePath)), StandardCharsets.UTF_8);
  }

  public String readFileFromPath(String filePath) throws IOException {

    validateFilePath(filePath);

    StringBuilder builder = new StringBuilder();
    try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {

      String str;
      while ((str = buffer.readLine()) != null) {
        builder.append(str);
      }
    }

    catch (IOException e) {
      throw new IOException("Couldn't read file", e);
    }

    return builder.toString();
  }

  private void validateFilePath(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    if(!Files.exists(path, LinkOption.NOFOLLOW_LINKS) && getClass().getClassLoader().getResource(filePath) == null){
      throw new FileNotFoundException("File is not present at the filePath " + filePath);
    }

    String mimeType = Files.probeContentType(path);
    if(!ACCEPTED_MIME_TYPES.contains(mimeType)){
      throw new IOException("File format not accepted");
    }
  }
}
