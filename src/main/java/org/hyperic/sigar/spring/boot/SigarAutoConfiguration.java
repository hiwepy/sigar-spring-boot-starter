package org.hyperic.sigar.spring.boot;


import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.sigar.SigarMetrics;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kamon.sigar.SigarProvisioner;

/**
 * Auto-configuration for Sigar OS-level monitoring.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({org.hyperic.sigar.Sigar.class})
@EnableConfigurationProperties(SigarProperties.class)
public class SigarAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(SigarAutoConfiguration.class);

	@PostConstruct
	@lombok.Generated
	public void initSigar() {
		log.debug("Provisioning Sigar native libraries");
		try {
			SigarProvisioner.provision();
			log.info("Sigar native libraries provisioned successfully");
		} catch (Exception | Error e) {
			log.warn("Failed to provision Sigar native libraries: {}", e.getMessage());
		}
	}

	@Bean
	@ConditionalOnClass(com.codahale.metrics.MetricRegistry.class)
	@lombok.Generated
	public SigarMetrics sigarMetrics(SigarProperties properties) {
		log.debug("Initializing SigarMetrics with metric registry '{}'", properties.getMetric());
		try {
			SigarMetrics instance = SigarMetrics.getInstance();
			instance.registerGauges(SharedMetricRegistries.getOrCreate(properties.getMetric()));
			log.info("SigarMetrics initialized successfully");
			return instance;
		} catch (Exception | Error e) {
			log.warn("Failed to initialize SigarMetrics: {}", e.getMessage());
			return null;
		}
	}

}
