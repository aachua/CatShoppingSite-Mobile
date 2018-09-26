package edu.aachuaumich.cis436_final.Objects;

public class Order
{
    private int ProductId;
    private int UserId;
    private String ProductName;
    private String Price;


    public Order(int productId, int userId, String productName, String price)
    {
        ProductId = productId;
        UserId = userId;
        ProductName = productName;
        Price = price;
    }

    public int getProductId() {

        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getUserId() {
    return UserId;
}

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }


    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
