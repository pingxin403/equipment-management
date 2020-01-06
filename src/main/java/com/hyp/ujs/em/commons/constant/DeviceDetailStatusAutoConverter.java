package com.hyp.ujs.em.commons.constant;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * {@link DeviceDetailStatus}的转换器类
 *
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons.constant
 * hyp create at 20-1-5
 **/
public class DeviceDetailStatusAutoConverter implements Converter<DeviceDetailStatus> {

    /**
     * Back to object types in Java
     *
     * @return Support for Java class
     */
    @Override
    public Class supportJavaTypeKey() {
        return DeviceDetailStatus.class;
    }

    /**
     * Back to object enum in excel
     *
     * @return Support for {@link CellDataTypeEnum}
     */
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * Convert excel objects to Java objects
     *
     * @param cellData            Excel cell data.NotNull.
     * @param contentProperty     Content property.Nullable.
     * @param globalConfiguration Global configuration.NotNull.
     * @return Data to put into a Java object
     * @throws Exception Exception.
     */
    @Override
    public DeviceDetailStatus convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String s = cellData.getStringValue();
        return DeviceDetailStatus.from(s);
    }

    /**
     * Convert Java objects to excel objects
     *
     * @param value               Java Data.NotNull.
     * @param contentProperty     Content property.Nullable.
     * @param globalConfiguration Global configuration.NotNull.
     * @return Data to put into a Excel
     * @throws Exception Exception.
     */
    @Override
    public CellData convertToExcelData(DeviceDetailStatus value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(value.getMsg());
    }
}
