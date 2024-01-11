import java.io.*;

public class Zad3 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\IdeaProjects\\Cezar_I_ten_drugi\\src\\szyfr.txt"));
            StringBuilder input = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                input.append(line).append("\n");
            }
            reader.close();
            int key = 15;
            String encrypted = ceasarCipherEncrypt(input.toString(),key);
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.append(encrypted);
            writer.close();


            BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Administrator\\IdeaProjects\\Cezar_I_ten_drugi\\output.txt"));
            String line2;
            while ((line2 = reader2.readLine()) != null){
                input.append(line2).append("\n");
            }
            reader2.close();
            String decrypted = ceasarCipherDecrypt(input.toString(),key);
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("decrypeted.txt"));
            writer2.append(decrypted);
            writer2.close();


        }
        catch (IOException e) {
            System.err.println("Bład obsługi pliku " + e.getMessage());
        }
    }

    public static String ceasarCipherEncrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                int originalAlphabetPosition = currentChar - base; // Obliczenie pozycji obecnego znaku w alfabecie
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26; // Obliczenie nowej pozycji literki po zastosowaniu szyfru Cezara
                char newChar = (char) (base + newAlphabetPosition);   // Utworzenie zaszyfrowanego znaku na podstawie nowej pozycji w alfabecie i bazowej litery
                encryptedText.append(newChar);  // Dodanie zaszyfrowanego znaku do zaszyfrowanego tekstu
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }


    public static String ceasarCipherDecrypt(String text, int shift) {
        return ceasarCipherEncrypt(text, 26 - shift);
    }
}
