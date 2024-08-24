package Management_System.Classes;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class iteam {


    private String name;
    private double price;
    String description;
    String msg;
    public static ArrayList<iteam> iteams = new ArrayList<>();;
    public iteam(String name, double price ) {
        this.name = name;
        this.price = price;
    }
    public iteam() {

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String getMsg() {
        return msg;
    }
    public boolean addItam(iteam iteam) {
        if (iteam.name==null)
            return false;
        else{
            iteams.add(iteam);
            return true;
        }
    }
    public boolean addIteam(String name,String description,double price) {
        if (name==null){
            msg="Dessert name is required";
            return false;
        } else if (price==0.0) {
            msg="Dessert price is required";
            return false;
        }else{
            msg="Dessert has been added successfully";
            iteams.add(new iteam(name,price));
            return true;
        }
    }

    public boolean updateIteam(String oldName,String newName,String description,double price) {
        for (iteam iteam1 : iteams) {
            if (iteam1.getName().equals(oldName)){
                iteam1.setName(newName);
                iteam1.setDescription(  description );
                iteam1.setPrice(price);
                msg="Dessert has been updated successfully";
                return true;
            }
        }
        msg="cant update because missing name or non existent dessert";
        return false;
    };
    public boolean cheakIteam(String name) {
        for (iteam iteam : iteams) {
            if (iteam.getName().equals(name)){
                msg="Dessert has been founded";
                return true;
            }
        }
        msg="cant found dessert because missing name or non existent dessert";
        return false;
    }
    public boolean removeItam(String name) {
        for (iteam iteam : iteams) {
            if (iteam.getName().equals(name)) {
                iteams.remove(iteam);
                msg="Dessert has been deleted successfully";
                return true;
            }
        }
        msg="cant delete because missing name or not exist Dessert Name";
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
