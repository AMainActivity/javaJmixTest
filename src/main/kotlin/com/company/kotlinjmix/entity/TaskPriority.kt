package com.company.kotlinjmix.entity

import io.jmix.core.metamodel.datatype.EnumClass

enum class TaskPriority(private val id: String) : EnumClass<String> {
    HIGH("A"),
    MEDIUM("B"),
    LOW("C");

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): TaskPriority? = TaskPriority.values().find { it.id == id }
    }
}