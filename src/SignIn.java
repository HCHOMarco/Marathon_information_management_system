import java.util.Map;

/**
 * 登录操作
 * @author Marco
 */
public class SignIn {
    /**
     * 输入是否正确
     * @param isContestant 是否正确
     * @return 是否正确
     */
    public boolean isInputRight(int isContestant){
        return isContestant == 0 || isContestant == 1;
    }

    /**
     * 判断账户是否存在并判断密码是否正确
     * @param account 账号
     * @param password 密码
     * @param isContestant 是否是选手
     * @param contestantMap 选手集
     * @param administratorsMap 管理员集
     * @return 是否正确
     */
    public boolean doesTheAccountRight(String account, String password, int isContestant,
                                       Map<String,Contestant> contestantMap,Map<String,Administrators> administratorsMap){
        if(isContestant == 1){
            if(!contestantMap.containsKey(account)){
                System.out.println("Account does not exist or input error ! Please re-enter ");
                return false;
            }else{
                Contestant man = contestantMap.get(account);
                if(man.getPassword().equals(password)){
                    if(man.getIsLegal()==1){
                        System.out.println("Login successful !");
                        System.out.println("Welcome "+man.getName());
                        return true;
                    }else{
                        System.out.println("Your account has been blocked by the administrator");
                        return false;
                    }
                }else{
                    System.out.println("Wrong password ! Please re-enter");
                    return false;
                }
            }
        }else {
            if(!administratorsMap.containsKey(account)){
                System.out.println("Account does not exist or input error ! Please re-enter");
                return false;
            }else{
                Administrators man = administratorsMap.get(account);
                if(man.getPassword().equals(password)){
                    System.out.println("Login successful !");
                    System.out.println("Welcome "+man.getName());
                    return true;
                }else{
                    System.out.println("Wrong password ! Please re-enter");
                    return false;
                }
            }
        }
    }
}
