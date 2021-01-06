import com.sun.org.apache.bcel.internal.generic.ISHL;
import java.net.SecureCacheResponse;
import java.util.Scanner;
/**
 * @author Marco
 * 选手的定义
 */

public class Contestant extends Person{
    private int isSignUp;
    private int mark;
    private int ranking;
    private int isLegal;
    public Contestant(String account,String password,int isContestant,String name,
                      String sex,int age,int isLegal,int isSignUp,int mark,int ranking) {
        super(account,password,isContestant,name, sex, age);
        this.isLegal = isLegal;
        this.isSignUp = isSignUp;
        this.mark = mark;
        this.ranking =ranking;
    }

    void setMark(int mark){
        this.mark=mark;
    }

    int getMark(){
        return this.mark;
    }

    void setRanking(int ranking){
        this.ranking=ranking;
    }

    int getRanking(){
        return this.ranking;
    }

    void setIsSignUp(int isSignUp){
        this.isSignUp=isSignUp;
    }

    int getIsLegal(){
        return isLegal;
    }

    void setIsLegal(int isLegal){
        this.isLegal=isLegal;
    }

    int getIsSignUp(){
        return isSignUp;
    }

    /**
     * 检查输入的格式是否正确
     * @param input 输入
     * @return 是否正确
     */
    private boolean checkFormat(String input){
        if(input.length()!=1){
            return false;
        }
        if(Character.isDigit(input.charAt(0))){
            int intInput = Integer.parseInt(input);
            return intInput >= 1 && intInput <= 6;
        }else{
            return false;
        }
    }

    /**
     * 重写showOperationsAndSelect展现选手可做的操作以及选择的操作
     * @return 选择的操作
     */
    @Override
    public int showOperationsAndSelect(){
        System.out.println("\nPlease enter your choice ============================================");
        // 报名参赛
        System.out.println("1.Sign up for competition");
        // 查询自己成绩
        System.out.println("2.Inquire about your grades");
        // 查询自己排名
        System.out.println("3.Query your own ranking");
        // 查询前十排名
        System.out.println("4.Query the top ten rankings");
        // 查看公告
        System.out.println("5.View announcements");
        // 退出
        System.out.println("6.Exit\n");

        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        while(!checkFormat(input)){
            System.out.println("Please enter the correct format ！");
            input = kb.next();
        }
        return Integer.parseInt(input);
    }


}
