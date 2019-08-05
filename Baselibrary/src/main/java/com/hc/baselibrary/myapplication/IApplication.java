package com.hc.baselibrary.myapplication;

public interface IApplication {

    /**
     * 当前Module的Application是否是调试模式
     *
     * @return
     */
    boolean isDebug();

    /**
     * Module单独使用到的初始化在这里进行
     */
    void init();
}
