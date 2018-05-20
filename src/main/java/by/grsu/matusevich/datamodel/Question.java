package by.grsu.matusevich.datamodel;

import java.util.List;
import java.util.ArrayList;

public class Question extends AbstractModel {

    private String questionText;
    private List<Answer> answers;

    public Question() {
        answers = new ArrayList<Answer>();
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

}
