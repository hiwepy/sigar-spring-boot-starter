package org.hyperic.sigar.spring.boot;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import kamon.sigar.SigarProvisioner;

@Configuration
@ConditionalOnClass({org.hyperic.sigar.Sigar.class, com.codahale.metrics.MetricRegistry.class})
@ConditionalOnProperty(prefix = SigarProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties(SigarProperties.class)
public class SigarAutoConfiguration{
	
	@PostConstruct
	public void initSigar() throws Exception {
		SigarProvisioner.provision();
	}

}
 