package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Daylog;
import com.ruoyi.system.mapper.DaylogMapper;
import com.ruoyi.system.service.IDaylogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【日报管理】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-04
 */
@Service
public class DaylogServiceImpl implements IDaylogService 
{
    @Autowired
    private DaylogMapper daylogMapper;

    /**
     * 查询【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 【日报管理】
     */
    @Override
    public Daylog selectDaylogById(Long id)
    {
        return daylogMapper.selectDaylogById(id);
    }

    /**
     * 查询【日报管理】列表
     * 
     * @param daylog 【日报管理】
     * @return 【日报管理】
     */
    @Override
    public List<Daylog> selectDaylogList(Daylog daylog)
    {
        return daylogMapper.selectDaylogList(daylog);
    }

    @Override
    public List<Daylog> selectDaylogAllExceptArchived()
    {
        return daylogMapper.selectDaylogAllExceptArchived();
    }


    /**
     * 新增【日报管理】
     * 
     * @param daylog 【日报管理】
     * @return 结果
     */
    @Override
    public int insertDaylog(Daylog daylog)
    {
        return daylogMapper.insertDaylog(daylog);
    }

    /**
     * 修改【日报管理】
     * 
     * @param daylog 【日报管理】
     * @return 结果
     */
    @Override
    public int updateDaylog(Daylog daylog)
    {
        return daylogMapper.updateDaylog(daylog);
    }

    /**
     * 批量删除【日报管理】
     * 
     * @param ids 需要删除的【日报管理】主键
     * @return 结果
     */
    @Override
    public int deleteDaylogByIds(Long[] ids)
    {
        return daylogMapper.deleteDaylogByIds(ids);
    }

    /**
     * 删除【日报管理】信息
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    @Override
    public int deleteDaylogById(Long id)
    {
        return daylogMapper.deleteDaylogById(id);
    }

    /**
     * 归档【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    @Override
    public int archiveDaylogById(Long id)
    {
        return daylogMapper.archiveDaylogById(id);
    }

    /**
     * 批量归档【日报管理】
     * 
     * @param ids 需要归档的【日报管理】主键集合
     * @return 结果
     */
    @Override
    public int archiveDaylogByIds(Long[] ids)
    {
        return daylogMapper.archiveDaylogByIds(ids);
    }

    /**
     * 查询已归档的【日报管理】列表
     * 
     * @param daylog 【日报管理】
     * @return 【日报管理】集合
     */
    @Override
    public List<Daylog> selectArchivedDaylogList(Daylog daylog)
    {
        return daylogMapper.selectArchivedDaylogList(daylog);
    }

    /**
     * 恢复归档的【日报管理】
     * 
     * @param id 【日报管理】主键
     * @return 结果
     */
    @Override
    public int restoreDaylogById(Long id)
    {
        return daylogMapper.restoreDaylogById(id);
    }

    /**
     * 批量恢复归档的【日报管理】
     * 
     * @param ids 需要恢复的【日报管理】主键集合
     * @return 结果
     */
    @Override
    public int restoreDaylogByIds(Long[] ids)
    {
        return daylogMapper.restoreDaylogByIds(ids);
    }
}
