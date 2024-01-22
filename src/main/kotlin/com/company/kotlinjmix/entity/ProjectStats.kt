package com.company.kotlinjmix.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.entity.annotation.JmixId
import io.jmix.core.metamodel.annotation.JmixEntity
import java.util.*

@JmixEntity
open class ProjectStats {
    @JmixId
    var id: UUID? = null

    var projectName: String? = null

    var tasksCount: Int? = null

    var plannedEfforts: Int? = null

    var actualEfforts: Int? = null
}