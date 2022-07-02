package SuperMarket;


public class Product {

    private int id;
    private String Product_Name;
    private String Category_Name;
    private int Qty;
    private float Price;
    private  String Status;

    public Product(String product_Name, String category_Name, float price, String status) {
        Product_Name = product_Name;
        Category_Name = category_Name;
        Price = price;
        Status = status;
    }

    public Product(int id, String product_Name, String category_Name, int qty, float price, String status) {
        this.id = id;
        Product_Name = product_Name;
        Category_Name = category_Name;
        Qty = qty;
        Price = price;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public int getQty() {
        return Qty;
    }

    public float getPrice() {
        return Price;
    }

    public String getStatus() {
        return Status;
    }

}
