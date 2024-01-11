public class Zad5_i_6 {

    public static String encryptVigenere(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int textLength = text.length();
        int keyLength = key.length();

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);

            if (Character.isLowerCase(currentChar)) {
                char keyChar = key.charAt(i % keyLength);
                int shift = keyChar - 'a';
                int originalPosition = currentChar - 'a';
                int newPosition = (originalPosition + shift) % 26;
                char newChar = (char) ('a' + newPosition);
                encryptedText.append(newChar);
            } else {
                // Jeśli znak nie jest małą literą, pozostaw bez zmian
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    public static String decryptVigenere(String text, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int textLength = text.length();
        int keyLength = key.length();

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);

            if (Character.isLowerCase(currentChar)) {
                char keyChar = key.charAt(i % keyLength);
                int shift = keyChar - 'a';
                int originalPosition = currentChar - 'a';
                // Odwrócenie przesunięcia przy deszyfrowaniu
                int newPosition = (originalPosition - shift + 26) % 26;
                char newChar = (char) ('a' + newPosition);
                decryptedText.append(newChar);
            } else {
                // Jeśli znak nie jest małą literą, pozostaw bez zmian
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        // Przykładowy tekst do zaszyfrowania
        String plainText = "tojesttekstdoszyfrowania";

        // Przykładowy klucz szyfrujący
        String key = "klucz";

        // Szyfrowanie tekstu z użyciem klucza
        String encryptedText = encryptVigenere(plainText, key);

        // Deszyfrowanie zaszyfrowanego tekstu
        String decryptedText = decryptVigenere(encryptedText, key);

        // Wyświetlenie wyników
        System.out.println("Oryginalny tekst: " + plainText);
        System.out.println("Klucz szyfrujący: " + key);
        System.out.println("Zaszyfrowany tekst: " + encryptedText);
        System.out.println("Odszyfrowany tekst: " + decryptedText);
    }
}