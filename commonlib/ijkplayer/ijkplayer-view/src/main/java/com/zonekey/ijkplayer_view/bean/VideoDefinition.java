package com.zonekey.ijkplayer_view.bean;

/**
 * Created by xu.wang
 * Date on  2017/9/29 09:42:21.
 *
 * @des
 */

public class VideoDefinition {
    private int level;  //当前等级,1,标情 2,高清 ,3,超清
    private String url;    //当前url
    private String descrption;  //即为标清等

    public VideoDefinition(int level, String url, String descrption) {
        this.level = level;
        this.url = url;
        this.descrption = descrption;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
