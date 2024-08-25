package management_system.classes;

import java.util.ArrayList;
import java.util.logging.*;


public class CheckOut {
    int i=1;
    public String msg;
    double totalOrder;
    public String getMsg(){
        return msg;
    }
    private static final Logger logger = Logger.getLogger(CheckOut.class.getName());
    static {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Order.SimpleFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
    }

    public void detailOrder(ArrayList<Item> iteam){
        for (Item iteam1 : iteam){
            logger.info(i + "-" + iteam1.getName() + " price=" + iteam1.getPrice());
            totalOrder += iteam1.getPrice();
            i++;
        }
        i = 1;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public boolean isValidCheckOut(ArrayList<Item> iteam){
        if (iteam.isEmpty()){
            setMsg("incomplete check out beacuse you didnt order anythings");
            return false;
        }else{
            detailOrder(iteam);
            setMsg("complete check out");
            return true;
        }
    }

    public void printOrderDetail(ArrayList<Item> iteam, String username, String email, String address, String phone, double totalOrder){
        detailOrder(iteam);
        logger.info(String.format("username=%s", username));
        logger.info(String.format("email=%s", email));
        logger.info(String.format("address=%s", address));
        logger.info(String.format("phone=%s", phone));
        logger.info(String.format("totalOrder=%.2f", totalOrder));
    }


}
