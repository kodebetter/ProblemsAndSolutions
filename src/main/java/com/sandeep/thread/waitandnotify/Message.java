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
    private boolean shouldProceed;

    public Message(String msg, boolean shouldProceed) {
        this.msg = msg;
        this.shouldProceed = shouldProceed;
    }

    public String getMessage() {
        return msg;
    }
 
    public void setMessage(String str) {
        this.msg=str;
    }

    public boolean isShouldProceed() {
        return shouldProceed;
    }

    public void setShouldProceed(boolean shouldProceed) {
        this.shouldProceed = shouldProceed;
    }
}
