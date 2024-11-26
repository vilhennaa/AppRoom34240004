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

package br.edu.up.rgm34240004.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.edu.up.rgm34240004.InventoryApplication
import br.edu.up.rgm34240004.ui.home.HomeViewModel
import br.edu.up.rgm34240004.ui.item.ItemDetailsViewModel
import br.edu.up.rgm34240004.ui.item.ItemEditViewModel
import br.edu.up.rgm34240004.ui.item.ItemEntryViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            br.edu.up.rgm34240004.ui.item.ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            br.edu.up.rgm34240004.ui.item.ItemEntryViewModel()
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            br.edu.up.rgm34240004.ui.item.ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer for HomeViewModel
        initializer {
            br.edu.up.rgm34240004.ui.home.HomeViewModel()
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): br.edu.up.rgm34240004.InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY] as br.edu.up.rgm34240004.InventoryApplication)
