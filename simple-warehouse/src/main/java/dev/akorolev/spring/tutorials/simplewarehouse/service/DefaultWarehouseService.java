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

package dev.akorolev.spring.tutorials.simplewarehouse.service;

import dev.akorolev.spring.tutorials.simplewarehouse.dto.Warehouse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DefaultWarehouseService implements WarehouseService {
    private static final int MAXIMUM_PRODUCT_QUANTITY = 100;
    private static final Map<String, String> warehouseList = Map.of(
            "Центральный", "Москва",
            "Дальневосточный", "Хабаровск",
            "Европейский", "Калининград"
    );

    @Override
    public List<Warehouse> getQuantityOfProduct(String productName) {
        var result = new ArrayList<Warehouse>(warehouseList.size());

        warehouseList.forEach(
                (warehouseName, city) -> result.add(
                        new Warehouse(
                                warehouseName,
                                city,
                                ThreadLocalRandom.current().nextInt(MAXIMUM_PRODUCT_QUANTITY)
                        )
                )
        );

        return result;
    }
}
