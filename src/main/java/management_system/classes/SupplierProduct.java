package management_system.classes;

import java.util.ArrayList;

public class SupplierProduct {

    String name;
    double price;
    String supplierName;
    String msg;
    User user=new User();

    public static final ArrayList<SupplierProduct> supplierProducts =new ArrayList<>();

    public SupplierProduct() {}
    public SupplierProduct(String supplierName, String name, double price) {
        this.supplierName = supplierName;
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
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
            for (SupplierProduct product : supplierProducts) {
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
            SupplierProduct s1= new SupplierProduct(supplierName,productName,price);
            supplierProducts.add(s1);
            setMsg("product has been added successfully");
            return true;
        }
            setMsg("can't add because missing some fields or non exist supplier");
            return false;
    }
}
