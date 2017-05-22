package delta.co.nz.schema;

import org.apache.commons.lang3.StringUtils;

public class Product {

    String id;
    String name;
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return StringUtils.isNotEmpty(name) ? name : StringUtils.EMPTY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return StringUtils.isNotEmpty(description) ? description : StringUtils.EMPTY;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
