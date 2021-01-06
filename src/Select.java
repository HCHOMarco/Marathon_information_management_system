/**
 * 进行登录或者注册时的检擦
 * @author Marco
 */

import java.util.Scanner;
public class Select {
    /**
     *检擦输入格式是否正确
     * @param input 输入的内容
     * @return 是否正确
     */
    private boolean inputRight(String input){
        if(input.length()!=1) {
            return false;
        }else{
            if(Character.isDigit(input.charAt(0))){
                int intInput = Integer.parseInt(input);
                return intInput == 0 || intInput == 1;
            }else{
                return false;
            }
        }

    }

    /**
     * 判断登录还是注册
     * @return 登录或者注册
     */
    public int loginOrRegister(){
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        while(!inputRight(input)){
            System.out.println("Please enter the correct format ！");
            input = kb.next();
        }

        if(Integer.parseInt(input)==1) {
            return 1;
        } else {
            return 0;
        }
    }
}
