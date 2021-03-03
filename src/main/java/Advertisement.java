import javax.persistence.*;

@Entity
@Table(name = "Advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private int advertisementId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "description")
    private String description;


    public Advertisement(int categoryId, int userId, String description ) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.description = description;

    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 }
