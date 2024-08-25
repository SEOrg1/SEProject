package Management_System.Classes;

import java.util.ArrayList;
import java.util.logging.*;

public class order {

    public static ArrayList<order> orders = new ArrayList<>();
    String nameOfWhoOrder;
    Double totalOfOrder;
    public String msg;
    public checkOut checkOut=new checkOut();
    public ArrayList<iteam> orderIteam=new ArrayList<>();
    String feedback;
    private static final Logger logger = Logger.getLogger(order.class.getName());
    static {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
    }
    public order() {}
    public order(ArrayList<iteam> iteam,String nameOfWhoOrder ,Double totalOfOrder) {
        this.orderIteam=iteam;
        this.nameOfWhoOrder = nameOfWhoOrder;
        this.totalOfOrder = totalOfOrder;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean addOrderFeedback(String feedback) {
        if (feedback!=null) {
            this.feedback = feedback;
            setMsg("your feedback added successfully");
            return true;
        }
        setMsg("your feedback did not added successfully");
        return false;
    }

    public String getMsg(){
        return msg;
    }
    public ArrayList<iteam> getOrderIteams(){
        return orderIteam;
    }

    public boolean addOrder(ArrayList<iteam> iteam,String userName) {
        if (!iteam.isEmpty()&&userName.length()!=0) {
            double totalOrder=0.0;
            for (iteam iteam1:iteam){
                totalOrder+=iteam1.getPrice();
            }
            order order1=new order(iteam,userName,totalOrder);
            orders.add(order1);
            return true;
        }
        return false;
    }


    public boolean printReportOrder(ArrayList<order> order) {
        if (!orders.isEmpty()) {
            int i=1;
            for (order order1 : order) {
                logger.info("There is a Report About All Orders");
                double totalOrderCost = (order1.totalOfOrder / 2);
                logger.info(String.format("Order number %d: User who ordered: %s, The cost of this order: %.2f, The profit from this order: %.2f",
                        i, order1.nameOfWhoOrder, totalOrderCost, (order1.totalOfOrder - totalOrderCost)));
                checkOut.detailOrder(order1.getOrderIteams());
                return true;
            }
        }
        setMsg("cannot generate report because there is no order");
        return false;
    }


    static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord logRecord) {
            return logRecord.getMessage() + "\n";
        }
    }

}
