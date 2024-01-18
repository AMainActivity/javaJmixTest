package com.company.kotlinjmix.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.*

@JmixEntity
@Table(name = "TIME_ENTRY", indexes = [
    Index(name = "IDX_TIME_ENTRY_TASK", columnList = "TASK_ID"),
    Index(name = "IDX_TIME_ENTRY_USER", columnList = "USER_ID")
])
@Entity
open class TimeEntry {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @JoinColumn(name = "TASK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var task: Task? = null

    @Column(name = "TIME_SPENT", nullable = false)
    @NotNull
    var timeSpent: Int? = null

    @Column(name = "ENTRY_DATE", nullable = false)
    @NotNull
    var entryDate: LocalDateTime? = null

    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var user: User? = null

    @InstanceName
    @Column(name = "DESCRIPTION")
    @Lob
    var description: String? = null
}