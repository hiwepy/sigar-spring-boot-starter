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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link SigarProperties}.
 *
 * <p>Verifies default values, getters/setters and POJO contract.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("SigarProperties Tests")
class SigarPropertiesTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        SigarProperties props = new SigarProperties();
        assertThat(props).isNotNull();
    }

    @Test
    @DisplayName("Default metric value is 'sigar'")
    void testDefaultMetricValue() {
        SigarProperties props = new SigarProperties();
        assertThat(props.getMetric()).isEqualTo("sigar");
    }

    @Test
    @DisplayName("Field 'metric' can be set and read via getter/setter")
    void testMetricFieldGetterSetter() {
        SigarProperties props = new SigarProperties();
        props.setMetric("custom-metric");
        assertThat(props.getMetric()).isEqualTo("custom-metric");
    }

    @Test
    @DisplayName("Public constant 'PREFIX' has expected value")
    void testPREFIXConstant() {
        assertThat(SigarProperties.PREFIX).isEqualTo("sigar");
    }

    @Test
    @DisplayName("Setting metric to null works")
    void testMetricNull() {
        SigarProperties props = new SigarProperties();
        props.setMetric(null);
        assertThat(props.getMetric()).isNull();
    }

    @Test
    @DisplayName("Setting metric to empty string works")
    void testMetricEmpty() {
        SigarProperties props = new SigarProperties();
        props.setMetric("");
        assertThat(props.getMetric()).isEmpty();
    }
}
