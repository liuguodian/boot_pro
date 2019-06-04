package com.demo.boot_pro.test;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by DIAN on 2019/5/27.
 */
public class PicUtils {
    /**
     * @param fileUrl
     *            文件绝对路径或相对路径
     * @return 读取到的缓存图像
     * @throws IOException
     *             路径错误或者不存在该文件时抛出IO异常
     */
    private static BufferedImage getBufferedImage(String fileUrl)
            throws IOException {
        File f = new File(fileUrl);
        return ImageIO.read(f);
    }

    /**
     * 合并任数量的图片成一张图片
     *
     * @param isHorizontal
     *            true代表水平合并，fasle代表垂直合并
     * @param imgs
     *            待合并的图片数组
     * @return
     * @throws IOException
     */
    public static BufferedImage mergeImage(boolean isHorizontal, BufferedImage... imgs) throws IOException {
        // 生成新图片
        BufferedImage destImage = null;
        // 计算新图片的长和高
        int allw = 0, allh = 0, allwMax = 0, allhMax = 0;
        // 获取总长、总宽、最长、最宽
        for (int i = 0; i < imgs.length; i++) {
            BufferedImage img = imgs[i];
            allw += img.getWidth();
            allh += img.getHeight();
            if (img.getWidth() > allwMax) {
                allwMax = img.getWidth();
            }
            if (img.getHeight() > allhMax) {
                allhMax = img.getHeight();
            }
        }
        // 创建新图片
        if (isHorizontal) {
            destImage = new BufferedImage(allw, allhMax, BufferedImage.TYPE_INT_RGB);
        } else {
            destImage = new BufferedImage(allwMax, allh, BufferedImage.TYPE_INT_RGB);
        }
        // 合并所有子图片到新图片
        int wx = 0, wy = 0;
        for (int i = 0; i < imgs.length; i++) {
            BufferedImage img = imgs[i];
            int w1 = img.getWidth();
            int h1 = img.getHeight();
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[w1 * h1];
            ImageArrayOne = img.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
            if (isHorizontal) { // 水平方向合并
                destImage.setRGB(wx, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            } else { // 垂直方向合并
                destImage.setRGB(0, wy, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            }
            wx += w1;
            wy += h1;
        }
        return destImage;
    }

    /**
     * 压缩
     * */
    public static void compress(String path, int ppi,String imgType){
        byte[] smallImage = null;
        try {
            File file = new File(path);
            String newFileName = file.getParent()+"\\ys_"+file.getName();
            Thumbnails.of(path).size(ppi, ppi).outputFormat(imgType).toFile(newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\DIAN\\Desktop\\ss");
        File[] tempList = file.listFiles();
        BufferedImage[] bufferedImages = new BufferedImage[4];
        try {
            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile()) {
                    try {
                        //PicUtils.compress(tempList[i].getPath(),500);
                        bufferedImages[i] = PicUtils.getBufferedImage(tempList[i].getPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            BufferedImage ImageNew =  PicUtils.mergeImage(true,bufferedImages);
            ImageIO.write(ImageNew, "jpg", new File("C:\\Users\\DIAN\\Desktop\\ss\\ss.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
