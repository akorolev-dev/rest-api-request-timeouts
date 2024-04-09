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

package dev.akorolev.spring.tutorials.simplewarehouse.controller;

import dev.akorolev.spring.tutorials.simplewarehouse.dto.Warehouse;
import dev.akorolev.spring.tutorials.simplewarehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "quantity", produces = "application/json")
@RequiredArgsConstructor
public class QuantityController {
    private final WarehouseService warehouseService;

    @GetMapping(value = "/{productName}")
    public ResponseEntity<List<Warehouse>> getQuantityOfProduct(@PathVariable("productName") String productName) {
        return ResponseEntity.ok(
                warehouseService.getQuantityOfProduct(productName)
        );
    }
}
