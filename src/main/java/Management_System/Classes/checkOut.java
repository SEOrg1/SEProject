package Management_System.Classes;

import java.util.ArrayList;

public class checkOut {
    int i=1;
    public String msg;
    double totalOrder;
    public String getMsg(){
        return msg;
    }
    public void detailOrder(ArrayList<iteam> iteam){
        for (iteam iteam1:iteam){
            System.out.println(i+"-"+iteam1.getName()+ " price="+ iteam1.getPrice());
            totalOrder+=iteam1.getPrice();
            i++;
        }
        i=1;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public boolean isValidCheckOut(ArrayList<iteam> iteam){
        if (iteam.isEmpty()){
            setMsg("incomplete check out beacuse you didnt order anythings");
            return false;
        }else{
            detailOrder(iteam);
            setMsg("complete check out");
            return true;
        }
    }

    public void printOrderDetail(ArrayList<iteam> iteam,String username,String email,String addres,String phone,double totalOrder){

        detailOrder(iteam);
        System.out.println("username="+username);
        System.out.println("email="+email);
        System.out.println("addres="+addres);
        System.out.println("phone="+phone);
        System.out.println("totalOrder="+totalOrder);
    }
}
