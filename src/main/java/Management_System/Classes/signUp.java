package Management_System.Classes;

import java.util.List;

public class signUp {
    public final List <user> users;

    String msg;
    public signUp(List <user> users) {
        this.users = users;
    }
    public boolean existingEmail(String email) {
        for (user user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean register(String username, String email, String password,String role) {
        if (username==null||password==null||email==null){
            setMsg("Some Missing Fields");
            return false;
        }
        if(password.length()<8){
            setMsg("your password is too weak");
            return false;
        }
        if (existingEmail(email)){
            setMsg("Email Already Exists");
            return false;
        }
        user u1=new user(username,password,email,role);
        users.add(u1);
        setMsg("Registration Successful");
        return true;
    }

}
