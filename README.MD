# Anagram Detector

The goal of this project is to determine if two texts are an anagram of each other.

## Description

This project uses an algorithm based on the sorting of the two offered strings and then compare both in order to see if they are the same.

These texts can be hardcoded in Strings variables or added in the format of texts in the resources folder of the project in the name of tex1 and text2

Once the app is executed it prints and expects a few inputs  according to instructions from the user in the terminal. 
The user input determine how the text1 and text2 will be feed to the logic.

## How to use

There are several ways to use this app, they are explained in the next sub sessions of this document.

The messages the user will se the terminal are the following ones:
```
Welcome to he anagram detector
Please select one of the following options
1 - Comparison by String input in the console
2 - Comparison by text files present in the resources of the project
1
####################################################################################
Please input Text 1
Elvis
Please input Text 2
Lives
2023-08-28 17:53:58 INFO The process was done using: AnagramDetectorAlgorithmSort
2023-08-28 17:53:58 INFO Time in milliseconds to finish the process: 20828
2023-08-28 17:53:58 INFO ###### IS ANAGRAM ######
```

In the case above the user chose option one so the next messages asked for the Strings to compare.

In case the user choose the option 2 then the code will try to read both of the text files present in the resources folder:
```
Welcome to he anagram detector
Please select one of the following options
1 - Comparison by String input in the console
2 - Comparison by text files present in the resources of the project
2
####################################################################################
The texts present in the resource folder of the project will be analysed
2023-08-28 18:00:41 INFO The process was done using: AnagramDetectorAlgorithmSort
2023-08-28 18:00:41 INFO Time in milliseconds to finish the process: 81
2023-08-28 18:00:41 INFO ###### IS ANAGRAM ######
```
Another path is possible when the user selects an option that is not available which will restart the interaction:
```
Welcome to he anagram detector
Please select one of the following options
1 - Comparison by String input in the console
2 - Comparison by text files present in the resources of the project
3
Option not recognized, try again please
Please select one of the following options
1 - Comparison by String input in the console
2 - Comparison by text files present in the resources of the project
```

#### Execute the main class from an IDE
Once the user run the main class it will start printing the messages on the terminal and user can follow the instructions as commented in the first part of section of this document.

#### Execute the jar-with-dependencies once the application is built
If build the application will generate a jar called ```anagram-detector-1.0-jar-with-dependencies.jar``` in the target folder, executing this jar will trigger the dialog seem in the first part of this section.

In order to run it on a terminal the user can execute the following command from within the project folder:
``` java -jar target/anagram-detector-1.0-jar-with-dependencies.jar  ```


#### Use it as a library 
The last and maybe the most useful way to use this app is adding it to another project as a dependency where it can be used
in several ways as such calling the auxiliary methods of the class ``` AnagramDetector``` or calling directly the ``` AnagramDetectgorAlgorithm```.

## Author

Contributors names and contact info

Raphael Thaumaturgo Molnar  
[rtmolnar](https://github.com/rtmolnar)

## License

This project is licensed under the GNU General Public License (GPL) - see the [LICENSE Description](https://www.gnu.org/licenses/gpl-3.0.en.html) file for details
