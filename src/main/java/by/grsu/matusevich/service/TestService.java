package by.grsu.matusevich.service;

import by.grsu.matusevich.datamodel.TesT;

import java.util.List;

public interface TestService {

    void addNew(TesT entity);

    void update(TesT entity);

    TesT get(Long id);

    List<TesT> getAll();

    void delete(Long id);

    void addOrUpdate(TesT test);
}
