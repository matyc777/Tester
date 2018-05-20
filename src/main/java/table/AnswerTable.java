package table;

import datamodel.Answer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnswerTable extends AbstractTable<Answer> {
    private List<Answer> rows;

    @Override
    public List<Answer> getRows(){
        if(rows == null){
            rows=new ArrayList<Answer>();
        }
        return rows;
    }

    @Override
    public void setRows(final List<Answer> rows) {
        this.rows = rows;
    }
}
