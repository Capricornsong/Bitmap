package com.example.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtil {

    //压缩
    public static Bitmap ratio(String filepath,int pixelW,int pixelH){
        BitmapFactory.Options bitmapoptions = new BitmapFactory.Options();
        bitmapoptions.inJustDecodeBounds = true;
        //配置bitmap加载位深度
        bitmapoptions.inPreferredConfig = Bitmap.Config.RGB_565;
        //预加载
        BitmapFactory.decodeFile(filepath,bitmapoptions);
        int originalW = bitmapoptions.outWidth;
        int originalH = bitmapoptions.outHeight;


        bitmapoptions.inSampleSize = getsimpleSize(originalW,originalH,pixelW,pixelH);
        bitmapoptions.inJustDecodeBounds = false;

        //
        return BitmapFactory.decodeFile(filepath,bitmapoptions);
    }

    private static int getsimpleSize(int originalW, int originalH, int pixelW, int pixelH) {
        int simpleSize = 1;
        if (originalW > originalH && originalW > pixelW){
            simpleSize = originalW / pixelW;
        }
        else if (originalW < originalH && originalH > pixelH){
            simpleSize = originalH / pixelH;
        }
        if (simpleSize <= 0) {
            simpleSize = 1;
        }
        return simpleSize;
    }
}
