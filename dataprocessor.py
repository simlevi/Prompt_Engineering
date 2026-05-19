def process_string(input_text: str) -> str:
    if not input_text:
        return ""
        
    result = []
    count = 1
    
    for i in range(1, len(input_text)):
        if input_text[i] == input_text[i - 1]:
            count += 1
        else:
            result.append(f"{input_text[i - 1]}{count}")
            count = 1
            
    result.append(f"{input_text[-1]}{count}")
    
    return "".join(result)

def calculate_ratio(original: str, processed: str) -> float:
    if not original:
        return 0.0
    return len(processed) / len(original)

def main():
    test_data = "AAABBBCCDAA"
    processed_data = process_string(test_data)
    ratio = calculate_ratio(test_data, processed_data)
    
    print(f"Eredeti: {test_data}")
    print(f"Feldolgozott: {processed_data}")
    print(f"Arány: {ratio:.2f}")

if __name__ == "__main__":
    main()