import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

/**
 * 根据所给的有效账号并判断是管理员还是选手
 * 做选手的操作
 * 做管理员的操作
 * @author Marco
 */
public class GoToOtherOperation {
    /**
     * 判断角色属性然后显示具体角色的操作
     * @param account 管理员或者选手的账号
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @return 正值代表选手的操作，负值代表管理员的操作
     */
    public int getOperation(String account, Map<String,Contestant> contestantTreeMap,
                            Map<String,Administrators> administratorsTreeMap){
        // 如果该用户是选手
        if(contestantTreeMap.containsKey(account)){
            Contestant contestant = contestantTreeMap.get(account);
            return contestant.showOperationsAndSelect();
        }else{
            Administrators administrators = administratorsTreeMap.get(account);
            return -1*administrators.showOperationsAndSelect();
        }
    }

    /**
     * 做选手的操作
     * @param choice 所作的选择
     * @param account 选手账号
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @param noticeList 信息链表
     * @throws FileNotFoundException 文件是否找到
     */
    public void doContestantOperations(int choice,String account,Map<String,Contestant> contestantTreeMap,
                                       Map<String,Administrators> administratorsTreeMap, ArrayList<String> noticeList)
                                        throws FileNotFoundException {
        ContestantOperations contestantOperations = new ContestantOperations();
        if(choice==1){
            contestantOperations.signUpCompetition(account,contestantTreeMap,administratorsTreeMap);
        }else if(choice ==2){
            contestantOperations.getMark(account,contestantTreeMap);
        }else if(choice ==3){
            contestantOperations.getRanking(account,contestantTreeMap);
        }else if(choice ==4){
            contestantOperations.getTopTenRank(contestantTreeMap);
        } else if(choice ==5){
            contestantOperations.getNotification(noticeList);
        }else if(choice ==6){
            contestantOperations.exitNow(contestantTreeMap,administratorsTreeMap,noticeList);
        }
    }

    /**
     * 做管理员的操作
     * @param choice 管理员所作的操作是负值
     * @param adminAccount 管理员账号
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @param noticeList 信息链表
     * @throws FileNotFoundException 文件是否找到
     */
    public void doAdminOperations(int choice,String adminAccount,Map<String,Contestant> contestantTreeMap,
                                  Map<String,Administrators> administratorsTreeMap, ArrayList<String> noticeList)
            throws FileNotFoundException {
        AdministratorsOperations administratorsOperations = new AdministratorsOperations();
        if(choice == 1){
            administratorsOperations.selectApprovalOfApplication(contestantTreeMap);
        }else if(choice == 2){
            administratorsOperations.approvalOfAllApplication(contestantTreeMap);
        }else if(choice == 3){
            administratorsOperations.queryTheResultsAndRankingOfAthletes(contestantTreeMap);
        }else if(choice == 4){
            administratorsOperations.disableContestantAccount(contestantTreeMap);
        }else if(choice == 5){
            administratorsOperations.unblockedAccount(contestantTreeMap);
        }else if(choice == 6){
            administratorsOperations.resetContestantPassword(contestantTreeMap);
        }else if(choice == 7){
            administratorsOperations.startAndStopRegistrationActivities(adminAccount,administratorsTreeMap);
        }else if(choice == 8){
            administratorsOperations.checkAndCountTheRegistrationOfEvents(contestantTreeMap);
        }else if(choice == 9){
            administratorsOperations.enterTheCompetitionResults(contestantTreeMap);
        }else if(choice == 10){
            administratorsOperations.queryTheResultsAndRankingOfAthletes(contestantTreeMap);
        }else if(choice == 11){
            administratorsOperations.getFinalRank(contestantTreeMap);
        }else if(choice == 12){
            administratorsOperations.deliverAnAnnouncement(noticeList);
        }else if(choice == 13){
            administratorsOperations.getNotification(noticeList);
        }else if(choice == 14){
            administratorsOperations.exitNow(contestantTreeMap,administratorsTreeMap,noticeList);
        }
    }

}
