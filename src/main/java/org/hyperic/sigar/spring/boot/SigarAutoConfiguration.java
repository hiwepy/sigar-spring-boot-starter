package org.hyperic.sigar.spring.boot;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({org.hyperic.sigar.Sigar.class, com.codahale.metrics.MetricRegistry.class})
@ConditionalOnProperty(prefix = SigarProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties(SigarProperties.class)
public class SigarAutoConfiguration implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
 