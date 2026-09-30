// Name: [Your Name]
// Date: [Current Date]
// Description: Manages the collection of letters and company metadata for Alphabet Soup.

public class Soup {
    // Instance variables 
    private String letters;
    private String company;

    // Constructor
    public Soup() {
        letters = "";
        company = "none";
    }

    // Sets the name of the company to the provided name
    public void setCompany(String company) {
        this.company = company;
    }

    // Returns the company name
    public String getCompany() {
        return company;
    }

    // Returns letters
    public String getLetters() {
        return letters;
    }

    //below are the functions you'll be writing.

    //precondition: word is a valid String.
    //postcondition: adds word to the end of letters.
    //adds a word to the pool of letters known as "letters"
    public void add(String word) {
        if (word != null) {
            this.letters += word;
        }
    }

    //precondition: letters is not empty.
    //postcondition: returns a random character from letters.
    //Use Math.random() to get a random character from the letters string and return it.
    public char randomLetter() {
        if (letters.isEmpty()) {
            return ' ';
        }
        int randomIndex = (int) (Math.random() * letters.length());
        return letters.charAt(randomIndex);
    }

    //precondition: letters and company exist.
    //postcondition: returns letters with company added to the middle.
    //returns the letters currently stored with the company name placed directly in the center of all
    //the letters
    public String companyCentered() {
        int mid = letters.length() / 2;
        return letters.substring(0, mid) + company + letters.substring(mid);
    }

    //precondition: none.
    //postcondition: removes the first vowel in letters if one exists.
    //should remove the first available vowel from letters. If there are no vowels this method has no effect.
    public void removeFirstVowel() {
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < letters.length(); i++) {
            if (vowels.indexOf(letters.charAt(i)) != -1) {
                letters = letters.substring(0, i) + letters.substring(i + 1);
                break;
            }
        }
    }

    //precondition: num is valid and not bigger than letters length.
    //postcondition: removes num letters from a random spot in letters.
    //should remove "num" letters from a random spot in the string letters. You may assume num never exceeds the length of the string.
    public void removeSome(int num) {
        if (num <= 0 || num > letters.length()) {
            return;
        }
        int maxStartIndex = letters.length() - num;
        int startIndex = (int) (Math.random() * (maxStartIndex + 1));
        letters = letters.substring(0, startIndex) + letters.substring(startIndex + num);
    }

    //precondition: word is a valid String.
    //postcondition: removes word from letters if it is found.
    //should remove the word "word" from the string letters. If the word is not found in letters then it does nothing .
    public void removeWord(String word) {
        if (word != null && !word.isEmpty()) {
            int index = letters.indexOf(word);
            if (index != -1) {
                letters = letters.substring(0, index) + letters.substring(index + word.length());
            }
        }
    }
}