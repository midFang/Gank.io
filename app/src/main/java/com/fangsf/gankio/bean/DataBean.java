package com.fangsf.gankio.bean;

import java.util.List;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class DataBean {


    /**
     * _id : 5a685120421aa911548992ab
     * createdAt : 2018-01-24T17:25:52.341Z
     * desc : Android 下的音乐可视化
     * images : ["http://img.gank.io/e0d29181-282e-4465-9965-1da81e0557d9"]
     * publishedAt : 2018-01-29T07:53:57.676Z
     * source : web
     * type : Android
     * url : https://github.com/nekocode/MusicVisualization
     * used : true
     * who : nekocode
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
    private List<String> images;

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
