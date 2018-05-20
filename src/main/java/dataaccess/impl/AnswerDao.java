package dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import dataaccess.AbstractDao;
import datamodel.Answer;
import table.AnswerTable;

public class AnswerDao extends AbstractDao<AnswerTable,Answer> implements Serializable {
    public AnswerDao(final String rootFolderPath){
        super(rootFolderPath);
    }

    @Override
    public void saveNew(Answer newAnswer) {
        newAnswer.setId(getNextId());
        final AnswerTable answerTable = deserializeFromXml();
        answerTable.getRows().add(newAnswer);
        serializeToXml(answerTable);
    }

    @Override
    public void update(Answer entity) {
        final AnswerTable answerTable = deserializeFromXml();

        for (final Answer row : answerTable.getRows()) {
            if (row.getId().equals(entity.getId())) {
                row.setAnswerCorrect(entity.isAnswerCorrect());
                row.setAnswerText(entity.getAnswerText());
                break;
            }
        }

        serializeToXml(answerTable);
    }

    @Override
    public Answer get(Long id) {
        final AnswerTable answerTable = deserializeFromXml();

        for (final Answer row : answerTable.getRows()) {
            if (row.getId().equals(id)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<Answer> getAll() {
        final AnswerTable answerTable = deserializeFromXml();
        return answerTable.getRows();
    }

    @Override
    public void delete(Long id) {
        final AnswerTable answerTable = deserializeFromXml();

        Answer toBeDeleted = null;
        for (final Answer row : answerTable.getRows()) {
            if (row.getId().equals(id)) {

                toBeDeleted = row;
                break;
            }
        }

        answerTable.getRows().remove(toBeDeleted);

        serializeToXml(answerTable);
    }
    protected Class<AnswerTable> getTableClass(){
        return AnswerTable.class;
    }
}
