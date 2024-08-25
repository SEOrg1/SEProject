package management_system.classes;


import java.util.List;

public class login {
    public final List<user> users;
    public String msg;

    public login(List<user> users){
        this.users = users;

    }
    public boolean checkForLogIn(String userName,String password){
      if (userName.isEmpty() || password.isEmpty()){
          setMsg("Login Failed");
          return true;
      }
      for (user user : users){
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
