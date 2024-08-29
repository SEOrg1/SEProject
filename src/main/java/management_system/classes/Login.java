package management_system.classes;


import java.util.List;

import static management_system.classes.User.users;

public class Login {
    public final List<User> usersr;
    public String msg;

    public Login(List<User> users){
        this.usersr = users;

    }
    public boolean checkForLogIn(String userName,String password){
      if (userName.isEmpty() || password.isEmpty()){
          setMsg("Login Failed");
          return true;
      }
      for (User user : users){
          if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
              setMsg("Login Successful");
              return true;
          }
      }
      setMsg("Login Failed");
      return false;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
