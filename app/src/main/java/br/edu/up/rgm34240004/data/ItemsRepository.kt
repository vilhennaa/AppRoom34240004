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

/**
 * Repository that provides insert, update, delete, and retrieve of [ItemEntity] from a given data source.
 */
interface ItemsRepository{

    suspend fun insert(
        name: String,
        price: Double,
        quantity: Int,
        id: Int? = null
    )

    suspend fun delete(id: Int)

    fun getAllItems(): Flow<List<Item>>

    fun getItem(id: Int): Item?
}
