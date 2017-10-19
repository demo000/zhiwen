package com.dem.weixin.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by DEM on 2017/3/8.
 */
@Setter@Getter
public class VideoMessage extends BaseMessage {

    @SerializedName("video")
    private Video video = new Video();

    @Setter@Getter
    public class Video  {
        @SerializedName("media_id")
        private String mediaId;
        @SerializedName("thumb_media_id")
        private String thumbMediaId;
        private String title;
        private String description;
    }

    public VideoMessage() {
        this.setMsgtype(BaseMessage.VIDEO);
    }

    public Video getVideo() {
        return video;
    }

    public void setContent(Video content) {
        this.video = content;
    }
}
