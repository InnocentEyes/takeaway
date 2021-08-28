package com.takeaway.exception;

/**
 * 页面超出数据库分页的异常
 */
public class PageEnoughException extends Exception{
    public PageEnoughException() {
        super();
    }

    public PageEnoughException(String message) {
        super(message);
    }

}
