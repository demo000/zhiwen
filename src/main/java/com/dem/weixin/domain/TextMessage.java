package com.dem.weixin.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by DEM on 2017/3/8.
 */
@Setter@Getter
public class TextMessage extends BaseMessage {

    @SerializedName("text")
    private TextContent text ;

    public TextMessage() {
        this.setMsgtype(BaseMessage.TEXT);
    }
}
