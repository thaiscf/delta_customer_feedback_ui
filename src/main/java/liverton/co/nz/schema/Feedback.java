package liverton.co.nz.schema;

import org.apache.commons.lang3.StringUtils;

public class Feedback {

    String description;
    Customer customer;
    Product product;
    String sentTo;

    public String getDescription() {
        return StringUtils.isNotEmpty(description) ? description : StringUtils.EMPTY;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSentTo() {
        return StringUtils.isNotEmpty(sentTo) ? sentTo : StringUtils.EMPTY;
    }

    public void setSentTo(String sentTo) { this.sentTo = sentTo; }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("Feed back details");
        sb.append("\\n");
        sb.append("Customer: ").append(customer.getFullName());
        sb.append("\\n");
        sb.append("Email: ").append(customer.getEmail());
        sb.append("\\n");
        sb.append("Product: ").append(product.getName());
        sb.append("\\n");
        sb.append("Feedback: ").append(description);

        return sb.toString();
    }
}
