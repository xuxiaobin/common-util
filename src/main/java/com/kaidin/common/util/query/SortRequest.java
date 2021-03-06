/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.query;

import java.util.LinkedHashMap;
import java.util.Map;

import com.kaidin.common.util.collection.CollectionUtil;
import com.kaidin.common.util.StringUtil;
import com.kaidin.common.util.ToString;

/**
 * 页面查询传入的排序信息
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2015-6-23下午01:51:48
 */
public class SortRequest extends ToString {
	private static final long   serialVersionUID = -4902827484393351934L;
	private final Map<String, String> container        = new LinkedHashMap<>();

	public void addSort(String column) {
		container.put(column, "asc");
	}

	public void addSortDesc(String column) {
		container.put(column, "desc");
	}

	public Map<String, String> getSort() {
		return container;
	}

	public String toSortSql() {
		if (CollectionUtil.isEmpty(container)) {
			return StringUtil.EMPTY_STR;
		}

		StringBuilder resultBuild = new StringBuilder(" order by ");
		for (Map.Entry<String, String> entry : container.entrySet()) {
			resultBuild.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
		}
		int strLength = resultBuild.length();

		return resultBuild.substring(0, strLength - 2);
	}
}
