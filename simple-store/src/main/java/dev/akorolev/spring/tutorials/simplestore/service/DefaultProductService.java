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

package dev.akorolev.spring.tutorials.simplestore.service;

import dev.akorolev.spring.tutorials.simplestore.client.WarehouseClient;
import dev.akorolev.spring.tutorials.simplestore.dto.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    @Getter(AccessLevel.PROTECTED)
    private final WarehouseClient warehouseClient;

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.of(
                new Product(
                        name,
                        getWarehouseClient().getProductQuantity(name)
                )
        );
    }
}
