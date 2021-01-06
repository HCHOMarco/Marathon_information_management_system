import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
/**
 * @author Marco
 */
public class Register {
    /**
     * 判断账号与之前的账号是否重复
     * @param newAccount 新的账号
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @return 如果与之前的账号重复返回false否则返回true
     */
    private boolean isDuplicateAccount(String newAccount,Map<String,Contestant> contestantTreeMap,
                                      Map<String,Administrators> administratorsTreeMap){
        if(contestantTreeMap.containsKey(newAccount) || administratorsTreeMap.containsKey(newAccount)){
            System.out.println("Your account number already exists !");
            return true;
        }else{
            return false;
        }
    }

    /**
     * 创建新的账号
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     */
    public void registerAndCheck(Map<String,Contestant> contestantTreeMap,
                                 Map<String,Administrators> administratorsTreeMap,
                                 ArrayList<String>noticeList) throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the new account number : ");
        String newAccount = kb.next();
        System.out.println("Please enter the new password number : ");
        String newPassword = kb.next();

        while(isDuplicateAccount(newAccount,contestantTreeMap,administratorsTreeMap)){
            System.out.print("Please enter the new account number : ");
            newAccount = kb.next();
            System.out.print("Please enter the new password number : ");
            newPassword = kb.next();
        }

        System.out.println("Please complete your personal information:========================");
        System.out.print("Your name : ");
        String name = kb.next();
        System.out.print("Your sex : ");
        String sex = kb.next();
        System.out.print("Your age : ");
        int age = Integer.parseInt(kb.next());
        Contestant newUser = new Contestant(newAccount,newPassword,1,name,sex,age,1,0,0,0);
        contestantTreeMap.put(newAccount,newUser);
        System.out.println("Account registration successful !===============================");

        GetOrPutInformation getOrPutInformation = new GetOrPutInformation();
        getOrPutInformation.putInformation(contestantTreeMap,administratorsTreeMap,noticeList);
    }

}
