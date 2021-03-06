/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.exception;

import java.util.Collection;
import java.util.Map;

import com.kaidin.common.util.BaseUtil;
import com.kaidin.common.util.collection.CollectionUtil;
import com.kaidin.common.util.StringUtil;
import com.kaidin.common.util.query.PageData;

/**
 * 断言工具 不满足断言的，抛出异常
 * 
 * @author kaidin@foxmail.com
 * @date 2016-5-17下午01:51:48
 */
public final class AssertUtil {
	/**
	 * 禁用构造函数
	 */
	private AssertUtil() {
	}

	/**
	 * 期待结果为null，否则抛出异常
	 */
	public static void isNull(Object obj, IExceptionCode errCode, String errMsg) {
		if (null != obj) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待结果不为null，否则抛出异常
	 */
	public static void isNotNull(Object obj, IExceptionCode errCode, String errMsg) {
		if (null == obj) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待结果为真，否则抛出异常
	 */
	public static void isTrue(boolean expression, IExceptionCode errCode, String errMsg) {
		if (!expression) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待结果为真，否则抛出异常
	 */
	public static void isTrue(PageData pageData) {
		if (!pageData.isSuccess()) {
			BaseException exception = new BaseException();
			exception.setErrCode(pageData.getErrCode());
			exception.setErrMsg(pageData.getErrMsg());
			throw exception;
		}
	}

	/**
	 * 断言结果为假，直接抛出异常
	 */
	public static void isFalse(IExceptionCode errCode, String errMsg) {
		throw new BaseException(errCode, errMsg);
	}

	/**
	 * 期待结果为假，否则抛出异常
	 */
	public static void isFalse(boolean expression, IExceptionCode errCode, String errMsg) {
		if (expression) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串为空白串，否则抛出异常
	 */
	public static void isBlank(String str, IExceptionCode errCode, String errMsg) {
		if (StringUtil.isNotBlank(str)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串不是空白串，否则抛出异常
	 */
	public static void isNotBlank(String str, IExceptionCode errCode, String errMsg) {
		if (StringUtil.isBlank(str)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串为空，否则抛出异常
	 */
	public static void isEmpty(String str, IExceptionCode errCode, String errMsg) {
		if (StringUtil.isNotEmpty(str)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串不为空，否则抛出异常
	 */
	public static void isNotEmpty(String str, IExceptionCode errCode, String errMsg) {
		if (StringUtil.isEmpty(str)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串相同，否则抛出异常
	 */
	public static void isEquals(String str1, String str2, IExceptionCode errCode, String errMsg) {
		if (!StringUtil.equals(str1, str2)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待对象相同，否则抛出异常
	 */
	public static void isEquals(Object obj1, Object obj2, IExceptionCode errCode, String errMsg) {
		if (!BaseUtil.equals(obj1, obj2)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待字符串不同，否则抛出异常
	 */
	public static void isNotEquals(String str1, String str2, IExceptionCode errCode, String errMsg) {
		if (StringUtil.equals(str1, str2)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待集合为空，否则抛出异常
	 */
	public static void isEmpty(Collection<?> collection, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isNotEmpty(collection)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待集合不为空，否则抛出异常
	 */
	public static void isNotEmpty(Collection<?> collection, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isEmpty(collection)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待结果为空，否则抛出异常
	 */
	public static void isEmpty(Map<?, ?> map, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isNotEmpty(map)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待结果不为空，否则抛出异常
	 */
	public static void isNotEmpty(Map<?, ?> map, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isEmpty(map)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待数组为空，否则抛出异常
	 */
	public static void isEmpty(Object[] array, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isNotEmpty(array)) {
			throw new BaseException(errCode, errMsg);
		}
	}

	/**
	 * 期待数组不为空，否则抛出异常
	 */
	public static void isNotEmpty(Object[] array, IExceptionCode errCode, String errMsg) {
		if (CollectionUtil.isEmpty(array)) {
			throw new BaseException(errCode, errMsg);
		}
	}
}
