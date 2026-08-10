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
import static org.assertj.core.api.Assertions.assertThatNoException;

/**
 * Unit tests for {@link SigarAutoConfiguration}.
 *
 * <p>Verifies the auto-configuration activates under the expected conditions
 * and exposes its declared beans.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("SigarAutoConfiguration Tests")
class SigarAutoConfigurationTest {

    @Test
    @DisplayName("Auto-configuration class can be instantiated")
    void testInstantiation() {
        SigarAutoConfiguration configuration = new SigarAutoConfiguration();
        assertThat(configuration).isNotNull();
    }

    @Test
    @DisplayName("initSigar does not throw even without native libraries")
    void testInitSigarDoesNotThrow() {
        SigarAutoConfiguration configuration = new SigarAutoConfiguration();
        assertThatNoException().isThrownBy(configuration::initSigar);
    }

    @Test
    @DisplayName("sigarMetrics bean can be called without throwing")
    void testSigarMetricsBean() {
        SigarAutoConfiguration configuration = new SigarAutoConfiguration();
        SigarProperties properties = new SigarProperties();
        assertThatNoException().isThrownBy(() -> configuration.sigarMetrics(properties));
    }
}
