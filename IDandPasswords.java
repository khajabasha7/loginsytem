import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPasswords()
    {
        //logininfo.put("user","password");
        logininfo.put("khaja","munna");
        //you add few username and password
    }
    protected HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
