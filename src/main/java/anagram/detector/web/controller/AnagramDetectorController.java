package anagram.detector.web.controller;

import anagram.detector.AnagramDetector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnagramDetectorController {

  @GetMapping("/")
  public String anagramDetector() {
    return "anagram-detector";
  }

  @PostMapping("/anagram-detector")
  public String anagramDetector(
      @RequestParam(name="text1", required=false, defaultValue="Elvis") String text1,
      @RequestParam(name="text2", required=false, defaultValue="Lives") String text2,
      Model model) {

    AnagramDetector anagramDetector = new AnagramDetector();
    Boolean isAnagram = anagramDetector.isAnagramByStrings(text1, text2);

    model.addAttribute("isAnagram", isAnagram);
    model.addAttribute("text1", text1);
    model.addAttribute("text2", text2);

    return "anagram-detector";
  }

}
