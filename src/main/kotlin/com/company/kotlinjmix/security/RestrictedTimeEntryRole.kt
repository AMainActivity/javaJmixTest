package com.company.kotlinjmix.security

import com.company.kotlinjmix.entity.TimeEntry
import io.jmix.security.role.annotation.JpqlRowLevelPolicy
import io.jmix.security.role.annotation.RowLevelRole


@RowLevelRole(name = "RestrictedTimeEntry", code = RestrictedTimeEntryRole.CODE)
interface RestrictedTimeEntryRole {
    @JpqlRowLevelPolicy(
        entityClass = TimeEntry::class,
        where = "{E}.user.username=:current_user_username or {E}.task.project.manager.username=:current_user_username"
    )
    fun timeEntry()

    companion object {
        const val CODE = "restricted-time-entry"
    }
}