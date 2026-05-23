import java.util.Scanner;

public class DataProcessor {
    
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

    public static double calculateRatio(String original, String processed) {
        if (original == null || original.isEmpty()) {
            return 0.0;
        }
        return (double) processed.length() / original.length();
    }

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