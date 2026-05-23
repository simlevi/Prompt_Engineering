
/**
 * Nyelv: JAVA
 * Kommentelési stílus: JSDoc / TSDoc 
 */

import java.util.Scanner;

/**
 * Szövegek feldolgozásáért és tömörítéséért felelős osztály.
 * Run-Length Encoding (RLE) algoritmust használ az ismétlődő karakterek tömörítésére.
 */
public class DataProcessor_Commented {
    
    /**
     * Feldolgozza és tömöríti a bemeneti szöveget.
     * Megszámolja az egymás után ismétlődő karaktereket, és a karaktert a darabszámmal helyettesíti (pl. "AAAB" -> "A3B1").
     * 
     * @param input A feldolgozandó eredeti szöveg.
     * @return A tömörített szöveg. Ha a bemenet null vagy üres, egy üres karakterlánccal tér vissza.
     */
    public static String processString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        result.append(input.charAt(input.length() - 1)).append(count);
        
        return result.toString();
    }

    /**
     * Kiszámítja a tömörítés arányát a feldolgozott és az eredeti szöveg hossza alapján.
     * 
     * @param original Az eredeti, tömörítetlen szöveg.
     * @param processed A feldolgozott, tömörített szöveg.
     * @return A tömörítési arány (feldolgozott hossza osztva az eredeti hosszával). Ha az eredeti szöveg érvénytelen, 0.0-t ad vissza.
     */
    public static double calculateRatio(String original, String processed) {
        if (original == null || original.isEmpty()) {
            return 0.0;
        }
        return (double) processed.length() / original.length();
    }

    /**
     * A program belépési pontja.
     * Bekéri a felhasználótól a szöveget a konzolon keresztül, majd kiírja a tömörítés eredményét és arányát.
     * 
     * @param args Parancssori argumentumok (jelenleg nincs használatban).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérlek, add meg a tömörítendő szöveget: ");
        String testData = scanner.nextLine();

        String processedData = processString(testData);
        double ratio = calculateRatio(testData, processedData);

        System.out.println("\n--- Eredmények ---");
        System.out.println("Eredeti adat: " + testData);
        System.out.println("Feldolgozott adat: " + processedData);
        System.out.println("Tömörítési arány: " + ratio);

        scanner.close();
    }
}