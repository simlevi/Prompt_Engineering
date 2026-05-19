
/// <summary>
/// Nyelv: C#
/// Kommentelési stílus: XML Dokumentáció + Zászlók
/// </summary>

using System;
using System.Text;

/// <summary>
/// Szövegek feldolgozásáért és tömörítéséért felelős osztály.
/// </summary>
public class DataProcessor
{
    // FIXME: Jelenleg nincs bemeneti validáció a számokra vagy speciális karakterekre.

    /// <summary>
    /// Feldolgozza és tömöríti a bemeneti szöveget.
    /// </summary>
    /// <param name="input">A feldolgozandó eredeti szöveg.</param>
    /// <returns>A tömörített szöveg.</returns>
    public static string ProcessString(string input)
    {
        // 1. lépés: Üres bemenet kezelése.
        if (string.IsNullOrEmpty(input))
        {
            return "";
        }

        // TODO: A jövőben támogassuk a kis/nagybetűk figyelmen kívül hagyását.
        
        StringBuilder result = new StringBuilder();
        int count = 1;

        // 2. lépés: Végiglépkedünk a szövegen.
        for (int i = 1; i < input.Length; i++)
        {
            if (input[i] == input[i - 1])
            {
                // Egyezés esetén növeljük a számlálót.
                count++;
            }
            else
            {
                // HACK: A StringBuilder Append láncolásával fűzzük össze az eredményt.
                result.Append(input[i - 1]).Append(count);
                count = 1; // Számláló nullázása.
            }
        }
        
        // 3. lépés: Ciklus után az utolsó elem hozzáadása.
        result.Append(input[input.Length - 1]).Append(count);

        return result.ToString();
    }

    /// <summary>
    /// Kiszámítja a tömörítés arányát.
    /// </summary>
    /// <param name="original">Az eredeti szöveg.</param>
    /// <param name="processed">A feldolgozott szöveg.</param>
    /// <returns>A tömörítési arány double formátumban.</returns>
    public static double CalculateRatio(string original, string processed)
    {
        if (string.IsNullOrEmpty(original))
        {
            return 0.0;
        }
        return (double)processed.Length / original.Length;
    }

    public static void Main(string[] args)
    {
        string testData = "AAABBBCCDAA";
        string processedData = ProcessString(testData);
        double ratio = CalculateRatio(testData, processedData);

        Console.WriteLine($"Eredeti adat: {testData}");
        Console.WriteLine($"Feldolgozott adat: {processedData}");
        Console.WriteLine($"Tömörítési arány: {ratio:F2}");
    }
}