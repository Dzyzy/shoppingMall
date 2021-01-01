package Util;

import java.util.ArrayList;
import java.util.List;

public class classifica {
    private int classification_id;
    private String classification_name;
    private int classificaton_parent_id;
    List<classifica> list_class = new ArrayList<>();

    public classifica() {
    }

    public classifica(int classification_id, String classification_name, int classificaton_parent_id, List<classifica> list_class) {
        this.classification_id = classification_id;
        this.classification_name = classification_name;
        this.classificaton_parent_id = classificaton_parent_id;
        this.list_class = list_class;
    }

    public List<classifica> getList_class() {
        return list_class;
    }

    public void setList_class(List<classifica> list_class) {
        this.list_class = list_class;
    }

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification) {
        this.classification_id = classification;
    }

    public String getClassification_name() {
        return classification_name;
    }

    public void setClassification_name(String classification_name) {
        this.classification_name = classification_name;
    }

    public int getClassificaton_parent_id() {
        return classificaton_parent_id;
    }

    public void setClassificaton_parent_id(int classificaton_parent_id) {
        this.classificaton_parent_id = classificaton_parent_id;
    }
}
