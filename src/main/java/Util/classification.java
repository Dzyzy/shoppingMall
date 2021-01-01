package Util;

public class classification {
    private int classification;
    private String classification_name;
    private int classification_parent_id;

    public classification(int classification, String classification_name, int classification_parent_id) {
        this.classification = classification;
        this.classification_name = classification_name;
        this.classification_parent_id = classification_parent_id;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getClassification_name() {
        return classification_name;
    }

    public void setClassification_name(String classification_name) {
        this.classification_name = classification_name;
    }

    public int getClassification_parent_id() {
        return classification_parent_id;
    }

    public void setClassification_parent_id(int classification_parent_id) {
        this.classification_parent_id = classification_parent_id;
    }
}
