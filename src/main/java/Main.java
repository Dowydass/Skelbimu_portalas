import java.util.Random;

public class Main {
    public static void main(String[] args){

        String name1 = random.generateName();
        String name2 = random.generateName();


        UserDAO.updateUserById(1,name1,name2);
        CategoriesDAO.updateCategoryById(1,"Fancy food");
        AdvertisementDAO.updateById(1,"Chicken nuggets");
        CommentsDAO.updateCommentById(1,"Food was blank");


    }

    public static void createTableWithRecord(){
        //-------------------------------------created new user with table-------------------------------------//
        UserDAO.createTableUser();
        User user = new User("Kovas", "Balandis");
        UserDAO.createNewUser(user);
        //-------------------------------------created new category with table---------------------------------//
        CategoriesDAO.createTableCategories();
        Categories categories = new Categories("Fast food");
        CategoriesDAO.createNewCategory(categories);
        //-------------------------------------created new advertisement with table----------------------------//
        AdvertisementDAO.createNewTableAdvertisement();
        Advertisement advertisement = new Advertisement(1,1,"Sushi");
        AdvertisementDAO.createNewAdvertisement(advertisement);
        //-------------------------------------created new comment with table----------------------------------//
        CommentsDAO.createNewTableComments();
        Comments comments = new Comments(1,1,"Very tasty food");
        CommentsDAO.createNewComment(comments);
    }
}

