package com.example.whatsapp;

public class CallView {
    private String tv_call;
    private int im_call;
    private  int call;


    public CallView(String tv_call,  int im_call) {
        this.tv_call = tv_call;
        this.call=R.drawable.ic_call_black_24dp;
        this.im_call = im_call;
    }

    public String getTv_call() {
        return tv_call;
    }

    public void setTv_call(String name) {
        this.tv_call = tv_call;
    }



    public int getIm_call() {
        return im_call;
    }

    public void setIm_call(int im_call) {
        this.im_call = im_call;
    }

}
