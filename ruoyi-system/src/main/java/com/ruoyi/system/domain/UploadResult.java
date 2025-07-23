package com.ruoyi.system.domain;

/**
 * 文件上传结果对象
 * 
 * @author ruoyi
 * @date 2025-07-22
 */
public class UploadResult
{
    /** 成功上传数量 */
    private int successCount;
    
    /** 重复文件数量 */
    private int duplicateCount;
    
    /** 失败数量 */
    private int failedCount;
    
    /** 总文件数量 */
    private int totalCount;

    public UploadResult()
    {
    }

    public UploadResult(int successCount, int duplicateCount, int failedCount, int totalCount)
    {
        this.successCount = successCount;
        this.duplicateCount = duplicateCount;
        this.failedCount = failedCount;
        this.totalCount = totalCount;
    }

    public int getSuccessCount()
    {
        return successCount;
    }

    public void setSuccessCount(int successCount)
    {
        this.successCount = successCount;
    }

    public int getDuplicateCount()
    {
        return duplicateCount;
    }

    public void setDuplicateCount(int duplicateCount)
    {
        this.duplicateCount = duplicateCount;
    }

    public int getFailedCount()
    {
        return failedCount;
    }

    public void setFailedCount(int failedCount)
    {
        this.failedCount = failedCount;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    @Override
    public String toString()
    {
        return "UploadResult{" +
                "successCount=" + successCount +
                ", duplicateCount=" + duplicateCount +
                ", failedCount=" + failedCount +
                ", totalCount=" + totalCount +
                '}';
    }
}