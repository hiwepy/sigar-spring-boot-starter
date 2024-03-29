/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.hyperic.sigar.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(SigarProperties.PREFIX)
public class SigarProperties{

	public static final String PREFIX = "sigar";

	private String metric = "sigar";

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getMetric() {
		return metric;
	}

}
