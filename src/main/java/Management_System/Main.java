package Management_System;
import Management_System.Classes.login;
import Management_System.Classes.signUp;
import Management_System.Classes.user;
import Management_System.Classes.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;
import static Management_System.Classes.iteam.iteams;
import static Management_System.Classes.order.orders;
import static Management_System.Classes.supplierProduct.supplierProducts;
import static Management_System.Classes.user.users;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);


        user u1 = new user("admin", "admin@gmail.com", "123", "admin");
        user u2 = new user("abdulhamid", "abdulhamid@gmail.com", "123456789", "user");
        user u3 = new user("ali", "ali@gmail.com", "147258369", "store owner");
        user u4 = new user("ahmad", "ahmad@gmail.com", "369258147", "supplier");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        user user = new user();
        login login = new login(users);
        signUp signUp = new signUp(users);
        Scanner scanner = new Scanner(System.in);
        iteam iteam1 = new iteam("nutellaCakae", 50);
        iteam iteam2 = new iteam("clasicaCakae", 30);
        iteam iteam3 = new iteam("pistashioaCakae", 40);
        iteam iteam4 = new iteam("beantbuterCakae", 70);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
        iteams.add(iteam4);
        iteam iteam = new iteam();
        order orderr = new order();
        supplierProduct supplierProduct = new supplierProduct();
        supplierProduct s1 = new supplierProduct("ahmad", "nutella", 50);
        supplierProduct s2 = new supplierProduct("ahmad", "nuts", 30);
        supplierProducts.add(s1);
        supplierProducts.add(s2);
        String phoneNumber = "";
        checkOut checkOut = new checkOut();
        double totalOrder = 0.0;
        ArrayList<iteam> orderItems = new ArrayList<>();
        String email;
        String username;
        String password;
        String role;
        String address = "";
        email = "abdulhamid@gmail.com";

        while (true) {
            logger.info("Welcome to our cake store ");
            logger.info("1-for sign in");
            logger.info("2-for sign up");
            logger.info("0-for Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    logger.info("Welcome to the Sign-In System");
                    logger.info("Enter username:");
                    username = scanner.nextLine();
                    logger.info("Enter password:");
                    password = scanner.nextLine();
                    if (login.checkForLogIn(username, password)) {
                        user loger = user.getUser(username);
                        if (loger.getRole().equals("user")) {
                            logger.info(login.getMsg());
                            logger.info("");
                            logger.info("this is our menu:");
                            checkOut.detailOrder(iteams);
                            logger.info("Choose what do you want to order (if you want to stop just type 'end')?");
                            while (true) {
                                String order = scanner.nextLine();
                                if (order.equals("end")) {
                                    if (checkOut.isValidCheckOut(orderItems)) {
                                        logger.info("Enter your delivery information");
                                        logger.info("Your address: ");
                                        address = scanner.nextLine();
                                        logger.info("Your phone number: ");
                                        phoneNumber = scanner.nextLine();
                                        logger.info("This is your order:");
                                        checkOut.printOrderDetail(orderItems, username, address, email, phoneNumber, totalOrder);
                                        orderr.addOrder(orderItems, username);
                                        logger.info(checkOut.getMsg());
                                        logger.info("Enter your feedback:");
                                        String feedback = scanner.nextLine();
                                        if (orderr.addOrderFeedback(feedback)) {
                                            logger.info(orderr.getMsg());
                                        } else {
                                            logger.info(orderr.getMsg());
                                        }
                                        break;
                                    }
                                } else {
                                    int orderNum = Integer.parseInt(order);
                                    orderItems.add(iteams.get(orderNum - 1));
                                    totalOrder += iteams.get(orderNum - 1).getPrice();
                                }
                            }
                        } else if (loger.getRole().equals("admin")) {
                            logger.info("Welcome admin");
                            logger.info("What do you want to do");
                            logger.info("1-delete dessert");
                            logger.info("2-show orders");
                            logger.info("3-delete user");
                            logger.info("4-update dessert");
                            logger.info("5-update user");
                            logger.info("6-delete supplier product");
                            logger.info("7-report about order");
                            int choice2 = scanner.nextInt();
                            switch (choice2) {
                                case 1:
                                    logger.info("Delete dessert");
                                    scanner.nextLine();
                                    logger.info("Enter the dessert name you want to delete:");
                                    String name = scanner.nextLine();
                                    if (iteam.removeItam(name)) {
                                        logger.info(iteam.getMsg());
                                        checkOut.detailOrder(iteams);
                                    } else
                                        logger.info(iteam.getMsg());
                                    break;
                                case 2:
                                    logger.info("Orders");
                                    checkOut.printOrderDetail(orderItems, username, address, email, phoneNumber, totalOrder);
                                    break;
                                case 3:
                                    logger.info("Welcome to the delete user page");
                                    scanner.nextLine();
                                    logger.info("Enter the username you want to delete: ");
                                    String userWantToDelete = scanner.nextLine();
                                    logger.info(userWantToDelete);
                                    if (user.deleteUser(userWantToDelete)) {
                                        logger.info(user.getMsg());
                                    } else {
                                        logger.info(user.getMsg());
                                    }
                                    break;
                                case 4:
                                    logger.info("Welcome to the update dessert page");
                                    scanner.nextLine();
                                    logger.info("Enter the name of dessert you want to update: ");
                                    String nameOfDessertWantToUpdate = scanner.nextLine();
                                    if (iteam.cheakIteam(nameOfDessertWantToUpdate)) {
                                        logger.info(iteam.getMsg());
                                        logger.info("");
                                        checkOut.detailOrder(iteams);
                                        logger.info("");
                                        logger.info("Enter the new value you want to update: ");
                                        logger.info("Enter new name of dessert: ");
                                        String newNameOfDessert = scanner.nextLine();
                                        logger.info("Enter new description of dessert:");
                                        String newDescOfDessert = scanner.nextLine();
                                        logger.info("Enter new dessert price: ");
                                        Double newPriceOfDessert = scanner.nextDouble();
                                        if (iteam.updateIteam(nameOfDessertWantToUpdate, newNameOfDessert, newDescOfDessert, newPriceOfDessert)) {
                                            checkOut.detailOrder(iteams);
                                            logger.info(iteam.getMsg());
                                        } else {
                                            logger.info(iteam.getMsg());
                                        }
                                    } else {
                                        logger.info(iteam.getMsg());
                                    }
                                    break;
                                case 5:
                                    logger.info("Welcome to the update user page");
                                    scanner.nextLine();
                                    logger.info("Enter the name of the user you want to update: ");
                                    String nameOfUserWantToUpdate = scanner.nextLine();
                                    if (user.checkUser(nameOfUserWantToUpdate)) {
                                        logger.info(user.getMsg());
                                        logger.info("Enter the new value you want to update: ");
                                        logger.info("Enter new name of user: ");
                                        String newNameOfUser = scanner.nextLine();
                                        logger.info("Enter new email of user: ");
                                        String newEmailOfUser = scanner.nextLine();
                                        logger.info("Enter the new password of user:");
                                        String newPasswordOfUser = scanner.nextLine();
                                        logger.info("Enter new role of user:");
                                        String newRoleOfUser = scanner.nextLine();
                                        if (user.updateUser(nameOfUserWantToUpdate, newNameOfUser, newEmailOfUser, newPasswordOfUser, newRoleOfUser)) {
                                            logger.info(user.getMsg());
                                        } else {
                                            logger.info(user.getMsg());
                                            break;
                                        }
                                    } else {
                                        logger.info(user.getMsg());
                                        break;
                                    }

                                case 6:
                                    logger.info("Welcome to the delete supplier product page");
                                    scanner.nextLine();
                                    logger.info("Enter the name of the supplier product you want to delete:");
                                    String nameOfSupplierProductWantToDelete = scanner.nextLine();
                                    if (supplierProduct.deleteSupplierProduct(nameOfSupplierProductWantToDelete)) {
                                        logger.info(supplierProduct.getMsg());
                                    } else {
                                        logger.info(supplierProduct.getMsg());
                                    }
                                    break;
                                case 7:
                                    logger.info("Welcome to the report page");
                                    if (orderr.printReportOrder(orders)) {
                                        break;
                                    } else {
                                        logger.info(orderr.getMsg());
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } else if (loger.getRole().equals("store owner")) {
                            logger.info("Welcome to the store owner page");
                            logger.info("Add dessert");
                            logger.info("Enter your dessert name:");
                            String dessertName = scanner.nextLine();
                            logger.info("");
                            logger.info("Enter your dessert price:");
                            double dessertPrice = scanner.nextDouble();
                            scanner.nextLine();
                            logger.info("");
                            logger.info("Enter your dessert description:");
                            String dessertDesc = scanner.nextLine();
                            if (iteam.addIteam(dessertName, dessertDesc, dessertPrice)) {
                                logger.info(iteam.getMsg());
                                checkOut.detailOrder(iteams);
                                return;
                            } else
                                logger.info(iteam.getMsg());
                            return;
                        } else if (loger.getRole().equals("supplier")) {
                            logger.info("Welcome to the supplier page");
                            logger.info("Enter the name of the product you want to add:");
                            String productName = scanner.nextLine();
                            logger.info("Enter the price of the product you want to add:");
                            Double productPrice = scanner.nextDouble();
                            if (supplierProduct.addSupplierProduct(loger.getUserName(), productName, productPrice)) {
                                logger.info(supplierProduct.getMsg());
                            } else {
                                logger.info(supplierProduct.getMsg());
                            }
                        }
                    } else
                        logger.info(login.getMsg());
                    break;
                case 2:
                    logger.info("Welcome to the Sign-Up page");
                    logger.info("Enter email: ");
                    email = scanner.nextLine();
                    signUp.existingEmail(email);
                    logger.info("Enter username: ");
                    username = scanner.nextLine();
                    logger.info("Enter role (only: user, supplier, or admin): ");
                    role = scanner.nextLine();
                    logger.info("Enter password: ");
                    password = scanner.nextLine();
                    signUp.register(username, email, password, role);
                    logger.info(signUp.getMsg());
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
    }
    static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + "\n";
        }
    }
}
