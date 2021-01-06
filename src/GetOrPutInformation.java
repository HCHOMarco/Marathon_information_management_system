import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;

/**
 * 进行内容的读取和存储模拟数据库
 * @author Marco
 */
public class GetOrPutInformation {
    /**
     * 从文件中读取已经存储的内容
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @param noticeList 信息链表
     * @throws FileNotFoundException 是否找到文件
     */
    public void getInformation(Map<String,Contestant> contestantTreeMap,
                               Map<String,Administrators> administratorsTreeMap,
                               ArrayList<String> noticeList) throws FileNotFoundException {
        File information = new File("library.txt");
        Scanner input = new Scanner(information);

        while(input.hasNext()){
            String account = input.next();
            String password = input.next();
            int isContestant = Integer.parseInt(input.next());
            String name = input.next();
            String sex = input.next();
            int age =Integer.parseInt(input.next());
            int isLegal = Integer.parseInt(input.next());
            int isSignUp = Integer.parseInt(input.next());
            int mark = Integer.parseInt(input.next());
            int rank = Integer.parseInt(input.next());

            if(isContestant == 1){
                Contestant contestant = new Contestant(account,password,isContestant,name,
                        sex,age,isLegal,isSignUp,mark,rank);
                contestantTreeMap.put(account,contestant);

            }else{
                // 管理员的isLegal用来判断报名是否结束为0则结束
                Administrators administrators = new Administrators(account,password,isContestant,name,sex,age,isLegal);
                administratorsTreeMap.put(account,administrators);
            }
        }

        input.close();

        File noticeFile = new File("notice.txt");
        Scanner noticeInput = new Scanner(noticeFile);
        while(noticeInput.hasNext()){
            String notice = noticeInput.next();
            noticeList.add(notice);
        }
        noticeInput.close();
    }

    /**
     * 存储信息回文件
     * @param contestantTreeMap 选手集
     * @param administratorsTreeMap 管理员集
     * @param noticeList 信息链表
     * @throws FileNotFoundException 是否找到文件
     */
    public void putInformation(Map<String,Contestant> contestantTreeMap,
                               Map<String,Administrators> administratorsTreeMap,
                               ArrayList<String> noticeList) throws FileNotFoundException {

        File file = new File("library.txt");
        PrintWriter output = new PrintWriter(file);

        Iterator iter = contestantTreeMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            output.print(((Contestant)entry.getValue()).getAccount()+ " ");
            output.print(((Contestant)entry.getValue()).getPassword()+ " ");
            output.print(((Contestant)entry.getValue()).getIsContestant()+ " ");
            output.print(((Contestant)entry.getValue()).getName()+ " ");
            output.print(((Contestant)entry.getValue()).getSex()+ " ");
            output.print(((Contestant)entry.getValue()).getAge()+ " ");
            output.print(((Contestant)entry.getValue()).getIsLegal()+ " ");
            output.print(((Contestant)entry.getValue()).getIsSignUp()+ " ");
            output.print(((Contestant)entry.getValue()).getMark()+ " ");
            output.println(((Contestant)entry.getValue()).getRanking());
        }

        Iterator iter2 = administratorsTreeMap.entrySet().iterator();
        while(iter2.hasNext()){
            Map.Entry entry = (Map.Entry)iter2.next();
            output.print(((Administrators)entry.getValue()).getAccount()+ " ");
            output.print(((Administrators)entry.getValue()).getPassword()+ " ");
            output.print(((Administrators)entry.getValue()).getIsContestant()+ " ");
            output.print(((Administrators)entry.getValue()).getName()+ " ");
            output.print(((Administrators)entry.getValue()).getSex()+ " ");
            output.print(((Administrators)entry.getValue()).getAge()+ " ");
            output.print(((Administrators)entry.getValue()).getIsGoing()+ " ");
            output.println("0 0 0");
        }

        output.close();

        File noticeFile = new File("notice.txt");
        PrintWriter noticeOutput = new PrintWriter(noticeFile);
        for(String o :noticeList){
            noticeOutput.print(o);
        }
        noticeOutput.close();
    }
}
