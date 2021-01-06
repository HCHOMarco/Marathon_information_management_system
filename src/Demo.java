import sun.java2d.loops.GeneralRenderer;

import java.util.*;

/**
 * 主函数
 * @author marco
 */

public class Demo {


    public final boolean isGoing = true;

    public static void main(String[] args) throws Exception {
        // 定义选手集、管理员集、通知链表
        Map<String,Contestant> contestantTreeMap = new TreeMap<String,Contestant>();
        Map<String,Administrators> administratorsTreeMap = new TreeMap<String,Administrators>();
        ArrayList<String> noticeList = new ArrayList<String>();

        //将信息分别读入到选手集与管理员集与通知链表中
        GetOrPutInformation readInformation = new GetOrPutInformation();
        readInformation.getInformation(contestantTreeMap,administratorsTreeMap,noticeList);

        System.out.println("Welcome to Marathon information management system!====================");
        System.out.println("Sign up or sign in ===================================================");
        System.out.println("0.Login");
        System.out.println("1.Register");

        // 进入选择阶段并检查输入格式是否合法
        Select select = new Select();
        if(select.loginOrRegister()==0){
            // 登录操作
            System.out.println("Please Login:====================================");
            Login login = new Login();
            String account=login.loginAndCheck(contestantTreeMap,administratorsTreeMap);

            // 根据不同的身份进行操作选择
            GoToOtherOperation goToOtherOperation = new GoToOtherOperation();
            int choice = goToOtherOperation.getOperation(account,contestantTreeMap,administratorsTreeMap);

            // 如果choice大于0说明是选手
            if(choice > 0){
                goToOtherOperation.doContestantOperations(choice,account,contestantTreeMap,administratorsTreeMap,noticeList);
                while(choice != 6){
                    goToOtherOperation = new GoToOtherOperation();
                    choice = goToOtherOperation.getOperation(account,contestantTreeMap,administratorsTreeMap);
                    goToOtherOperation.doContestantOperations(choice,account,contestantTreeMap,administratorsTreeMap,noticeList);
                }
            }else{
                goToOtherOperation.doAdminOperations(-choice,account,contestantTreeMap,administratorsTreeMap,noticeList);
                while(choice != -14){
                    goToOtherOperation = new GoToOtherOperation();
                    choice = goToOtherOperation.getOperation(account,contestantTreeMap,administratorsTreeMap);
                    goToOtherOperation.doAdminOperations(-choice,account,contestantTreeMap,administratorsTreeMap,noticeList);
                }
            }

        }else{
            // 注册操作
            System.out.println("Please Register:====================================");
            Register register = new Register();
            register.registerAndCheck(contestantTreeMap,administratorsTreeMap,noticeList);
        }
    }
}
