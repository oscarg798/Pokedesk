package com.oscarg798.pokedesk.annotations

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class Bindeable(val bindTo: KClass<*>, val scope: KClass<*>){

    companion object {
        const val BindTo = "bindTo"
        const val Scope = "scope"
    }
}