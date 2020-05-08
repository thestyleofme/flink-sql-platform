package org.abigballofmud.flink.platform.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.abigballofmud.flink.platform.api.dto.SqlJobDTO;
import org.abigballofmud.flink.platform.domain.entity.SqlJob;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author isacc 2020/4/3 10:23
 * @since 1.0
 */
public interface SqlJobMapper extends BaseMapper<SqlJob> {

    /**
     * 分页查询flink sql任务
     *
     * @param page      Page<SqlJob>
     * @param sqlJobDTO SqlJobDTO
     * @return IPage<SqlJobDTO>
     */
    IPage<SqlJobDTO> list(Page<SqlJob> page, @Param("dto") SqlJobDTO sqlJobDTO);
}
