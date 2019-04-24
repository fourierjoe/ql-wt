package yhao.micro.service.constants.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Description: dozer包装类, 映射list集合
 * @Created by ql on 2019/1/8 14:48
 * @Version: v1.0
 */
public class WrapDozerUtil {

	private static DozerBeanMapper dozer = new DozerBeanMapper();

	public static <T> T map(Object source, Class<T> destinationClass) {
		return dozer.map(source, destinationClass);
	}

	/**
	 * 基于Dozer转换Collection中对象的类型.
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List<T> destinationList = Lists.newArrayList();
		if (null != sourceList) {
			for (Object sourceObject : sourceList) {
				T destinationObject = dozer.map(sourceObject, destinationClass);
				destinationList.add(destinationObject);
			}
		}
		return destinationList;
	}
}
