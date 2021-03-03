
public class Main {
    public static void main(String[] args){
        //-------------------------------------created new user with table-------------------------------------//
        UserDAO.createTableUser();
        User user = new User("Kovas", "Balandis");
        UserDAO.createNewUser(user);
        //-------------------------------------created new category with table---------------------------------//
        CategoriesDAO.createTableCategories();
        Categories categories = new Categories("Fast food");
        CategoriesDAO.createNewCategory(categories);
        //-------------------------------------created new advertisement with table ---------------------------//
        AdvertisementDAO.createNewTableAdvertisement();
        Advertisement advertisement = new Advertisement(1,1,"Sushi");
        AdvertisementDAO.createNewAdvertisement(advertisement);


    }
}
