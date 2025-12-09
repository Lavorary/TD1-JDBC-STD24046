import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Category {
 private int id;
 private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}