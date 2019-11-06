package com.olie.mybatis.mapper;

import com.olie.mybatis.model.ScheduleTask;
import com.olie.mybatis.model.TOrder;
import com.olie.mybatis.model.TOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TOrderMapper {


    //pageHelper 分页
    @Select("select * from t_order order by id")
    List<TOrder> findAllWithParam(@Param("pageNum") int pageNum,
                                        @Param("pageSize") int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    long countByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    int deleteByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    @Delete({
        "delete from t_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    @Insert({
        "insert into t_order (name, type, ",
        "gmt_create)",
        "values (#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    int insertSelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    List<TOrder> selectByExampleWithRowbounds(TOrderExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    List<TOrder> selectByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    @Select({
        "select",
        "id, name, type, gmt_create",
        "from t_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.olie.mybatis.mapper.TOrderMapper.BaseResultMap")
    TOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    int updateByPrimaryKeySelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Thu Oct 31 13:45:02 CST 2019
     */
    @Update({
        "update t_order",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TOrder record);
}