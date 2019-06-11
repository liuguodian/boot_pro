package com.demo.boot_pro.test;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIAN on 2019/6/3.
 */
public class ImageUtils {

    public static void main(String[] args) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\1.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }



       /* List<String> bookFilePaths = new ArrayList<String>();
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\1.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\2.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\3.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\4.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\5.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\6.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\7.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\1.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\2.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\3.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\4.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\5.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\6.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\7.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\1.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\2.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\3.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\4.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\5.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\6.jpg");
        bookFilePaths.add("C:\\Users\\DIAN\\Desktop\\ssss\\7.jpg");
        String picName = "C:\\Users\\DIAN\\Desktop\\ssss\\test1.jpg";
        String whiteUrl = "C:\\Users\\DIAN\\Desktop\\ssss\\10.jpg";
        for (String jpg : bookFilePaths) {
            try {//裁切图片200*200
                doFileDownload(jpg,
                        null, 200, 200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//多张小图片生成九宫格图片600*600
        createBigJPG(bookFilePaths, Color.gray, picName,9,whiteUrl);*/
    }


    /**
     * 绘制九宫格图片
     *
     * @param smallJPG
     * @param bgColor
     * @param picName
     */
    private static void createBigJPG(List<String> smallJPG, Color bgColor, String picName,int type,String whiteUrl) {
        try {
            int imageCount = smallJPG.size();
            //每张小图片的高度，宽度
            int smallWidth = 200;
            int smallHeight = 200;
            //按照大图片宽高绘制一个背景图片
            int setWidth = 600;
            int setHeight = 1400;
            BufferedImage bufImage = new BufferedImage(setWidth, setHeight,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImage.createGraphics();
            g.setColor(bgColor); //背景的颜色
            g.fillRect(0, 0, setWidth, setHeight);
            int topMargin[] = {200, 100, 0};//左边距
            int len = 0;
            int y = 0; //纵坐标
            int leftMargin[] = {200, 100, 0};//左边距

            int rowCount =7;
            if(type==2){
                getTwo( rowCount,  imageCount,
                 smallJPG, len, g, y,
                 smallWidth, smallHeight,whiteUrl);
            }else if(type==0){
                getZero( rowCount,  imageCount,
                        smallJPG, len, g, y,
                        smallWidth, smallHeight,whiteUrl);
            }else if(type==1){
                getOne( rowCount,  imageCount,
                        smallJPG, len, g, y,
                        smallWidth, smallHeight,whiteUrl);
            }else if(type==9){
                getNine( rowCount,  imageCount,
                        smallJPG, len, g, y,
                        smallWidth, smallHeight,whiteUrl);
            }
            /*for (int i = 1; i <= rowCount; i++) { //遍历每行
                int colCount = getColCount(imageCount, rowCount, i);
                int x = leftMargin[colCount - 1]; //横坐标  可能会出现左边距
                for (int j = 1; j <= colCount; j++) {
                    String jpgname = smallJPG.get(len);
                    ImageIcon icon = new ImageIcon(jpgname);
                    Image img = icon.getImage();
                    g.drawImage(img, x, y, null);
                    x += smallWidth;
                    len++;
                }
                y += smallHeight;
            }*/
            g.dispose();
            FileOutputStream out = new FileOutputStream(picName);  //指定输出文件
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  //设置文件格式
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufImage); //从图片缓冲中读取
            param.setQuality(50f, true);
            encoder.encode(bufImage, param); //存盘
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("createBigJPG Failed!");
            e.printStackTrace();
        }
    }

    /**
     * 生成 2
     * */
    private static void getTwo(int rowCount, int imageCount,
                         List<String> smallJPG,int len,Graphics2D g,int y,
                         int smallWidth,int smallHeight,String whiteUrl){
        int leftMargin[] = {200, 100, 0};//左边距
        for (int i = 0; i < 7; i++) {
            int colCount = getColCount(imageCount, rowCount, i);
            int x = leftMargin[colCount - 1]; //横坐标  可能会出现左边距
            if(i==1||i==2){
                for (int j = 0; j < 3; j++) {
                    if(j==2){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }else if(i==4||i==5){
                for (int j = 0; j < 3; j++) {
                    if(j==0){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }else{
                for (int j = 0; j < 3; j++) {
                    String jpgname = smallJPG.get(len);
                    ImageIcon icon = new ImageIcon(jpgname);
                    Image img = icon.getImage();
                    g.drawImage(img, x, y, null);
                    x += smallWidth;
                    len++;
                }
            }
            y += smallHeight;
        }
    }

    /**
     * 生成 0
     * */
    private static void getZero(int rowCount, int imageCount,
                               List<String> smallJPG,int len,Graphics2D g,int y,
                               int smallWidth,int smallHeight,String whiteUrl){
        int leftMargin[] = {200, 100, 0};//左边距
        for (int i = 0; i < 7; i++) {
            int colCount = getColCount(imageCount, rowCount, i);
            int x = leftMargin[colCount - 1]; //横坐标  可能会出现左边距
            if(i==0||i==6){
                for (int j = 0; j < 3; j++) {
                    String jpgname = smallJPG.get(len);
                    ImageIcon icon = new ImageIcon(jpgname);
                    Image img = icon.getImage();
                    g.drawImage(img, x, y, null);
                    x += smallWidth;
                    len++;
                }
            }else{
                for (int j = 0; j < 3; j++) {
                    if(j==0||j==2){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }
            y += smallHeight;
        }
    }

    /**
     * 生成 1
     * */
    private static void getOne(int rowCount, int imageCount,
                               List<String> smallJPG,int len,Graphics2D g,int y,
                               int smallWidth,int smallHeight,String whiteUrl){
        int leftMargin[] = {200, 100, 0};//左边距
        for (int i = 0; i < 7; i++) {
            int colCount = getColCount(imageCount, rowCount, i);
            int x = leftMargin[colCount - 1]; //横坐标  可能会出现左边距
            if(i==1){
                for (int j = 0; j < 3; j++) {
                    if(j==2){
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }else {
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;

                    }

                }


            }else if(i==6){
                for (int j = 0; j < 3; j++) {
                    String jpgname = smallJPG.get(len);
                    ImageIcon icon = new ImageIcon(jpgname);
                    Image img = icon.getImage();
                    g.drawImage(img, x, y, null);
                    x += smallWidth;
                    len++;
                }
            }else{
                for (int j = 0; j < 3; j++) {
                    if(j==1){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }
            y += smallHeight;
        }
    }

    /**
     * 生成 9
     * */
    private static void getNine(int rowCount, int imageCount,
                               List<String> smallJPG,int len,Graphics2D g,int y,
                               int smallWidth,int smallHeight,String whiteUrl){
        int leftMargin[] = {200, 100, 0};//左边距
        for (int i = 0; i < 7; i++) {
            int colCount = getColCount(imageCount, rowCount, i);
            int x = leftMargin[colCount - 1]; //横坐标  可能会出现左边距
            if(i==0||i==3||i==6){
                for (int j = 0; j < 3; j++) {
                    String jpgname = smallJPG.get(len);
                    ImageIcon icon = new ImageIcon(jpgname);
                    Image img = icon.getImage();
                    g.drawImage(img, x, y, null);
                    x += smallWidth;
                    len++;
                }
            }else if(i==1||i==2){
                for (int j = 0; j < 3; j++) {
                    if(j==0||j==2){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }else{
                for (int j = 0; j < 3; j++) {
                    if(j==2){
                        String jpgname = smallJPG.get(len);
                        ImageIcon icon = new ImageIcon(jpgname);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                        len++;
                    }else {
                        ImageIcon icon = new ImageIcon(whiteUrl);
                        Image img = icon.getImage();
                        g.drawImage(img, x, y, null);
                        x += smallWidth;
                    }

                }
            }
            y += smallHeight;
        }
    }

      //获取当前行的列数
    public static int getColCount(int imageCount, int rowcount, int currentRow) {
        if (rowcount == 2) {//总行数
            if (currentRow == 1) {//当前行
                return imageCount - 3;
            } else {
                return 3;
            }
        }else if (rowcount == 3) {
            if (currentRow == 1) {
                return imageCount - 6;
            } else {
                return 3;
            }
        }else if (rowcount == 4) {
            if (currentRow == 1) {
                return imageCount - 9;
            } else {
                return 3;
            }
        }else if (rowcount == 5) {
            if (currentRow == 1) {
                return imageCount - 12;
            } else {
                return 3;
            }
        }else if (rowcount == 6) {
            if (currentRow == 1) {
                return imageCount - 15;
            } else {
                return 3;
            }
        }else if (rowcount == 7) {
            if (currentRow == 1) {
                return imageCount - 18;
            } else {
                return 3;
            }
        }
        return imageCount;
    }

    //裁切图片
    public static void doFileDownload(String path,
                                      String filename, int width, int hight)
            throws Exception {
         // path是指欲下载的文件的路径。
        File file = new File(path);
        Image img = ImageIO.read(file); // 构造Image对象
        int srcwidth = img.getWidth(null); // 得到源图宽
        int srcheight = img.getHeight(null); // 得到源图长
        // 按照宽度还是高度进行压缩 width 最大宽度 hight 最大高度
        if (srcwidth / srcheight > width / hight) {
            int h = (int) (srcheight * width / srcwidth);
            resize(img, width, h, path, file);
        } else {
            int w = (int) (srcwidth * hight / srcheight);
            resize(img, w, hight, path, file);
        }

    }


    /**
     * 强制压缩/放大图片到固定的大小
     *
     * @param w int 新宽度
     * @param h int 新高度
     */
    public static void resize(Image img, int w, int h,
                              String path, File file)
            throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        File destFile = new File(path);
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();

    }

}
