package com.oscarg798.pokedesk.bindprocessor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class BindleableSymbolProcessor : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return BindeableProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}