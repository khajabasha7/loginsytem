import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPasswords()
    {
        logininfo.put("khaja","munna");
        logininfo.put("phani","wild");
        logininfo.put("lavaya","lalu");
        logininfo.put("navya","kolisetty");
        logininfo.put("gowrish","123");
        
    }
    protected HashMap<String, String> getLogininfo() {
        return logininfo;
    }
}
