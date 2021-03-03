import javax.persistence.*;

@Entity
@Table(name = "Categories")

public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "category_name")
    private String categoryName;

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
