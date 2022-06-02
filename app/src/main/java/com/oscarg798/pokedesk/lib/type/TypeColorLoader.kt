package com.oscarg798.pokedesk.lib.type

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oscarg798.pokedesk.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypeColorLoader @Inject constructor(
    private val gson: Gson,
    @ApplicationContext
    private val context: Context
) {

    fun getTypeColors(): Set<TypeColor> {
        val file = context.resources.openRawResource(R.raw.type_colors)
        val type = object : TypeToken<List<TypeColor>>() {}.type

        return gson.fromJson<List<TypeColor>>(InputStreamReader(file), type).toSet()
    }
}
