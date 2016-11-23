
import java.util.Random;

public class randompassword {

    public static void main(String s[]) {
        String numbers[] = new String[10];
        for (int i = 0; i <= 9; i++) {
            numbers[i] = String.valueOf(i);
        }
        String characters[] = new String[26];
        char charascii = 'a';
        for (int i = 0; i < 26; i++) {

            charascii++;
            characters[i] = String.valueOf(charascii);

        }
        //getting random numbers for digits
        int min_numbers = 0;
        int max_numbers = 9;
        Random r1 = new Random();
        int random1 = r1.nextInt((max_numbers - min_numbers) + 1) + min_numbers;
     
        //getting random numbers for characters
        int min_characters = 0;
        int max_characters = 26;
        Random r2 = new Random();
        int random2 = r2.nextInt((max_characters - min_characters) + 1) + min_characters;
        
       String numbers_random= numbers[random1];
      String character_random=characters[random2];
      
      String password=numbers_random+" "+character_random;
        System.out.println("password "+password);
        
        
        

    }
}
