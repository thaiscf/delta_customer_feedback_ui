package liverton.co.nz.schema;

import org.apache.commons.lang3.StringUtils;

public class Customer {

    String firstName;
    String lastName;
    String email;
    String phone;

    public String getFirstName() {
        return StringUtils.isNotEmpty(firstName) ? firstName : StringUtils.EMPTY;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return StringUtils.isNotEmpty(lastName) ? lastName : StringUtils.EMPTY;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return StringUtils.isNotEmpty(phone) ? phone : StringUtils.EMPTY;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return getFirstName().concat(StringUtils.SPACE).concat(getLastName());
    }
}
