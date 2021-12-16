package mianshiTest;
import java.util.*;

public class diguiString {
    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();
        Scanner sin = new Scanner(System.in);
        System.out.println("请输入：");
        String str = sin.nextLine();
        if (str.length()==0)
//            return (ArrayList)resultList;
            System.out.println(resultList);
        fun(str.toCharArray(),resultList,0);
        Collections.sort(resultList);
//        return (ArrayList)resultList;
        System.out.println(resultList);

    }
    private static void fun(char[] ch, List<String> list, int i){
        if( i == ch.length -1){
//            System.out.println(ch.length -1);
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
//                System.out.println(list);
                return;
            }
        }else {
            for (int j=i;j<ch.length;j++){
                System.out.print(i+","+j + ";");
                swap(ch,i,j);
                fun(ch,list,i+1);
                swap(ch,i,j);
            }
        }
    }
    //交换数组的两个下标的元素
    private static void swap(char[] str, int i, int j){
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}

