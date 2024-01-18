package com.company.kotlinjmix.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.Composition
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.data.impl.lazyloading.NotInstantiatedList
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@JmixEntity
@Table(name = "PROJECT", indexes = [
    Index(name = "IDX_PROJECT_MANAGER", columnList = "MANAGER_ID")
])
@Entity
open class Project {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Composition
    @OneToMany(mappedBy = "project")
    var tasks: MutableList<Task> = NotInstantiatedList()

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    var name: String? = null

    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var manager: User? = null

    @Column(name = "DESCRIPTION")
    @Lob
    var description: String? = null

}