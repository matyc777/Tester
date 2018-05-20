package by.grsu.matusevich.datamodel;

import java.io.Serializable;

public class AbstractModel implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
