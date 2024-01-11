public class Zad1_i_2 {
    public static void main(String[] args) {
        String originalText = "KRYPTOLOGIA";
        int shift = 25;

        String encryptedText = ceasarCipherEncrypt(originalText, shift);
        String crackedText = ceasarCipherDecrypt(encryptedText,25);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Cracked Text: " + crackedText);
    }

    //Ten sposob dziala i na zadanie 1 i zadanie 2 bo jest giga skomplikowany pzdr
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