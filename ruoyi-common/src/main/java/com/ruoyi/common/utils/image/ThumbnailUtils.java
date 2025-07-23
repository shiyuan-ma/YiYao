package com.ruoyi.common.utils.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.util.Iterator;

/**
 * 缩略图生成工具类
 * 
 * @author ruoyi
 */
public class ThumbnailUtils
{
    /** 默认缩略图宽度 */
    public static final int DEFAULT_THUMBNAIL_WIDTH = 300;
    
    /** 默认JPEG压缩质量 */
    public static final float DEFAULT_JPEG_QUALITY = 0.75f;
    
    /**
     * 生成缩略图
     * 
     * @param originalImageBytes 原始图片字节数组
     * @param thumbnailWidth 缩略图宽度
     * @param jpegQuality JPEG压缩质量 (0.0-1.0)
     * @return 缩略图字节数组
     * @throws IOException IO异常
     */
    public static byte[] generateThumbnail(byte[] originalImageBytes, int thumbnailWidth, float jpegQuality) throws IOException
    {
        // 读取原始图片
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(originalImageBytes));
        if (originalImage == null)
        {
            throw new IOException("无法读取图片数据");
        }
        
        // 计算缩略图尺寸
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        
        // 如果原图宽度小于等于目标宽度，直接返回压缩后的原图
        if (originalWidth <= thumbnailWidth)
        {
            return compressJpeg(originalImage, jpegQuality);
        }
        
        // 按比例计算缩略图高度
        int thumbnailHeight = (int) ((double) originalHeight * thumbnailWidth / originalWidth);
        
        // 创建缩略图
        BufferedImage thumbnailImage = new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = thumbnailImage.createGraphics();
        
        // 设置高质量渲染
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 绘制缩放后的图片
        Image scaledImage = originalImage.getScaledInstance(thumbnailWidth, thumbnailHeight, Image.SCALE_SMOOTH);
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();
        
        // 压缩并返回JPEG格式的缩略图
        return compressJpeg(thumbnailImage, jpegQuality);
    }
    
    /**
     * 生成缩略图（使用默认参数）
     * 
     * @param originalImageBytes 原始图片字节数组
     * @return 缩略图字节数组
     * @throws IOException IO异常
     */
    public static byte[] generateThumbnail(byte[] originalImageBytes) throws IOException
    {
        return generateThumbnail(originalImageBytes, DEFAULT_THUMBNAIL_WIDTH, DEFAULT_JPEG_QUALITY);
    }
    
    /**
     * 压缩JPEG图片
     * 
     * @param image 图片对象
     * @param quality 压缩质量 (0.0-1.0)
     * @return 压缩后的字节数组
     * @throws IOException IO异常
     */
    private static byte[] compressJpeg(BufferedImage image, float quality) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        // 获取JPEG写入器
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
        if (!writers.hasNext())
        {
            throw new IOException("没有找到JPEG写入器");
        }
        
        ImageWriter writer = writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
        writer.setOutput(ios);
        
        // 设置压缩参数
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        
        // 写入图片
        writer.write(null, new javax.imageio.IIOImage(image, null, null), param);
        
        // 清理资源
        writer.dispose();
        ios.close();
        
        return baos.toByteArray();
    }
    
    /**
     * 保存缩略图到文件
     * 
     * @param thumbnailBytes 缩略图字节数组
     * @param outputFile 输出文件
     * @throws IOException IO异常
     */
    public static void saveThumbnailToFile(byte[] thumbnailBytes, File outputFile) throws IOException
    {
        java.nio.file.Files.write(outputFile.toPath(), thumbnailBytes);
    }
    
    /**
     * 生成缩略图文件名
     * 
     * @param originalFileName 原始文件名
     * @return 缩略图文件名
     */
    public static String generateThumbnailFileName(String originalFileName)
    {
        if (originalFileName == null || originalFileName.isEmpty())
        {
            return "thumbnail.jpg";
        }
        
        int lastDotIndex = originalFileName.lastIndexOf('.');
        if (lastDotIndex > 0)
        {
            String nameWithoutExt = originalFileName.substring(0, lastDotIndex);
            return nameWithoutExt + "_thumb.jpg";
        }
        else
        {
            return originalFileName + "_thumb.jpg";
        }
    }
}