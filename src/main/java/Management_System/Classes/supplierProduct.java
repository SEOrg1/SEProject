package Management_System.Classes;

import java.util.ArrayList;

public class supplierProduct {

    String name;
    double price;
    String SupplierName;
    String msg;
    user user=new user();

    public static ArrayList<supplierProduct> supplierProducts =new ArrayList<>();

    public supplierProduct() {}
    public supplierProduct(String SupplierName,String name, double price) {
        this.SupplierName = SupplierName;
        this.name = name;
        this.price = price;
    }

    public String getMsg() {
        return msg;
    }
    public String getProductName() {
        return this.name;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean deleteSupplierProduct(String productName) {
            for (supplierProduct product : supplierProducts) {
                if (product.getProductName().equals(productName)) {
                    supplierProducts.remove(product);
                    setMsg("product has been deleted successfully");
                    return true;
                }
            }
        setMsg("cant delete because missing name or non exist product Name");
        return false;
    }

    public boolean addSupplierProduct(String supplierName,String productName, double price) {
        if (user.checkUser(supplierName)&& supplierName!=null&&productName!=null&&price!=0.0){
            supplierProduct s1= new supplierProduct(supplierName,productName,price);
            supplierProducts.add(s1);
            setMsg("product has been added successfully");
            return true;
        }
            setMsg("can't add because missing some fields or non exist supplier");
            return false;
    }
}
