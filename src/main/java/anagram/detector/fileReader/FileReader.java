package anagram.detector.fileReader;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class FileReader {

  private static final List<String> ACCEPTED_MIME_TYPES = Collections.singletonList("text/plain");

  /**
   * Asserts if the file pointed by the path is the right type and try to get
   * it's content in a String
   *
   * @param path path to the file
   * @return String content of the file
   * @throws IOException Throws in case the file doesn't exist or if the mimeType is not accepted
   * @throws InvalidPathException Throws in case the path doesn't contain a file
   */
  public String readFile(String path) throws IOException, InvalidPathException {

    Path filePath = Paths.get(path);
    if(!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)){
      throw new FileNotFoundException("File is not present at the path " + path);
    }

    String mimeType = Files.probeContentType(filePath);

    if(!ACCEPTED_MIME_TYPES.contains(mimeType)){
      throw new IOException("File format not accepted");
    }

    return IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)), StandardCharsets.UTF_8);
  }
}
