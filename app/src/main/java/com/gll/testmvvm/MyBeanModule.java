package com.gll.testmvvm;

import java.util.List;

/**
 * User: highsixty
 * Date: 2020-02-25 11:31
 * email: gaolulin@sunmi.com
 */
public class MyBeanModule  {


    private List<MyBean> beans;


    public List<MyBean> getBeans() {
        return beans;
    }

//    @Bindable
    public void setBeans(List<MyBean> beans) {
        this.beans = beans;
//        notifyPropertyChanged(BR.beans);
    }



}
