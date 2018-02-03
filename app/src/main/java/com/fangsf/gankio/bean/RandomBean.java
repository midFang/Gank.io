package com.fangsf.gankio.bean;

/**
 * Created by fangsf on 2018/2/3.
 * Useful:
 */

public class RandomBean {


    /**
     * _id : 571c841e67765974f885bf73
     * createdAt : 2016-04-24T16:30:22.634Z
     * desc : 4.25
     * publishedAt : 2016-04-25T11:24:01.704Z
     * source : chrome
     * type : 福利
     * url : http://ww4.sinaimg.cn/large/7a8aed7bjw1f37vhovzlnj20f00evabt.jpg
     * used : true
     * who : 张涵宇
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
