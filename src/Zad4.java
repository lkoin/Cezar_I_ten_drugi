import java.io.*;

public class Zad4 {

    public static String encryptWithKey(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        int textLength = text.length();

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);

            if (Character.isLowerCase(currentChar)) {
                int originalPosition = currentChar - 'a';
                int newPosition = (originalPosition + key) % 26;
                char newChar = (char) ('a' + newPosition);
                encryptedText.append(newChar);
            } else {
                // Jeśli znak nie jest małą literą, pozostaw bez zmian
                encryptedText.append(currentChar);
            }

            // Zastosowanie klucza cyklicznie
            key = (key + 1) % 10;
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        try {
            // Odczyt tekstu z pliku "szyfr.txt"
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\IdeaProjects\\Cezar_I_ten_drugi\\src\\szyfr.txt"));
            StringBuilder inputText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                inputText.append(line).append("\n");
            }

            reader.close();

            // Przykładowy klucz: 2019
            int key = 2019;

            // Szyfrowanie tekstu z użyciem klucza
            String encryptedText = encryptWithKey(inputText.toString(), key);

            // Zapis zaszyfrowanego tekstu do pliku "zaszyfrowany.txt"
            BufferedWriter writer = new BufferedWriter(new FileWriter("zaszyfrowany.txt"));
            writer.write(encryptedText);
            writer.close();

            System.out.println("Zaszyfrowany tekst został zapisany do pliku \"zaszyfrowany.txt\".");
        } catch (IOException e) {
            System.err.println("Błąd podczas obsługi plików: " + e.getMessage());
        }
    }
}