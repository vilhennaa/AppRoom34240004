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

@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.up.rgm34240004

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import br.edu.up.rgm34240004.R.string
import br.edu.up.rgm34240004.ui.navigation.InventoryNavHost

/**
 * Top level composable that represents screens for the application.
 */
@androidx.compose.runtime.Composable
fun InventoryApp(navController: androidx.navigation.NavHostController = androidx.navigation.compose.rememberNavController()) {
    br.edu.up.rgm34240004.ui.navigation.InventoryNavHost(navController = navController)
}

/**
 * App bar to display title and conditionally display the back navigation.
 */
@androidx.compose.runtime.Composable
fun InventoryTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier.Companion,
    scrollBehavior: androidx.compose.material3.TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    androidx.compose.material3.CenterAlignedTopAppBar(
        title = { androidx.compose.material3.Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                androidx.compose.material3.IconButton(onClick = navigateUp) {
                    androidx.compose.material3.Icon(
                        imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                        contentDescription = androidx.compose.ui.res.stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
