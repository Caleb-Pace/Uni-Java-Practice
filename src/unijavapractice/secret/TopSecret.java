package unijavapractice.secret;

public class TopSecret {
    public String text;

    public TopSecret(String text) {
        this.text = text;
    }


    //-/ Methods
    // Obscures sensitive information/{redactions} from the text.
    //     Replaces redacted characters with underscores.
    public TopSecret redact(String[] redactions) {
        String newText = text; // Copy text
        
        // Replace each redaction with underscores
        for (String redaction : redactions) {
            newText = newText.replace(redaction, underscores(redaction.length()));
        }

        return new TopSecret(newText);
    }

    public String toString() {
        return "Text = " + text;
    }

    // Creates a string of underscores of length {n}.
    private String underscores(int n) { return "_".repeat(n); }
}
