package custom_anonation;

public class LoginController {
    @LoginValid(value = "123")
    public void LoginWithSession(String session){
        System.out.println("session = " + session);
    }
}
