/**
 * 
 */
package com.sandeep.thread.waitandnotify;

/**
 * @author sandeept
 *
 */
public class Message{
    private String msg;
     
    public Message(String str){
        this.msg=str;
    }
 
    public String getMessage() {
        return msg;
    }
 
    public void setMessage(String str) {
        this.msg=str;
    }
 
}
