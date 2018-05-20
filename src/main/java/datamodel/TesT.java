package datamodel;

import java.util.List;

import java.util.ArrayList;

public class TesT extends AbstractModel {

    private String TestName;

    private List<Question> Questions;

    public TesT(){
        Questions = new ArrayList<Question>();
    }

    public void setQuestions(List<Question> questions) {
        Questions = questions;
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public String getTestName() {
        return TestName;
    }
}
