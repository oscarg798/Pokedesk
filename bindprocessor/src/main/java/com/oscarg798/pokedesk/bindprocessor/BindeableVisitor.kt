package com.oscarg798.pokedesk.bindprocessor

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSNode
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.visitor.KSEmptyVisitor
import com.oscarg798.pokedesk.annotations.Bindeable
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.toClassName
import com.squareup.kotlinpoet.ksp.toTypeName
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@OptIn(KotlinPoetKspPreview::class)
class BindeableVisitor(private val logger: KSPLogger) : KSEmptyVisitor<Unit, FileSpec>() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit): FileSpec {
        logger.info("Visiting ${classDeclaration.toClassName().simpleName}", classDeclaration)

        if (classDeclaration.classKind != ClassKind.CLASS) {
            logger.error("Only Classes can be annotated with @Bindeable", classDeclaration)
            throw IllegalStateException("$classDeclaration is not @Bindeable")
        }

        val className = "${classDeclaration.toClassName().simpleName}Module"
        val packageName = classDeclaration.toClassName().packageName

        val classTypeSpec =
            TypeSpec.classBuilder("${classDeclaration.toClassName().simpleName}Module")
                .addModifiers(KModifier.ABSTRACT)
                .addAnnotation(
                    AnnotationSpec.builder(InstallIn::class)
                        .addMember("%T::class", SingletonComponent::class)
                        .build()
                )
                .addAnnotation(AnnotationSpec.builder(Module::class).build())

        val bindleableAnnotation = classDeclaration.annotations.first {
            it.shortName.asString() == "Bindeable"
        }

        val bindType = bindleableAnnotation.arguments.first { arg ->
            arg.name?.asString() == Bindeable.BindTo
        }

        val scopeValue = bindleableAnnotation.arguments.first { arg ->
            arg.name?.asString() == Bindeable.Scope
        }

        classTypeSpec.addFunction(
            FunSpec.builder(
                "bind${
                    classDeclaration.simpleName.asString().capitalize()
                }"
            ).addModifiers(KModifier.ABSTRACT)
                .addParameter("implementor", classDeclaration.asType(listOf()).toTypeName())
                .addAnnotation((scopeValue.value as KSType).toClassName())
                .addAnnotation(AnnotationSpec.builder(Binds::class).build())
                .returns((bindType.value as KSType).toTypeName())
                .build()
        )

        return FileSpec.builder(packageName, className)
            .addType(classTypeSpec.build())
            .build()
    }

    override fun defaultHandler(node: KSNode, data: Unit): FileSpec {
        TODO()
    }
}