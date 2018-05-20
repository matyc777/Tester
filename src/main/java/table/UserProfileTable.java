package table;

import datamodel.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserProfileTable extends AbstractTable<UserProfile> {
    private List<UserProfile> rows;

    @Override
    public List<UserProfile> getRows() {
        if(rows==null) {
            rows = new ArrayList<UserProfile>();
        }
        return rows;
    }

    @Override
    public void setRows(final List<UserProfile> rows) {
        this.rows = rows;
    }
}
