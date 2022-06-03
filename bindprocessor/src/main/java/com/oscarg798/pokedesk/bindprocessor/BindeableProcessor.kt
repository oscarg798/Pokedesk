package com.oscarg798.pokedesk.bindprocessor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.validate
import com.oscarg798.pokedesk.annotations.Bindeable
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.writeTo
import java.io.OutputStream

@OptIn(KotlinPoetKspPreview::class)
class BindeableProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver
            .getSymbolsWithAnnotation(Bindeable::class.qualifiedName!!)
            .filterIsInstance<KSClassDeclaration>()

        if (!symbols.iterator().hasNext()) return emptyList()

        val visitor = BindeableVisitor(logger)

        symbols.map {
            it.accept(visitor, Unit)
        }.forEach {
            it.writeTo(codeGenerator = codeGenerator, aggregating = true)
        }

        return symbols.filterNot { it.validate() }.toList()
    }

    operator fun OutputStream.plusAssign(str: String) {
        this.write(str.toByteArray())
        this.write("\n".toByteArray())
    }
}



