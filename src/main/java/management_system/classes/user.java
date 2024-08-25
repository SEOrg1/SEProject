package management_system.classes;


import java.util.ArrayList;

public class user {

    private  String userName;
    private   String email;
    private  String password;
    public String role;
    public static final ArrayList<user> users =new ArrayList<>();
    private String msg;
    private  String erorMsg="cant update because missing name or non existent user";

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
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean checkUser(String userName){
        for(user user:users){
            if(user.getUserName().equals(userName)){
                setMsg("user has been founded successfully");
                return true;
            }
        }
        setMsg(erorMsg);
        return false;
    }
    public boolean updateUser(String oldName,String newName,String newEmail,String newPassword,String newRole){
        user updateUser=getUser(oldName);
        if(updateUser!=null){
            updateUser.setUserName(newName);
            updateUser.setEmail(newEmail);
            updateUser.setPassword(newPassword);
            updateUser.setRole(newRole);
            setMsg("user information has been updated successfully");
            return true;
        }else {
            setMsg(erorMsg);
            return false;
        }
    }
    public user getUser(String username){
        for(user user : users){
            if(user.getUserName().equals(username)){
                setMsg("user has been founded successfully");
                return user;
            }
        }
        setMsg(erorMsg);
        return null;
    }
    public String getRole() {
        return role;
    }
    public boolean deleteUser(String userName){
        for(user user:users){
            if(user.userName.equals(userName)){
                users.remove(user);
                setMsg("old_user has been successfully deleted");
                return true;
            }
        }
        setMsg("cant delete because missing name or non-existent user");
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
    public  void setRole(String role) {
        this.role = role;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }
}
