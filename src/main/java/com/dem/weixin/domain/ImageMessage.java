package com.dem.weixin.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by DEM on 2017/3/8.
 */
@Setter @Getter
public class ImageMessage extends BaseMessage  {

    @SerializedName("image")
    private ImageContent imageContent;

    public ImageMessage() {
        this.setMsgtype(BaseMessage.IMAGE);
    }
}
