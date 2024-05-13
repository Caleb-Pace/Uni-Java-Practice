package unijavapractice.secret;

public class TopSecret {
    public String text;

    public TopSecret(String text) {
        this.text = text;
    }


    //-/ Methods
    private String underscores(int n) { return "_".repeat(n); }

    public TopSecret redact(String[] redactions) {
        String newText = text;
        
        // Redact with underscores
        for (String redaction : redactions) {
            newText = newText.replace(redaction, underscores(redaction.length()));
        }

        return new TopSecret(newText);
    }

    public String toString() {
        return "Text = " + text;
    }
}
