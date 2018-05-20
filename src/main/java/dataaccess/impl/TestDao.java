package dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import dataaccess.AbstractDao;
import datamodel.TesT;
import table.TestTable;

public class TestDao extends AbstractDao<TestTable, TesT> implements Serializable {
    public TestDao(final String rootFolderPath){
        super(rootFolderPath);
    }

    @Override
    public void saveNew(TesT newTest) {
        newTest.setId(getNextId());
        final TestTable testTable = deserializeFromXml();
        testTable.getRows().add(newTest);
        serializeToXml(testTable);
    }

    @Override
    public void update(TesT entity) {
        final TestTable testTable = deserializeFromXml();

        for (final TesT row : testTable.getRows()) {
            if (row.getId().equals(entity.getId())) {
                row.setTestName(entity.getTestName());
                row.setQuestions(entity.getQuestions());
                break;
            }
        }

        serializeToXml(testTable);
    }

    @Override
    public TesT get(Long id) {
        final TestTable testTable = deserializeFromXml();

        for (final TesT row : testTable.getRows()) {
            if (row.getId().equals(id)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<TesT> getAll() {
        final TestTable testTable = deserializeFromXml();
        return testTable.getRows();
    }

    @Override
    public void delete(Long id) {
        final TestTable testTable = deserializeFromXml();

        TesT toBeDeleted = null;
        for (final TesT row : testTable.getRows()) {
            if (row.getId().equals(id)) {
                toBeDeleted = row;
                break;
            }
        }

        testTable.getRows().remove(toBeDeleted);

        serializeToXml(testTable);
    }
    protected Class<TestTable> getTableClass(){
        return TestTable.class;
    }
}
