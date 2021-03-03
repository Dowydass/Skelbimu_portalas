import javax.persistence.*;

@Entity
@Table(name = "Comments")

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int comment_id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "advertisement_id")
    private int advertisementId;
    @Column(name = "comment")
    private String comment;

    public Comments(int userId, int advertisementId, String comment) {
        this.userId = userId;
        this.advertisementId = advertisementId;
        this.comment = comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment_id=" + comment_id +
                ", userId=" + userId +
                ", advertisementId=" + advertisementId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
