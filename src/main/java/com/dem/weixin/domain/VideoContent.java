package com.dem.weixin.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by DEM on 2017/3/8.
 */
@Setter@Getter
public class VideoContent {

    @SerializedName("media_id")
    private String mediaId;
    @SerializedName("thumb_media_id")
    private String thumbMediaId;
    private String title;
    private String description;


}
