/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lol.clann.bean;

import java.util.List;
import sdk.util.bean.ComponentType;
import sdk.util.bean.FieldSelector;
import sdk.util.bean.Ignore;

/**
 *
 * @author zyp
 */
public abstract class Person {

    public String name;
    /**
     * 用ComponentType指明集合元素类型,支持Set,List,Map<String,Object>
     * Map键必须为String,值需要指明类型
     */
    @ComponentType(clazz = String.class)
    public List<String> friends;
    /**
     * 忽略
     */
    @Ignore
    public String uuid;
    /**
     * 根据该属性的值,自动选择相应的子类进行实例化
     */
    @FieldSelector(clazz = {Man.class, Woman.class}, value = {"男", "女"})
    public String sex;
}
