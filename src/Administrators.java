import java.util.Scanner;

/**
 * @author Marco
 * 管理员的定义
 */

public class Administrators extends Person{

    // 报名比赛是否截止1为未截止0为截止
    private int isGoing;

    /**
     * 初始化
     * @param account 账号
     * @param password 密码
     * @param isContestant 是否是选手
     * @param name 姓名
     * @param sex 性别
     * @param age 年龄
     * @param isGoing 比赛报名是否截止
     */
    public Administrators(String account,String password,int isContestant,String name,String sex,int age,int isGoing) {
        super(account,password,isContestant,name, sex, age);
        this.isGoing=isGoing;
    }

    /**
     *获取是否可以报名的状态
     * @return 报名是否结束
     */
    public int getIsGoing(){return isGoing;}

    /**
     * 设置是否可以报名的状态
     * @param isGoing 报名状态
     */
    public void setIsGoing(int isGoing){this.isGoing=isGoing;}

    /**
     * 检查输入格式是否符合要求
     * @param input 输入的内容
     * @return 是否合法
     */
    private boolean checkFormat(String input){
        if(input.length()!=1 && input.length()!=2){
            return false;
        }
        if(input.length()==1){
            if(Character.isDigit(input.charAt(0)) ){
                int intInput = Integer.parseInt(input);
                return intInput >= 1 && intInput <= 9;
            }else{
                return false;
            }
        } else{
            if(Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1))){
                int intInput = Integer.parseInt(input);
                return intInput >=10 && intInput <=14;
            }else{
                return false;
            }
        }
    }

    /**
     * 重写showOperationsAndSelect函数，来表示管理员的可选操作以及所作的操作
     * @return 选择的操作
     */
    @Override
    public int showOperationsAndSelect(){
        System.out.println("\nPlease enter your choice ============================================");
        // 审批
        System.out.println("1.Approval of application");
        // 一键通过
        System.out.println("2.approvalOfAllApplication");
        // 获取选手信息
        System.out.println("3.Query contestant information");
        // 禁用选手账户
        System.out.println("4.Disable contestant account");
        // 解禁选手账户
        System.out.println("5.Unblocked account");
        // 重置选手密码
        System.out.println("6.Reset contestant password");
        // 启停比赛报名申请
        System.out.println("7.Start and stop registration activities");
        // 查看和统计赛事报名情况
        System.out.println("8.Check and count the registration of events");
        // 可录入比赛成绩
        System.out.println("9.Enter the competition results");
        // 查询运动员的比赛成绩和排名
        System.out.println("10.Query the results and ranking of athletes");
        // 所有运动员成绩的排行榜
        System.out.println("11.Final rank");
        // 发布通知
        System.out.println("12.Deliver an announcement");
        // 查看公告
        System.out.println("13.View announcements");
        // 退出
        System.out.println("14.Exit\n");

        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        while(!checkFormat(input)){
            System.out.println("Please enter the correct format ！");
            input = kb.next();
        }
        return Integer.parseInt(input);
    }

}
