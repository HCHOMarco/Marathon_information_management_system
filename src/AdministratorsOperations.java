import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Marco
 * 管理员的操作函数封装体
 */
public class AdministratorsOperations {
    /**
     * 通过所有申请
     * @param contestantMap 选手集
     */
    public void approvalOfAllApplication(Map<String,Contestant>contestantMap){
        Iterator iter = contestantMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            if(((Contestant)entry.getValue()).getIsSignUp()==-1){
                ((Contestant)entry.getValue()).setIsSignUp(1);
            }
        }
        System.out.println("Operation successful !");
    }

    /**
     * 根据输入的账号单个进行审批
     * @param contestantMap 选手集
     */
    public void selectApprovalOfApplication(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        contestantMap.get(account).setIsSignUp(1);
        System.out.println("Operation successful !");
    }

    /**
     * 展现所有选手的信息
     * @param contestantMap 选手集
     */
    public void showAllContestInformation(Map<String,Contestant>contestantMap){
        Iterator iter = contestantMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.print("Account : "+entry.getKey()+ " ");
            System.out.print("Name : "+((Contestant)entry.getValue()).getName()+ " ");
            System.out.print("Sex : "+((Contestant)entry.getValue()).getSex()+ " ");
            System.out.print("Age : "+((Contestant)entry.getValue()).getAge()+ " ");
            System.out.print("IsLegal : "+((Contestant)entry.getValue()).getIsLegal()+ " ");
            System.out.print("IsSignUp : "+((Contestant)entry.getValue()).getIsSignUp()+ " ");
            System.out.print("Mark : "+((Contestant)entry.getValue()).getMark()+ " ");
            System.out.println("Ranking : "+((Contestant)entry.getValue()).getRanking());
        }
        System.out.println("Operation successful !");
    }

    /**
     * 禁用某个账号
     * @param contestantMap 选手集
     */
    public void disableContestantAccount(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        (contestantMap.get(account)).setIsLegal(0);
        System.out.println("Operation successful !");
    }

    /**
     * 解禁某个账号
     * @param contestantMap 选手集
     */
    public void unblockedAccount(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        (contestantMap.get(account)).setIsLegal(1);
        System.out.println("Operation successful !");
    }

    /**
     * 重置某个选手的密码
     * @param contestantMap 选手集
     */
    public void resetContestantPassword(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        System.out.println("Please enter a new password : ");
        String newAccount = kb.next();
        (contestantMap.get(account)).setPassword(newAccount);
        System.out.println("Operation successful !");
    }

    /**
     * 用来开启或者截止比赛报名
     * @param account 管理员的账号
     * @param administratorsMap 管理员集
     */
    public void startAndStopRegistrationActivities(String account,Map<String,Administrators>administratorsMap){
        Administrators admin = administratorsMap.get(account);
        int tmpIsGoing = 1;
        if(admin.getIsGoing()==1){
            System.out.println("The operation is successful. The registration has been closed !");
            tmpIsGoing = 0;
        }else{
            System.out.println("The operation is successful. The registration has been opened !");
            tmpIsGoing = 1;
        }

        Iterator iter = administratorsMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            ((Administrators)entry.getValue()).setIsGoing(tmpIsGoing);
        }
    }

    /**
     * 展现所有报名成功选手的信息
     * @param contestantMap 选手集
     */
    public void checkAndCountTheRegistrationOfEvents(Map<String,Contestant>contestantMap){
        int sumOfApplication = 0;
        Iterator iter = contestantMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            if(((Contestant)entry.getValue()).getIsSignUp()==1){
                sumOfApplication += 1;
                System.out.print("Account : "+entry.getKey()+ " ");
                System.out.print("Name : "+((Contestant)entry.getValue()).getName()+ " ");
                System.out.print("Sex : "+((Contestant)entry.getValue()).getSex()+ " ");
                System.out.print("Age : "+((Contestant)entry.getValue()).getAge()+ " ");
                System.out.print("IsLegal : "+((Contestant)entry.getValue()).getIsLegal()+ " ");
                System.out.print("IsSignUp : "+((Contestant)entry.getValue()).getIsSignUp()+ " ");
                System.out.print("Mark : "+((Contestant)entry.getValue()).getMark()+ " ");
                System.out.println("Ranking : "+((Contestant)entry.getValue()).getRanking());
            }
        }
        System.out.println("The total number of applicants : "+sumOfApplication);
    }

    /**
     * 输入某个选手的成绩
     * @param contestantMap 选手集
     */
    public void enterTheCompetitionResults(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        System.out.println("Please enter the score : ");
        int mark = kb.nextInt();
        contestantMap.get(account).setMark(mark);
        System.out.println("Operation successful !");
    }

    /**
     * 查询某个选手的成绩和排名
     * @param contestantMap 选手集
     */
    public void queryTheResultsAndRankingOfAthletes(Map<String,Contestant>contestantMap){
        System.out.println("Please enter the player's account number : ");
        Scanner kb = new Scanner(System.in);
        String account = kb.next();
        while(!contestantMap.containsKey(account)){
            System.out.println("The user does not exist, please re-enter : ");
            account = kb.next();
        }
        System.out.println("The mark of "+contestantMap.get(account).getName()+" is "+contestantMap.get(account).getMark());
        System.out.println("The ranking of "+contestantMap.get(account).getName()+" is "+contestantMap.get(account).getRanking());
    }

    /**
     * 获取最后的排名情况
     * @param contestantMap 选手集
     */
    public void getFinalRank(Map<String,Contestant>contestantMap){
        SortContestantMark sortContestantMark = new SortContestantMark();
        List<Map.Entry<String,Contestant>> tmpRank = sortContestantMark.sortContestantMark(contestantMap);
        int rankNum=1;
        for(Map.Entry<String, Contestant> o :tmpRank){
            // 有成绩而且账号没有被封禁可以参加排名
            if(o.getValue().getMark()!=0 && o.getValue().getIsLegal()==1){
                System.out.println("No."+rankNum+" : "+o.getValue().getName());
                rankNum++;
            }
        }
    }

    /**
     * 发布公告
     * @param noticeList 信息链表
     */
    public void deliverAnAnnouncement(ArrayList<String> noticeList){
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter a new notification : ");
        String announcement = kb.nextLine();
        noticeList.add(announcement);
        System.out.println("Operation successful !");
    }

    /**
     * 获取公告内容
     * @param noticeList 信息链表
     */
    public void getNotification(ArrayList<String> noticeList){
        for(String o :noticeList){
            System.out.println(o);
        }
    }

    /**
     * 退出并更新内容
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集合
     * @param noticeList 信息链表
     * @throws FileNotFoundException 没有找到相应文件
     */
    public void exitNow(Map<String,Contestant> contestantTreeMap, Map<String,Administrators> administratorsTreeMap, ArrayList<String> noticeList) throws FileNotFoundException {
        GetOrPutInformation getOrPutInformation = new GetOrPutInformation();
        getOrPutInformation.putInformation(contestantTreeMap,administratorsTreeMap,noticeList);
        System.exit(0);
    }

}
