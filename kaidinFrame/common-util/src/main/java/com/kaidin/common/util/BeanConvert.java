package com.kaidin.common.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
/**
 * 转换工具
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2015-6-23下午01:51:48
 */
public class BeanConvert<T> {
	private BeanConvertFilter<T> filter;	// 只针对返回列表有效，根据属性值舍弃一些对象
	
	
	public BeanConvert() {
	}
	public BeanConvert(BeanConvertFilter<T> aFilter) {
		this.filter = aFilter;
	}

	
	public T convert(T destObj, String[] properties, Object[] srcValues) throws Exception {
		for (int i = 0; i < properties.length; i++) {
			if (null == srcValues[i]) {
				continue;
			}
			if (srcValues[i] instanceof Timestamp) {
				srcValues[i] = new Date(((Timestamp) srcValues[i]).getTime());
			}
//			 String methodName = "set" + StringUtil.toUpperCaseAtFirst(properties[i]);
//			 Method setMethod = destObj.getClass().getMethod(methodName, new Class[] { srcValues[i].getClass() });
//			 Object result = setMethod.invoke(destObj, new Object[] {srcValues[i] });
			PropertyUtils.setProperty(destObj, properties[i], srcValues[i]);
		}
		
		return destObj;
	}

	
	public List<T> convert(Class<T> clazz, String[] properties, List<Object[]> valuesList) throws Exception {
		List<T> result = new ArrayList<T>(valuesList.size());
		
		for (Object[] objVals: valuesList) {
			T object = clazz.newInstance();
			object = convert(object, properties, objVals);
			if (null != filter) {
				if (filter.doFilter(object)) {
					result.add(object);
				}
			} else {
				result.add(object);
			}
		}
		
		return result;
	}
}