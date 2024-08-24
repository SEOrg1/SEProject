package Management_System.Classes;

import java.io.Serial;
import java.util.ArrayList;

public class user {

    public  String userName;
    public  String email;
    public  String password;
    public String role;
    public static ArrayList<user> users =new ArrayList<>();
    public String msg;

    public user(String username, String email, String password, String role) {
        this.userName = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public user() { }
    public  String getUserName() {
        return userName;
    }
    public String getMsg() {
        return msg;
    }
    public boolean checkUser(String userName){
        for(user user:users){
            if(user.getUserName().equals(userName)){
                msg="user has been founded successfully";
                return true;
            }
        }
        msg="cant update because missing name or non existent user";
        return false;
    }
    public boolean updateUser(String oldName,String newName,String newEmail,String newPassword,String newRole){
        user updateUser=getUser(oldName);
        if(updateUser!=null){
            updateUser.setUserName(newName);
            updateUser.setEmail(newEmail);
            updateUser.setPassword(newPassword);
            updateUser.setRole(newRole);
            msg="user information has been updated successfully";
            return true;
        }else {
            msg="cant update because missing name or non existent user";
            return false;
        }
    }
    public user getUser(String username){
        for(user user : users){
            if(user.getUserName().equals(username)){
                msg="user has been founded successfully";
                return user;
            }
        }
        msg="cant update because missing name or non existent user";
        return null;
    }
    public String getRole() {
        return role;
    }
    public boolean deleteUser(String userName){
        for(user user:users){
            if(user.userName.equals(userName)){
                users.remove(user);
                msg="old_user has been successfully deleted";
                return true;
            }
        }
        msg="cant delete because missing name or non-existent user";
        return false;
    }


    public  void setUserName(String userName) {
        this.userName = userName;
    }

    public  String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }
    public  void setRole(String Role) {
        this.role = Role;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }
}
