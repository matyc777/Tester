package by.grsu.matusevich.service.impl;

import by.grsu.matusevich.dataaccess.impl.TestDao;
import by.grsu.matusevich.datamodel.TesT;
import by.grsu.matusevich.service.TestService;

import java.util.List;

public class TestServiceImpl extends TestDao implements TestService {

    private TestDao testDao;

    public TestServiceImpl(String rootFolderPath) {
        super(rootFolderPath);
        testDao = new TestDao(rootFolderPath);
    }

    @Override
    public void addOrUpdate(TesT test){
        if (test.getId() == null) {
            testDao.saveNew(test);
        } else {
            testDao.update(test);
        }
    }

    @Override
    public void addNew(TesT entity) {
        testDao.saveNew(entity);
    }

    @Override
    public void update(TesT entity){
        testDao.update(entity);
    }

    @Override
    public TesT get(Long id){
        return testDao.get(id);
    }

    @Override
    public List<TesT> getAll(){
        return testDao.getAll();
    }

    @Override
    public void delete(Long id){
        testDao.delete(id);
    }
}


