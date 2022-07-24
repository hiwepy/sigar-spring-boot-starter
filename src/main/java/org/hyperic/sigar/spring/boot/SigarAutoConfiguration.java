package org.hyperic.sigar.spring.boot;

import javax.annotation.PostConstruct;

import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.sigar.SigarMetrics;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kamon.sigar.SigarProvisioner;

@Configuration
@ConditionalOnClass({org.hyperic.sigar.Sigar.class})
@EnableConfigurationProperties(SigarProperties.class)
public class SigarAutoConfiguration{

	@PostConstruct
	public void initSigar() throws Exception {
		SigarProvisioner.provision();
	}

	@Bean
	@ConditionalOnClass(com.codahale.metrics.MetricRegistry.class)
	public SigarMetrics sigarMetrics(SigarProperties properties){
		SigarMetrics instance = SigarMetrics.getInstance();
		instance.registerGauges(SharedMetricRegistries.getOrCreate(properties.getMetric()));
		return instance;
	}

}
