package management_system.classes;

import java.util.ArrayList;


public class Item {


    private String name;
    private double price;
    String description;
    String msg;
    public static final ArrayList<Item> iteams = new ArrayList<>();
    public Item(String name, double price ) {
        this.name = name;
        this.price = price;
    }
    public Item() {

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
    public boolean addItam(Item iteam) {
        if (iteam.name==null)
            return false;
        else{
            iteams.add(iteam);
            return true;
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean addIteam(String name,String description,double price) {
        if (name==null){
            setMsg("Dessert name is required");
            return false;
        } else if (price==0.0) {
            setMsg("Dessert price is required");
            return false;
        }else{
            setMsg("Dessert has been added successfully");
            iteams.add(new Item(name,price));
            return true;
        }
    }

    public boolean updateIteam(String oldName,String newName,String description,double price) {
        for (Item iteam1 : iteams) {
            if (iteam1.getName().equals(oldName)){
                iteam1.setName(newName);
                iteam1.setDescription(  description );
                iteam1.setPrice(price);
               setMsg("Dessert has been updated successfully");
                return true;
            }
        }
        setMsg("cant update because missing name or non existent dessert");
        return false;
    }
    public boolean cheakIteam(String name) {
        for (Item iteam : iteams) {
            if (iteam.getName().equals(name)){
                setMsg("Dessert has been founded");
                return true;
            }
        }
        setMsg("cant found dessert because missing name or non existent dessert");
        return false;
    }
    public boolean removeItam(String name) {
        for (Item iteam : iteams) {
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
