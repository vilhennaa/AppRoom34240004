/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.edu.up.rgm34240004.data

import br.edu.up.rgm34240004.domain.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemsRepositoryImpl(
    private val dao: ItemDao
) : ItemsRepository {

    override suspend fun insert(
        name: String,
        price: Double,
        quantity: Int,
        id: Int?
    ) {
        val item = id?.let {
            dao.getItem(it)?.copy(
                name = name,
                price = price,
                quantity = quantity
            )
        } ?: ItemEntity(
            name = name,
            price = price,
            quantity = quantity
        )
        dao.insert(item)
    }

    override suspend fun delete(id: Int) {
        val existingItem = dao.getItem(id) ?: return
        dao.delete(existingItem)
    }

    override fun getAllItems(): Flow<List<Item>> {
        return dao.getAllItems().map { items ->
            items.map { item ->
                Item(
                    id = item.id,
                    name = item.name,
                    price = item.price,
                    quantity = item.quantity
                )
            }
        }
    }

    override fun getItem(id: Int): Item? {
        return dao.getItem(id)?.let { item ->
            Item(
                id = item.id,
                name = item.name,
                price = item.price,
                quantity = item.quantity
            )
        }
    }
}
