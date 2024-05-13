package unijavapractice.textanalysis;

public class WordCounter {
    private String text;
    private int[] frequencies;

    public WordCounter(String text) {
        setText(text);
    }


    //-/ Set
    // Sets the text.
    //     Keyword frequencies are calculated based on {text}.
    public void setText(String text) {
        this.text = text;
        frequencies = keywordFreqency();
    }

    //-/ Methods
    public String toString() {
        String output = "";

        // Format and append keyword-frequency pairs
        int i = 0; // Links keyword to frequency array
        for (Keyword keyword : Keyword.values()) {
            output += String.format("%s: %d ", keyword.getStr(), frequencies[i++]);
        }

        return output.substring(0, (output.length() - 1)); // Remove trailing space
    }
    
    // Counts the frequency of each keyword in the text.
    private int[] keywordFreqency() {
        int[] frequencies = new int[Keyword.values().length]; // Stores keyword frequencies
        
        // Loop through each word
        for (String word : text.split(" ")) {
            int i = 0; // Reset keyword frequency pointer

            // Loop through each Keyword
            for (Keyword keyword : Keyword.values()) {
                // Check if the current word matches the keyword
                if (keyword.getStr().equals(word))
                    frequencies[i]++; // Count word
                
                i++; // Next keyword
            }
        }

        return frequencies;
    }

    //--/ Data structures
    public enum Keyword {
        FOX("fox"), QUICK("quick"), LAZY("lazy"), CAT("cat"); 

        private String word;

        private Keyword(String word) {
            this.word = word;
        }


        //-/ Get
        public String getStr() { return word; }
    }
}
