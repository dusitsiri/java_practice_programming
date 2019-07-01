/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countalvowels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 *
 * @author onege
 */
public class CountVowels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //อ่านไฟล์
        LinkedHashMap<Character, Integer> vowels = new LinkedHashMap<Character, Integer>();
        vowels.put('A', 0);
        vowels.put('E', 0);
        vowels.put('I', 0);
        vowels.put('O', 0);
        vowels.put('U', 0);

        String filename = "message.txt";
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(fileReader);

            System.out.println("Open file:");
            String line = buffer.readLine();

            while (line != null) {
                for (String each : line.split(" ")) {
                    for (char ch : each.toCharArray()) {
                        switch (ch) {
                            case 'a':
                            case 'A':
                                vowels.put('A', vowels.get('A') + 1);
                                break;
                            case 'e':
                            case 'E':
                                vowels.put('E', vowels.get('E') + 1);
                                break;
                            case 'i':
                            case 'I':
                                vowels.put('I', vowels.get('I') + 1);
                                break;
                            case 'o':
                            case 'O':
                                vowels.put('O', vowels.get('O') + 1);
                                break;
                            case 'u':
                            case 'U':
                                vowels.put('U', vowels.get('U') + 1);
                                break;
                        }
                    }
                }
                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read file: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file");
        }
        
        System.out.println(vowels);
    }
}
