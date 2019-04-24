package yhao.micro.web.surety.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yhao.infra.common.ContextHolder;
import yhao.infra.web.interceptor.ZBaseInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上下文拦截器，用于往上下文中放入必要的信息
 */
public class ContextInterceptor extends ZBaseInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		try {
			ContextHolder.setDataSource(DataSource.WEB_ERP);
			return super.preHandle(request, response, handler);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage());
		}
	}

	enum DataSource implements ContextHolder.DataSourceContextKey {
		WEB_ERP
	}
}
