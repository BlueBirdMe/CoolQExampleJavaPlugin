/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lol.clann;

import java.util.LinkedList;
import lol.clann.bean.Man;
import lol.clann.bean.Person;
import lol.clann.bean.Woman;
import lol.clann.listener.MyListener;
import sdk.CoolQAPI;
import sdk.SDK;
import sdk.SDKInit;
import sdk.coolq.api.CoolQAPIFailException;
import sdk.event.CoolQEventManager;
import sdk.util.bean.BeanUtils;

/**
 *
 * @author zyp
 */
public class Main {

    /**
     * 项目入口
     *
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //初始化SDK
        SDK.init();
        //注册类
        registerBeanClass();
        //BeanUtils工具类演示
        beanTest();
        //注册监听器
        CoolQEventManager.getInstance().registerEvents(new MyListener());
        //API测试
        apiTest();
    }

    /**
     *
     * @throws CoolQAPIFailException API调用失败时抛出
     */
    private static void apiTest() throws CoolQAPIFailException {
        //向QQ66666发送消息
        CoolQAPI.sendPrivateMsg(66666, "hello");
        //向QQ群88888发送消息,并艾特QQ66666
        CoolQAPI.sendGroupMsg(88888, 66666, "hello");
        /**
         * 其余API就不演示了
         */
    }

    /**
     * 注册过的类才能被BeanUtils工具类处理
     */
    private static void registerBeanClass() {
        SDKInit.registerClass(Person.class);
        SDKInit.registerClass(Man.class);
        SDKInit.registerClass(Woman.class);
    }

    /**
     * BeanUtils工具类演示
     */
    private static void beanTest() throws Exception {
        Man man = new Man();
        man.name = "jack";
        man.friends = new LinkedList();
        man.friends.add("xiaoming");
        man.friends.add("xiaobai");
        man.friends.add("xiaohua");
        man.sex = "男";
        man.test = "useless";
        man.uuid = "6666666666";
        String info = BeanUtils.toString(man);
        System.out.println("man:" + info);
        Man newMan = (Man) BeanUtils.create(Person.class, info);
        String newInfo = BeanUtils.toString(newMan);
        System.out.println("newMan:" + newInfo);
    }

}
