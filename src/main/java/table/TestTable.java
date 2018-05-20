package table;

import datamodel.TesT;

import java.util.ArrayList;
import java.util.List;

public class TestTable extends AbstractTable<TesT> {
    private List<TesT> rows;

    @Override
    public List<TesT> getRows() {
        if(rows==null){
            rows= new ArrayList<TesT>();
        }
        return rows;
    }

    @Override
    public void setRows(final List<TesT> rows) {
        this.rows = rows;
    }
}
