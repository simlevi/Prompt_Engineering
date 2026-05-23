using System;
using System.Text;

public class DataProcessor
{
    public static string ProcessString(string input)
    {
        if (string.IsNullOrEmpty(input))
        {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.Length; i++)
        {
            if (input[i] == input[i - 1])
            {
                count++;
            }
            else
            {
                result.Append(input[i - 1]).Append(count);
                count = 1;
            }
        }
        
        result.Append(input[input.Length - 1]).Append(count);

        return result.ToString();
    }

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