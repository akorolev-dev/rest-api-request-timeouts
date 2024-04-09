/*
 * Copyright 2024 Aleksei Korolev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.akorolev.spring.tutorials.simplestore.config;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties(WarehouseClientProperty.PREFIX)
@Validated
public record WarehouseClientProperty(@NotEmpty @URL String baseUrl, Duration connectTimeout, Duration readTimeout) {
    public static final String PREFIX = "services.warehouse";
    static final Duration DEFAULT_TIMEOUT_DURATION = Duration.ZERO;
    public WarehouseClientProperty {
        if (connectTimeout == null) {
            connectTimeout = DEFAULT_TIMEOUT_DURATION;
        }

        if (readTimeout == null) {
            readTimeout = DEFAULT_TIMEOUT_DURATION;
        }
    }
}
