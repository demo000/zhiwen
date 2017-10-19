package com.dem.weixin.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DEM on 2017/3/9.
 */
public class QRCodeUtils {

    public static void createQrCode(String dirPath,String content){

        String fileName = "zxing.png";
        JSONObject json = new JSONObject();

        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");//设置编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//定义错误级别
        hints.put(EncodeHintType.MARGIN,2);//设置外边距
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
            Path path = FileSystems.getDefault().getPath(dirPath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("输出成功.");
    }

    public static void main(String[] args) {
        createQrCode("d://","http://www.baidu.com");
    }
}
