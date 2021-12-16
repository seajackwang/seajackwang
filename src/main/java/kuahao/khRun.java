package kuahao;

import java.util.Scanner;

public class khRun {

    public static void main(String[] args){
        kh A = new kh();
        Scanner Sin = new Scanner(System.in);
        System.out.println("请输入：");
        String S = Sin.nextLine();
        System.out.println(S);
//        System.out.println(S.length());
        int bb = A.scoreOfParentheses(S);  //返回输入的（） 的得分
//        System.out.println(A.scoreOfParentheses(S));
        String ss = "(((123)))";
        int aa = A.F(ss,0,ss.length());
//        int bb = A.F(S,0,S.length());
        System.out.println(aa+","+ bb);
    }



}

