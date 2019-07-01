package com.ecms.cums.dao;


import com.ecms.cums.model.PayOrder;
import com.ecms.cums.model.OrderInfoCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
public interface PayOrderMapper {
    int countByExample(OrderInfoCriteria example);

    int deleteByExample(OrderInfoCriteria example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    List<PayOrder> selectByExampleWithBLOBs(OrderInfoCriteria example);

    List<PayOrder> selectByExample(OrderInfoCriteria example);

    PayOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") PayOrder record,
                                 @Param("example") OrderInfoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") PayOrder record,
                                 @Param("example") OrderInfoCriteria example);

    int updateByExample(@Param("record") PayOrder record,
                        @Param("example") OrderInfoCriteria example);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKeyWithBLOBs(PayOrder record);

    int updateByPrimaryKey(PayOrder record);

    void updatePayOrderStatusByTime();

    List<PayOrder> checkPayOrderByUserId(Integer userId);

    List<PayOrder> queryPage(PageBounds pageBounds, Map<String, Object> params);

    List<PayOrder> selectExportExcel(@Param("perName")String perName,  @Param("stateLocal")  String stateLocal);
}