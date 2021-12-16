
package com.laowangdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
点菜的主程序
 */
public class dishAppUp {
    //准备一些菜品，展示

    //定义集合泛型，表示小店所有菜品
    static List<dish> dishList = new ArrayList<>();
    //用户已点菜集合
    static List<dish> userDishList = new ArrayList<>();

    public static  void main(String[] args){
        //初始化菜品
        initdish();
        //创建扫描对象，获取控制台输入的内容
        Scanner sin = new Scanner(System.in);
        while (true){
            showMeum();
            System.out.println("请输入编号");
            //获取内容 ，等待客户输入：阻塞的效果
            int num = sin.nextInt();
            switch (num){
                case 1:
                    while (true){
                        showDishMeum();
                        //用户选择输入
                        int idd = sin.nextInt();
//                        System.out.println(idd);
                        //判断
                        if (idd == 0){
                            break;
                        }
                        //从集合获取菜品name 1，2，3，4，5
                        //集合索引0，1，2，3，4
                        dish d = dishList.get(idd -1);
                        System.out.println("亲，您点了："+d.name);
                        userDishList.add(d);
                    }
                    break;
                case 2:
                    //展示已点
                    showPeopleDish();
                    break;
                case 3:
                    while (true){
                        //删减菜品
                        reduceDish();
                        //获取用户要删的菜品序号
                        int id = sin.nextInt();
                        if (id == 0){
                            break;
                        }
                        //根据序号找到原店菜单对应的菜品
                        dish dc = dishList.get(id - 1);
                        //在已点菜品集合中删掉
                        for (int i =0; i < userDishList.size();i ++) {
                            //从集合中读取菜品
                            dish sc = userDishList.get(i);
                            if (sc.id == dc.id){
                                userDishList.remove(sc);
                                System.out.println(dc.name+"菜，已退了");
                            }
                        }
                    }
                    break;
                case 4:
                    //买单
                    buy();
                    return;

            }

        }

//        System.out.println("输入的值：" + num);
    }
    //展示主菜单
    public static void showMeum(){
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("删减菜品\t\t 3");
        System.out.println("买单\t\t\t 4");
        System.out.println("---请根据序号选择服务----");
    }
    //展示小店菜单
    public static void showDishMeum(){
        System.out.println("----请您点菜----");
        //遍历集合
        for (int i =0; i < dishList.size();i ++){
            //从集合中读取菜品
            dish sc = dishList.get(i);
            System.out.println(sc.id+"\t"+sc.name+"\t"+ sc.price);
        }
        System.out.println("----输入序号点菜，按0返回上一级----");
    }

    //已点菜
    public static void showPeopleDish(){
        System.out.println("----您已点菜----");
        //遍历集合
        for (int i =0; i < userDishList.size();i ++){
            //从集合中读取菜品
            dish sc = userDishList.get(i);
            System.out.println(sc.id+"\t"+sc.name+"\t"+ sc.price);
        }
    }
    //已点菜，选择删除
    public static void reduceDish(){
        //遍历集合
        showPeopleDish();
        System.out.println("----请输入你菜品序号删减,按0返回上一级----");
    }

    //买单
    public static void buy(){
        System.out.println("----请稍等，正在结算----");
        //计算总金额
        double total = 0;
        //遍历已点菜单
        for (dish dish:userDishList){
            total += dish.price;
        }
        System.out.println("亲。您本次共消费了："+total+"元");
    }
    //菜品
    public static void initdish(){
        dish dh = new dish(1,"香辣肉丝",21.0);
        dishList.add(dh);
        dish dh2 = new dish(2,"香辣腐竹",19.0);
        dishList.add(dh2);
        //存放菜品
        dishList.add(new dish(3,"红烧肉",35.0));
        dishList.add(new dish(4,"帝王王八",50.0));
        dishList.add(new dish(5,"虾蟹一锅焖",88.8));
//        dish dh3 = new dish(3,"红烧肉",35.0);
//        dish dh4 = new dish(4,"帝王王八",50.0);
//        dish dh5 = new dish(5,"虾蟹一锅焖",88.8);
    }


}
