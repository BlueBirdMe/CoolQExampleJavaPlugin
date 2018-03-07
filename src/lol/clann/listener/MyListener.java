/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lol.clann.listener;

import sdk.event.CoolQEventHandler;
import sdk.event.CoolQListener;
import sdk.event.asynchro.*;
import sdk.event.syncro.*;
import sdk.util.bean.BeanUtils;

/**
 *
 * @author zyp
 */
public class MyListener implements CoolQListener {

    @CoolQEventHandler
    public void onEvent(DiscussMessageEvent e) {
        System.out.println(e.getEventName());
        //回复相同消息,并@发送者
        e.replyMessage(e.getHandle().message, true);
    }

    @CoolQEventHandler
    public void onEvent(GroupMessageEvent e) {
        System.out.println(e.getEventName());
        //回复相同消息,并@发送者
        e.replyMessage(e.getHandle().message, true);
    }

    @CoolQEventHandler
    public void onEvent(NewFriendApplyEvent e) {
        System.out.println(e.getEventName());
        //拒绝好友申请
        e.refuse();
    }

    @CoolQEventHandler
    public void onEvent(NewGroupMemberApplyEvent e) {
        System.out.println(e.getEventName());
        //拒绝加群申请
        e.refuse("我讨厌你");
    }

    @CoolQEventHandler
    public void onEvent(PrivateMessageEvent e) {
        System.out.println(e.getEventName());
        //回复相同消息
        e.replyMessage(e.getHandle().message);
    }

    /**
     * 根据http-api描述,这个应该是登录QQ被邀请入群时触发才对,但我测试时并没有触发这个事件
     * 望大牛解答...
     *
     * @param e
     */
    @CoolQEventHandler
    public void onEvent(NewGroupInvitingEvent e) {
        System.out.println(e.getEventName());
        //拒绝
        e.refuse("拒绝");
    }

    @CoolQEventHandler
    public void onEvent(GroupFileUploadEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

    @CoolQEventHandler
    public void onEvent(GroupManagerChangeEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

    @CoolQEventHandler
    public void onEvent(GroupMemberDecreaseEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

    @CoolQEventHandler
    public void onEvent(GroupMemberIncreaseEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

    @CoolQEventHandler
    public void onEvent(KickedFromGroupEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

    @CoolQEventHandler
    public void onEvent(NewFriendEvent e) {
        System.out.println(e.getEventName() + ":" + BeanUtils.toString(e.getHandle()));
    }

}
