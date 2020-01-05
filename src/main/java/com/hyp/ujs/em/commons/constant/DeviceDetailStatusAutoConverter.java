package com.hyp.ujs.em.commons.constant;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.commons.constant
 * hyp create at 20-1-5
 **/
public class DeviceDetailStatusAutoConverter implements Converter {
    @Override
    public Class supportJavaTypeKey() {
        return DeviceDetailStatus.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Object convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String s = cellData.getStringValue();
        return DeviceDetailStatus.valueOf(s);
//        return null;
    }

    @Override
    public CellData convertToExcelData(Object value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        DeviceDetailStatus status = (DeviceDetailStatus) (value);
        return new CellData(status.getMsg());
    }
}
