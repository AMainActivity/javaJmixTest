package com.company.kotlinjmix.entity

import io.jmix.core.DeletePolicy
import io.jmix.core.FileRef
import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.entity.annotation.OnDeleteInverse
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import jakarta.persistence.*
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import java.time.LocalDate
import java.util.*

@JmixEntity
@Table(name = "TASK_", indexes = [
    Index(name = "IDX_TASK__ASSIGNEE", columnList = "ASSIGNEE_ID"),
    Index(name = "IDX_TASK__PROJECT", columnList = "PROJECT_ID")
])
@Entity(name = "Task_")
open class Task {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "ATTACHMENT", length = 1024)
    var attachment: FileRef? = null

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    var name: String? = null

    @FutureOrPresent
    @Column(name = "DUE_DATE")
    var dueDate: LocalDate? = null

    @JoinColumn(name = "ASSIGNEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var assignee: User? = null

    @Column(name = "PRIORITY")
    private var priority: String? = null

    @Column(name = "DESCRIPTION")
    @Lob
    var description: String? = null

    @PositiveOrZero
    @Column(name = "ESTIMATION")
    var estimation: Int? = null

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var project: Project? = null

    fun getPriority(): TaskPriority? = priority?.let { TaskPriority.fromId(it) }

    fun setPriority(priority: TaskPriority?) {
        this.priority = priority?.id
    }
}