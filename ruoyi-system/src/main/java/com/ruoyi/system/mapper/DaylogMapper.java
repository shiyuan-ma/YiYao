package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Daylog;

import java.util.List;

/**
 * 【日报管理】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-04
 */
public interface DaylogMapper 
{
    /**
     * 查询【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 【日报管理】
     */
    public Daylog selectDaylogById(Long id);

    /**
     * 查询【日报管理】列表
     * 
     * @param daylog 【日报管理】
     * @return 【日报管理】集合
     */
    public List<Daylog> selectDaylogList(Daylog daylog);


    public List<Daylog> selectDaylogAll();

    /**
     * 新增【日报管理】
     * 
     * @param daylog 【日报管理】
     * @return 结果
     */
    public int insertDaylog(Daylog daylog);

    /**
     * 修改【日报管理】
     * 
     * @param daylog 【日报管理】
     * @return 结果
     */
    public int updateDaylog(Daylog daylog);

    /**
     * 删除【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    public int deleteDaylogById(Long id);

    /**
     * 批量删除【日报管理】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDaylogByIds(Long[] ids);

    /**
     * 归档【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    public int archiveDaylogById(Long id);

    /**
     * 批量归档【日报管理】
     * 
     * @param ids 需要归档的数据主键集合
     * @return 结果
     */
    public int archiveDaylogByIds(Long[] ids);

    /**
     * 查询已归档的【日报管理】列表
     * 
     * @param daylog 【日报管理】
     * @return 【日报管理】集合
     */
    public List<Daylog> selectArchivedDaylogList(Daylog daylog);

    /**
     * 恢复归档的【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    public int restoreDaylogById(Long id);

    /**
     * 批量恢复归档的【日报管理】
     * 
     * @param ids 需要恢复的数据主键集合
     * @return 结果
     */
    public int restoreDaylogByIds(Long[] ids);
}
