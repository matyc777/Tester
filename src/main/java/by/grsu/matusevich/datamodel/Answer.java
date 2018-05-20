package by.grsu.matusevich.datamodel;



public class Answer extends AbstractModel {
    private String answerText;
    private boolean answerCorrect;

    public Answer() {

    }

    public void setAnswerCorrect(boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public boolean isAnswerCorrect() {
        return answerCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

