package by.grsu.matusevich.table;

import by.grsu.matusevich.datamodel.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionTable extends AbstractTable<Question> {
    private List<Question> rows;

    @Override
    public List<Question> getRows() {
        if(rows==null) {
            rows = new ArrayList<Question>();
        }
        return rows;
    }

    @Override
    public void setRows(final List<Question> rows) {
        this.rows = rows;
    }
}
