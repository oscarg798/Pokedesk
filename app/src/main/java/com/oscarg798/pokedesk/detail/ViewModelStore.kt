package com.oscarg798.pokedesk.detail

import androidx.lifecycle.ViewModel

class ViewModelStore {
    private val cachedViewModels = HashMap<String, ViewModel>()

    fun <T : ViewModel> get(key: String, create: () -> T) =
        cachedViewModels[key] ?: create.invoke().also {
            cachedViewModels[key] = it
        }
}

fun <T : ViewModel> ViewModelStore.viewModel(
    key: String,
    create: () -> T,
): T = get(key, create) as T
