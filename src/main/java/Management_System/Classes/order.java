package Management_System.Classes;

import java.util.ArrayList;

public class order {

    public static final ArrayList<order> orders = new ArrayList<>();
    String nameOfWhoOrder;
    Double totalOfOrder;
    public String msg;
    public checkOut checkOut=new checkOut();
    public ArrayList<iteam> orderIteam=new ArrayList<>();
    String feedback;



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
        if (iteam.size()!=0&&userName.length()!=0) {
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
                System.out.println("there is a Report About All order");
                double totalOrderCost=(order1.totalOfOrder/2);
                System.out.println("order number 1:" + i + "\t" + "user who order" + order1.nameOfWhoOrder+"\t" + "the cost of this order="+totalOrderCost + "\t" +"the profit from this order="+ (order1.totalOfOrder-totalOrderCost));
                checkOut.detailOrder(order1.getOrderIteams());
                return true;
            }
        }
        setMsg("cannot generate report because there is no order");
        return false;
    }




}
