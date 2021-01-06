import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Marco
 */
public class ContestantOperations {
    public void signUpCompetition(String account, Map<String,Contestant> contestantTreeMap, Map<String,Administrators> administratorsTreeMap){

        Iterator iter = administratorsTreeMap.entrySet().iterator();
        Map.Entry entry = (Map.Entry)iter.next();
        if(((Administrators)entry.getValue()).getIsGoing()==0){
            System.out.println("Registration closed !");
            return;
        }

        if(contestantTreeMap.get(account).getIsSignUp() == -1){
            // 正在申请途中还未通过
            System.out.println("You have signed up, please wait for approval !");
        }else if(contestantTreeMap.get(account).getIsSignUp() == 0){
            // 还没有申请，现在开始申请
            contestantTreeMap.get(account).setIsSignUp(-1);
            System.out.println("You signed up successfully !");
            System.out.println("Please wait for successful registration !");
        }else if(contestantTreeMap.get(account).getIsSignUp() == 1){
            // 申请得到回应，审批通过
            System.out.println("You have successfully signed up for the competition. Please do not repeat your application");
        }else if(contestantTreeMap.get(account).getIsSignUp() == 2){
            // 你的申请被驳回
            System.out.println("Your application has been rejected");
        }
    }

    /**
     * 获取成绩
     * @param account 选手账号
     * @param contestantTreeMap 选手集合
     */
    public void getMark(String account, Map<String,Contestant> contestantTreeMap){
        if(contestantTreeMap.get(account).getIsSignUp()==0){
            System.out.println("You didn't sign up for the competition");
        }else if(contestantTreeMap.get(account).getMark()==0){
            System.out.println("Your score has not been entered yet");
        }else{
            System.out.println("Your mark : "+contestantTreeMap.get(account).getMark());
            System.out.println("Your ranking : "+contestantTreeMap.get(account).getRanking());
        }
    }

    /**
     * 获取排名
     * @param account 选手账号
     * @param contestantTreeMap 选手集
     */
    public void getRanking(String account, Map<String,Contestant> contestantTreeMap){
        if(contestantTreeMap.get(account).getIsSignUp()==0){
            System.out.println("You didn't sign up for the competition");
        } else if(contestantTreeMap.get(account).getMark()==0){
            System.out.println("Your score has not been entered yet");
        }else{
            SortContestantMark sortContestantMark = new SortContestantMark();
            List<Map.Entry<String,Contestant>> tmpRank = sortContestantMark.sortContestantMark(contestantTreeMap);
            int rankNum=1;
            for(Map.Entry<String, Contestant> o :tmpRank){
                // 有成绩而且账号没有被封禁可以参加排名同时获取自己的排名
                if(o.getValue().getMark()!=0 && o.getValue().getIsLegal()==1){
                    if(o.getKey().equals(account)) {
                        contestantTreeMap.get(account).setRanking(rankNum);
                    }
                    rankNum++;
                }
            }

            System.out.println("Your ranking : "+contestantTreeMap.get(account).getRanking());
        }
    }

    /**
     * 获取前十名的排名
     * @param contestantTreeMap 选手集
     */
    public void getTopTenRank(Map<String,Contestant> contestantTreeMap){
        SortContestantMark sortContestantMark = new SortContestantMark();
        List<Map.Entry<String,Contestant>> tmpRank = sortContestantMark.sortContestantMark(contestantTreeMap);
        int rankNum=1;
        for(Map.Entry<String, Contestant> o :tmpRank){
            // 有成绩而且账号没有被封禁可以参加排名
            if(o.getValue().getMark()!=0 && o.getValue().getIsLegal()==1){
                System.out.println("No."+rankNum+" : "+o.getValue().getName()+" "+o.getValue().getMark());
                rankNum++;
            }
            if(rankNum == 10){
                break;
            }
        }
    }

    /**
     * 获取公告
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
     * @param administratorsTreeMap 管理员集
     * @param noticeList 信息链表
     * @throws FileNotFoundException 是否找到文件
     */
    public void exitNow(Map<String,Contestant> contestantTreeMap, Map<String,Administrators> administratorsTreeMap, ArrayList<String> noticeList) throws FileNotFoundException {
        GetOrPutInformation getOrPutInformation = new GetOrPutInformation();
        getOrPutInformation.putInformation(contestantTreeMap,administratorsTreeMap,noticeList);
        System.exit(0);
    }
}
