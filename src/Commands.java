import java.util.Arrays;
public class Commands {
    
    private final static int ADDUSER = 0;
    private final static int ADDADMIN = 1;
    private final static int ADDPRODUCT = 2;
    private final static int ADDCATEGORY = 3;
    private final static int ADDTOCART = 4;
    private final static int ADDORDER = 5;
    private final static int COUNT_USERS = 6;
    private final static int COUNT_PRODUCTS = 7;
    private final static int COUNT_CATEGORIES = 8;
    private final static int GET_USER_FIRSTNAME = 9;
    private final static int GET_USER_LASTNAME = 10;
    private final static int GET_USER_BALANCE = 11;
    private final static int GET_USER_PASSWORD = 12;
    private final static int GET_USER_NAME = 13;
    private final static int GET_USER_EMAIL = 14;
    private final static int GET_ORDERID = 15;
    private final static int GET_ALLUSERSID = 16;
    private final static int GET_ALLPRODUCTSID = 17;
    private final static int GET_ALLCATEGORIESID = 18;
    private final static int GET_ALLORDERSID = 19;
    private final static int GET_ORDERDATE = 20;
    private final static int GET_ORDERTOTALAMOUNT = 21;
    private final static int GET_PRODUCT_NAME = 22;
    private final static int GET_CATEGORY_NAME = 23;
    private final static int GET_PRODUCT_PRICE = 24;
    private final static int GET_PRODUCT_QUANTITY = 25;
    private final static int GET_PRODUCT_STATUS = 26;
    private final static int GET_CATEGORY_STATUS = 27;
    private final static int GET_ORDER_PRODUCT_QUANTITY = 28;
    private final static int GET_ORDERPRODUCTS = 29;
    private final static int INCREASE_BALANCE = 30;
    private final static int DECREASE_BALANCE = 31;
    private final static int INCREASE_STOCK = 32;
    private final static int CLEAR_CART = 33;
    private final static int GET_ADMIN_FIRSTNAME = 34;
    private final static int GET_ADMIN_LASTNAME = 35;
    private final static int GET_ADMIN_USERNAME = 36;
    private final static int GET_ADMIN_EMAIL = 37;
    private final static int CHANGE_PASSWORD = 38;
    private final static int CHANGE_USERNAME = 39;
    private final static int CHANGE_FIRSTNAME = 40;
    private final static int CHANGE_LASTNAME = 41;
    private final static int CHANGE_CATEGORYNAME = 42;
    private final static int CHANGE_CATEGORYSTATUS = 43;
    private final static int DELETE_USER = 44;
    private final static int DELETE_FROM_CART = 45;
    private final static int SEARCHBYCATEGORY = 46;
    private final static int SEARCHBYNAME = 47;
    private final static int CHANGE_PRODUCTNAME = 48;
    private final static int CHANGE_PRODUCTPRICE = 49;
    private final static int CHANGE_PRODUCTCATEGORY = 50;
    private final static int CHANGE_PRODUCTSTATUS = 51;
    private final static int LOGIN = 52;
    private final static int GET_ORDER_COUNT = 53;
    private final static int COUNT_ORDERS = 54;
    private final static int COUNT_PRODUCTS_IN_CART = 55;
    private final static int GET_PRODUCT_ID = 56;
    private final static int GET_CATEGORY_ID = 57;
    private final static int GET_PRODUCT_CATEGORY = 58;

    
    public static String quiry(String msg){
        String[] msgSplit = msg.split(":");
        int op = Integer.parseInt(msgSplit[0]);
        String[] param = msgSplit[1].split(";");
        String res=null;
        Database db = Database.create();
        switch(op){
            case ADDUSER : 
                    res = db.addUser((param[0]),param[1],param[2],param[3],param[4]);
            break;
            case ADDADMIN : 
                    res = db.addAdmin((param[0]),param[1],param[2],param[3],param[4]);
            break;
            case ADDPRODUCT : 
                    res = db.addProduct((param[0]),Integer.parseInt(param[1]),Double.parseDouble(param[2]),Integer.parseInt(param[3]),(param[4]));
            break;
            case ADDCATEGORY : 
                    res = db.addCategory((param[0]),param[1]);
            break;
            case ADDTOCART : 
                    res = db.addToCart(Integer.parseInt(param[0]),Integer.parseInt(param[1]),Integer.parseInt(param[2]));
            break;
            case ADDORDER : 
                    res = db.addOrder(Integer.parseInt(param[0]),Integer.parseInt(param[1]),Integer.parseInt(param[2]),param[3],Integer.parseInt(param[4]));
            break;
            case COUNT_USERS : 
                    res = String.valueOf(db.count_users());
            break;
            case COUNT_PRODUCTS : 
                    res = String.valueOf(db.count_products());
            break;
            case COUNT_CATEGORIES : 
                    res = String.valueOf(db.count_categories());
            break;
            case GET_USER_FIRSTNAME : 
                    res = String.valueOf(db.get_user_firstName(Integer.parseInt(param[0])));
            break;
            case GET_USER_LASTNAME : 
                    res = String.valueOf(db.get_user_lastName(Integer.parseInt(param[0])));
            break;
            case GET_USER_BALANCE : 
                    res = String.valueOf(db.get_user_balance(Integer.parseInt(param[0])));
            break;
            case GET_USER_PASSWORD : 
                    res = String.valueOf(db.get_user_password(Integer.parseInt(param[0])));
            break;
            case GET_USER_NAME : 
                    res = db.get_user_name(Integer.parseInt(param[0]));
            break;
            case GET_USER_EMAIL : 
                    res = String.valueOf(db.get_user_email(Integer.parseInt(param[0])));
            break;
            case GET_ORDERID : 
                    res = Arrays.toString(db.get_orderID(Integer.parseInt(param[0])));
                    res = res.substring(1, res.length() - 1);
            break;
            case GET_ALLUSERSID : 
                    res = Arrays.toString(db.get_allUsersID());
                    res = res.substring(1, res.length() - 1);
            break;
            case GET_ALLPRODUCTSID :
                    res = Arrays.toString(db.get_allProductsID());
                    res = res.substring(1, res.length() - 1);
            break;
            case GET_ALLCATEGORIESID : 
                    res = Arrays.toString(db.get_allCategoriesID());
                    res = res.substring(1, res.length() - 1);
            break;
            case GET_ALLORDERSID : 
                    res = Arrays.toString(db.get_allOrdersID());
                    res = res.substring(1, res.length() - 1);
            break;
            case GET_ORDERDATE : 
                    res = String.valueOf(db.get_orderDate(Integer.parseInt(param[0])));
            break;
            case GET_ORDERTOTALAMOUNT : 
                    res = String.valueOf(db.get_orderTotalAmount(Integer.parseInt(param[0])));
            break;
            case GET_PRODUCT_NAME : 
                    res = String.valueOf(db.get_product_name(Integer.parseInt(param[0])));
            break;
            case GET_CATEGORY_NAME : 
                    res = String.valueOf(db.get_category_name(Integer.parseInt(param[0])));
            break;
            case GET_PRODUCT_PRICE : 
                    res = String.valueOf(db.get_product_price(Integer.parseInt(param[0])));
            break;
            case GET_PRODUCT_QUANTITY : 
                    res = String.valueOf(db.get_product_quantity(Integer.parseInt(param[0])));
            break;
            case GET_PRODUCT_STATUS : 
                    res = String.valueOf(db.get_product_status(Integer.parseInt(param[0])));
            break;
            case GET_CATEGORY_STATUS : 
                    res = String.valueOf(db.get_category_status(Integer.parseInt(param[0])));
            break;
            case GET_ORDER_PRODUCT_QUANTITY : 
                    res = String.valueOf(db.get_order_product_quantity(Integer.parseInt(param[0]),Integer.parseInt(param[1])));
            break;
            case GET_ORDERPRODUCTS : 
                    res = Arrays.toString(db.get_orderProducts(Integer.parseInt(param[0])));
                    res = res.substring(1, res.length() - 1);
            break;
            case INCREASE_BALANCE : 
                    res = db.increase_balance(Integer.parseInt(param[0]),Integer.parseInt(param[1]));
            break;
            case DECREASE_BALANCE : 
                    res = db.decrease_balance(Integer.parseInt(param[0]),Integer.parseInt(param[1]));
            break;
            case INCREASE_STOCK : 
                    res = db.increase_stock(Integer.parseInt(param[0]),Integer.parseInt(param[1]));
            break;
            case CLEAR_CART : 
                    db.clear_cart(Integer.parseInt(param[0]));
            break;
            case GET_ADMIN_FIRSTNAME : 
                    res = String.valueOf(db.get_admin_firstName(Integer.parseInt(param[0])));
            break;
            case GET_ADMIN_LASTNAME : 
                    res = String.valueOf(db.get_admin_lastName(Integer.parseInt(param[0])));
            break;
            case GET_ADMIN_USERNAME : 
                    res = String.valueOf(db.get_admin_username(Integer.parseInt(param[0])));
            break;
            case GET_ADMIN_EMAIL : 
                    res = String.valueOf(db.get_admin_email(Integer.parseInt(param[0])));
            break;
            case CHANGE_PASSWORD : 
                    res = db.change_password(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_USERNAME : 
                    res = db.change_userName(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_FIRSTNAME : 
                     db.change_FirstName(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_LASTNAME : 
                    db.change_LastName(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_CATEGORYNAME : 
                    res = db.change_CategoryName(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_CATEGORYSTATUS : 
                    res = db.change_CategoryStatus(Integer.parseInt(param[0]),param[1]);
            break;
            case DELETE_USER : 
                    res = db.delete_user(Integer.parseInt(param[0]));
            break;
            case DELETE_FROM_CART : 
                    res = db.delete_from_cart(Integer.parseInt(param[0]),Integer.parseInt(param[1]));
            break;
            case SEARCHBYCATEGORY : 
                    res = Arrays.toString(db.searchByCategory(param[0]));
                    res = res.substring(1, res.length() - 1);
            break;
            case SEARCHBYNAME : 
                    res = Arrays.toString(db.searchByName(param[0]));
                    res = res.substring(1, res.length() - 1);
            break;
            case CHANGE_PRODUCTNAME : 
                    res = db.change_ProductName(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_PRODUCTPRICE : 
                    res = db.change_ProductPrice(Integer.parseInt(param[0]),Double.parseDouble(param[1]));
            break;
            case CHANGE_PRODUCTCATEGORY : 
                    res = db.change_ProductCategory(Integer.parseInt(param[0]),param[1]);
            break;
            case CHANGE_PRODUCTSTATUS : 
                    res = db.change_ProductStatus(Integer.parseInt(param[0]),param[1]);
            break;
            case LOGIN :
                res = db.login(param[0], param[1]);
                break;
            case GET_ORDER_COUNT:
                res = String.valueOf(db.get_order_count(Integer.parseInt(param[0])));
                break;
            case COUNT_ORDERS:
                res = String.valueOf(db.count_orders());
                break;
            case COUNT_PRODUCTS_IN_CART:
                res = String.valueOf(db.count_products_in_cart(Integer.parseInt(param[0])));
                break;
            case GET_PRODUCT_ID:
                res = String.valueOf(db.get_ProductID(param[0]));
                break;
            case GET_CATEGORY_ID:
                res = String.valueOf(db.get_CategoryID(param[0]));
                break;
            case GET_PRODUCT_CATEGORY:
                res = String.valueOf(db.get_product_category(Integer.parseInt(param[0])));
                break;
        }
        if(res == null){
            res = "Done Successfully";
        }
        return res;
    } 
}   
       
