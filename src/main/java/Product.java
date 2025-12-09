import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString

public class Product {
    private int id;
    private String name;
    private Instant creationDateTime;
    private Category category;

    public Product(int id, String name, Instant creationDateTime, Category category) {
        this.id = id;
        this.name = name;
        this.creationDateTime = creationDateTime;
        this.category = category;
    }

    String getCategoryName() {
        return this.category.getName();
    }
}
