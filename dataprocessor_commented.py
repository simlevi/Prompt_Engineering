
# Nyelv: PYTHON
# Kommentelési stílus: Google Python + Zászlók

# FIXME: Később érdemes bevezetni a bemenet validálását (pl. csak betűk elfogadása), 
# mert a számok a szövegben megzavarhatják a kitömörítést.

def process_string(input_text: str) -> str:
    """Feldolgozza és tömöríti a bemeneti szöveget RLE algoritmussal.
    
    Args:
        input_text: A feldolgozandó eredeti karakterlánc.
        
    Returns:
        A tömörített szöveg. Ha a bemenet üres, üres stringet ad vissza.
    """
    # 1. lépés: Alapvető bemenet-ellenőrzés.
    if not input_text:
        return ""
        
    # TODO: Kis- és nagybetűk egységesítése a jövőben (pl. input_text.upper()).
    
    result = []
    count = 1
    
    # 2. lépés: Végigiterálunk a karaktereken a másodiktól kezdve.
    for i in range(1, len(input_text)):
        if input_text[i] == input_text[i - 1]:
            # Ha egyezik az előzővel, csak növeljük a számlálót.
            count += 1
        else:
            # HACK: Formázott stringként (f-string) fűzzük össze a karaktert és a számot.
            result.append(f"{input_text[i - 1]}{count}")
            count = 1 # Visszaállítjuk a számlálót az új karakterhez.
            
    # 3. lépés: Az utolsó karaktercsoport hozzáadása a ciklus után.
    result.append(f"{input_text[-1]}{count}")
    
    return "".join(result)

def calculate_ratio(original: str, processed: str) -> float:
    """Kiszámítja a tömörítés arányát a hosszúságok alapján."""
    if not original:
        return 0.0
    return len(processed) / len(original)

def main():
    """A program belépési pontja."""
    test_data = "AAABBBCCDAA"
    processed_data = process_string(test_data)
    ratio = calculate_ratio(test_data, processed_data)
    
    print(f"Eredeti: {test_data}")
    print(f"Feldolgozott: {processed_data}")
    print(f"Arány: {ratio:.2f}")

if __name__ == "__main__":
    main()