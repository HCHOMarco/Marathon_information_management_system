import java.util.Map;
import java.util.Scanner;

/**
 * @author Marco
 */
public class Login {
    /**
     * 检查输入的格式是否正确
     * @param input 输入的内容
     * @return 是否正确
     */
    private boolean checkFormat(String input){
        if(input.length()!=1){
            return false;
        }
        if(Character.isDigit(input.charAt(0))){
            int intInput = Integer.parseInt(input);
            return intInput == 0 || intInput == 1;
        }else{
            return false;
        }
    }

    /**
     * 登录账号检查账号是否存在检查账号密码是否匹配
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集合
     * @return 返回登录的账号
     */
    public String loginAndCheck(Map<String,Contestant> contestantTreeMap,
                              Map<String,Administrators> administratorsTreeMap){
        Scanner kb = new Scanner(System.in);
        System.out.print("Account: ");
        String account = kb.next();
        System.out.print("Password: ");
        String password = kb.next();
        System.out.println("Please enter 0 or 1 to indicate that you are an administrator or a contestant :");
        String input = kb.next();
        while(!checkFormat(input)){
            System.out.println("Please enter the correct format ！");
            input = kb.next();
        }
        int isContestant=Integer.parseInt(input);
        SignIn signin = new SignIn();

        //判断身份选择是否正确
        while(!signin.isInputRight(isContestant)){
            System.out.println("Please enter 0 or 1 to indicate that you are an administrator or a contestant :");
            isContestant = Integer.parseInt(kb.next());
        }

        //判断账号密码是否正确
        while(!signin.doesTheAccountRight(account,password,isContestant,contestantTreeMap,administratorsTreeMap)){
            System.out.print("Account: ");
            account = kb.next();
            System.out.print("Password: ");
            password = kb.next();
            System.out.println("Please enter 0 or 1 to indicate that you are an administrator or a contestant :");
            isContestant = Integer.parseInt(kb.next());
            while(!signin.isInputRight(isContestant)){
                System.out.println("Please enter 0 or 1 to indicate that you are an administrator or a contestant :");
                isContestant = Integer.parseInt(kb.next());
            }
        }
        return account;
    }
}
