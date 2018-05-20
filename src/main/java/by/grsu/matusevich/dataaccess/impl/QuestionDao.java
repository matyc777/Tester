package by.grsu.matusevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.matusevich.dataaccess.AbstractDao;
import by.grsu.matusevich.datamodel.Question;
import by.grsu.matusevich.table.QuestionTable;

public class QuestionDao extends AbstractDao<QuestionTable,Question> implements Serializable {
    public QuestionDao(final String rootFolderPath){
        super(rootFolderPath);
    }

    @Override
    public void saveNew(Question newQuestion) {
        newQuestion.setId(getNextId());
        final QuestionTable questionTable = deserializeFromXml();
        questionTable.getRows().add(newQuestion);
        serializeToXml(questionTable);
    }

    @Override
    public void update(Question entity) {
        final QuestionTable questionTable = deserializeFromXml();

        for (final Question row : questionTable.getRows()) {
            if (row.getId().equals(entity.getId())) {
                row.setQuestionText(entity.getQuestionText());
                row.setAnswers(entity.getAnswers());
                break;
            }
        }

        serializeToXml(questionTable);
    }

    @Override
    public Question get(Long id) {
        final QuestionTable questionTable = deserializeFromXml();

        for (final Question row : questionTable.getRows()) {
            if (row.getId().equals(id)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<Question> getAll() {
        final QuestionTable questionTable = deserializeFromXml();
        return questionTable.getRows();
    }

    @Override
    public void delete(Long id) {
        final QuestionTable questionTable = deserializeFromXml();

        Question toBeDeleted = null;
        for (final Question row : questionTable.getRows()) {
            if (row.getId().equals(id)) {

                toBeDeleted = row;
                break;
            }
        }

        questionTable.getRows().remove(toBeDeleted);

        serializeToXml(questionTable);
    }
    protected Class<QuestionTable> getTableClass(){
        return QuestionTable.class;
    }
}
