package Management_System;

import Management_System.Classes.login;
import Management_System.Classes.signUp;
import Management_System.Classes.user;
import Management_System.Classes.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Management_System.Classes.iteam.iteams;
import static Management_System.Classes.order.orders;
import static Management_System.Classes.supplierProduct.supplierProducts;
import static Management_System.Classes.user.users;

public class Main {



    public static void main(String[] args) {

        user u1 =new user("admin","admin@gmail.com","123","admin");
        user u2 =new user("abdulhamid","abdulhamid@gmail.com","123456789","user");
        user u3 =new user("ali","ali@gmail.com","123456789","store owner");
        user u4 =new user("ahmad","ahmad@gmail.com","123456789","supplier");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        user user=new user();
        login login = new login(users);
        signUp signUp = new signUp(users);
        Scanner scanner = new Scanner(System.in);
        iteam iteam1=new iteam("nutellaCakae",50);
        iteam iteam2=new iteam("clasicaCakae",30);
        iteam iteam3=new iteam("pistashioaCakae",40);
        iteam iteam4=new iteam("beantbuterCakae",70);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
        iteams.add(iteam4);
        iteam iteam=new iteam();
        order orderr=new order();
        supplierProduct supplierProduct=new supplierProduct();
        supplierProduct s1 =new supplierProduct("ahmad","nutella",50);
        supplierProduct s2 =new supplierProduct("ahmad","nuts",30);
        supplierProducts.add(s1);
        supplierProducts.add(s2);
        String phoneNumber = "";
        checkOut checkOut = new checkOut();
        double totalOrder=0.0;
        ArrayList <iteam>orderItems=new ArrayList<>();
        String email;
        String username;
        String password;
        String role;
        String address = "";
        int i=1;
        email="abdulhamid@gmail.com";

        while (true){
        System.out.println("Welcom to our cake store ");
        System.out.println("1-for sign in");
        System.out.println("2-for sign up");
        System.out.println("0-for Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice) {
            case 1:
                System.out.println("Welcome to the Sign-In System");
                System.out.print("Enter username:");
                 username = scanner.nextLine();
                System.out.print("Enter password:");
                 password = scanner.nextLine();
                if(login.checkForLogIn(username, password)){
                    user loger=user.getUser(username);
                    if (loger.getRole().equals("user")){
                    System.out.println(login.getMsg());
                    System.out.println();
                    System.out.println("this is our menu:");
                    checkOut.detailOrder(iteams);
                    System.out.println("chose what do you want to order(if you whant to stop just type end)?");
                    while(true){
                        String order = scanner.nextLine();
                        if(order.equals("end")){
                            if (checkOut.isValidCheckOut(orderItems)){
                                System.out.println("enter your deleivery information");
                                System.out.print("your addres: ");
                                 address = scanner.nextLine();
                                System.out.print("your phone number: ");
                                 phoneNumber = scanner.nextLine();
                                System.out.println("this is your order:");
                                checkOut.printOrderDetail(orderItems,username,address,email,phoneNumber,totalOrder);
                                orderr.addOrder(orderItems,username);
                                System.out.println(checkOut.getMsg());
                                System.out.println("enter your feedback:");
                                String feedback=scanner.nextLine();
                                if (orderr.addOrderFeedback(feedback)){
                                    System.out.println(orderr.getMsg());
                                }else{
                                    System.out.println(orderr.getMsg());                                }
                                break;
                            }
                        }else{
                            int orderNum=Integer.parseInt(order);
                            orderItems.add(iteams.get(orderNum-1));
                            totalOrder += iteams.get(orderNum-1).getPrice();
                        }
                    }
                    }else if(loger.getRole().equals("admin")){
                        System.out.println("welcom admin");
                        System.out.println("what do you whant  to do");
                        System.out.println("1-delete dessert");
                        System.out.println("2-show orders");
                        System.out.println("3-delete user");
                        System.out.println("4-update dessert");
                        System.out.println("5-update user");
                        System.out.println("6-delete supplier product");
                        System.out.println("7-report about order");
                        int choice2 = scanner.nextInt();
                        switch(choice2) {
                            case 1:
                                System.out.println("delete dessert");
                                scanner.nextLine();
                                System.out.print("enter your dessert whant to delete name:");
                                String name = scanner.nextLine();
                                if (iteam.removeItam(name)){
                                    System.out.println(iteam.getMsg());
                                    checkOut.detailOrder(iteams);
                                }else
                                    System.out.println(iteam.getMsg());
                                break;
                            case 2:
                                System.out.println("Orders");
                                checkOut.printOrderDetail(orderItems,username,address,email,phoneNumber,totalOrder);
                                break;

                            case 3:
                                System.out.println("Welcome to the delete user page");
                                scanner.nextLine();
                                System.out.print("Enter the username you want to delete: ");
                                String userWantToDelete = scanner.nextLine();
                                System.out.println(userWantToDelete);
                                if(user.deleteUser(userWantToDelete)){
                                    System.out.println(user.getMsg());
                                }else{
                                    System.out.println(user.getMsg());
                                }
                                break;
                            case 4:
                                System.out.println("Welcome to the update dessert page");
                                scanner.nextLine();
                                System.out.print("Enter the name of dessert you want to update: ");
                                String nameOfDessertWantToUpdate =scanner.nextLine();
                                if (iteam.cheakIteam(nameOfDessertWantToUpdate)){
                                    System.out.println(iteam.getMsg());
                                    System.out.println();
                                    checkOut.detailOrder(iteams);
                                    System.out.println();
                                    System.out.println("enter the new value you want to update: ");
                                    System.out.print("enter new name of dessert: ");
                                    String newNameOfDessert = scanner.nextLine();
                                    System.out.print("enter new Desc of dessert:");
                                    String newDescOfDessert = scanner.nextLine();
                                    System.out.print("enter new Dessert price: ");
                                    Double newPriceOfDessert = scanner.nextDouble();
                                    if (iteam.updateIteam(nameOfDessertWantToUpdate,newNameOfDessert,newDescOfDessert,newPriceOfDessert)){
                                        checkOut.detailOrder(iteams);
                                        System.out.println(iteam.getMsg());
                                    }else{
                                        System.out.println(iteam.getMsg());
                                    }
                                }else{
                                    System.out.println(iteam.getMsg());
                                }
                                break;
                            case 5:
                                System.out.println("Welcome to the update user page");
                                scanner.nextLine();
                                System.out.print("Enter the name of user you want to update: ");
                                String nameOfUserWantToUpdate =scanner.nextLine();
                                if (user.checkUser(nameOfUserWantToUpdate)){
                                    System.out.println(user.getMsg());
                                    System.out.println("enter the new value you want to update: ");

                                    System.out.print("enter new name of user: ");
                                    String newNameOfUser = scanner.nextLine();

                                    System.out.print("enter new Email of user: ");
                                    String newEmailOfUser = scanner.nextLine();
                                    System.out.print("enter the new password of user:");
                                    String newPasswordOfUser = scanner.nextLine();
                                    System.out.print("enter new Role of user:");
                                    String newRoleOfUser = scanner.nextLine();
                                    if (user.updateUser(nameOfUserWantToUpdate,newNameOfUser,newEmailOfUser,newPasswordOfUser,newRoleOfUser)){
                                        System.out.println(user.getMsg());

                                    }else{
                                        System.out.println(user.getMsg());
                                    }
                                }else{
                                    System.out.println(user.getMsg());
                                }
                                case 6:
                                    System.out.println("Welcome to the delete supplier product page");
                                    scanner.nextLine();
                                    System.out.print("Enter the name of supplier product you want to delete:");
                                    String nameOfSupplierProductWantToDelete =scanner.nextLine();

                                    if (supplierProduct.deleteSupplierProduct(nameOfSupplierProductWantToDelete)){
                                        System.out.println(supplierProduct.getMsg());
                                    }else{
                                        System.out.println(supplierProduct.getMsg());
                                    }
                                break;
                            case 7:
                                System.out.println("welcom to report page");
                                if (orderr.printReportOrder(orders)){
                                    break;
                                }else {
                                    System.out.println(orderr.getMsg());
                                }
                                break;

                        }
                    }else if (loger.getRole().equals("store owner")){
                        System.out.println("welcom to store owner page");
                        System.out.println("add dessert");
                        System.out.print("enter your dessert name:");

                        String dessertName = scanner.nextLine();
                        System.out.println();
                        System.out.print("enter your dessert price:");
                        double dessertPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println();
                        System.out.print("enter your dessert desc:");
                        String dessertDesc = scanner.nextLine();
                        if(iteam.addIteam(dessertName,dessertDesc,dessertPrice)){
                            System.out.println(iteam.getMsg());
                            checkOut.detailOrder(iteams);
                            return;
                        }else
                            System.out.println(iteam.getMsg());
                        return;
                    } else if (loger.getRole().equals("supplier")) {
                        System.out.println("welcom to supplier page");
                        System.out.print("enter the name of product you want to add:");
                        String productName = scanner.nextLine();

                        System.out.print("enter the price of product you want to add:");
                        Double productPrice = scanner.nextDouble();
                        if (supplierProduct.addSupplierProduct(loger.getUserName(),productName,productPrice)){
                            System.out.println(supplierProduct.getMsg());
                        }else{
                            System.out.println(supplierProduct.getMsg());
                        }
                    }

                }else
                    System.out.println(login.getMsg());
                break;
                case 2:
                    System.out.println("Welcome to the Sign-Up page");
                    System.out.println("Enter Email: ");
                    email = scanner.nextLine();
                    signUp.existingEmail(email);
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter role(only:user supplier or admin): ");
                    role = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    signUp.register(username, email, password,role);
                    System.out.println(signUp.getMsg());
                break;
            case 0:
                System.exit(1);
                break;
        }


      }
    }
}