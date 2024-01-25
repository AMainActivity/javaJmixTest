package com.company.kotlinjmix.security

import com.company.kotlinjmix.entity.*
import io.jmix.security.model.EntityAttributePolicyAction
import io.jmix.security.model.EntityPolicyAction
import io.jmix.security.role.annotation.EntityAttributePolicy
import io.jmix.security.role.annotation.EntityAttributePolicyContainer
import io.jmix.security.role.annotation.EntityPolicy
import io.jmix.security.role.annotation.ResourceRole
import io.jmix.securityflowui.role.annotation.MenuPolicy
import io.jmix.securityflowui.role.annotation.ViewPolicy

@ResourceRole(name = "ProjectManager", code = ProjectManagerRole.CODE)
interface ProjectManagerRole {

    companion object {
        const val CODE = "project-manager"
    }

    @EntityAttributePolicyContainer(
            EntityAttributePolicy(entityClass = Project::class, attributes = ["*"], action = EntityAttributePolicyAction.MODIFY))
    @EntityPolicy(
            entityClass = Project::class,
            actions = [EntityPolicyAction.ALL])
    fun project()

    @EntityAttributePolicyContainer(
            EntityAttributePolicy(entityClass = Task::class, attributes = ["*"], action = EntityAttributePolicyAction.MODIFY))
    @EntityPolicy(
            entityClass = Task::class,
            actions = [EntityPolicyAction.ALL])
    fun task()

    @EntityAttributePolicyContainer(
            EntityAttributePolicy(entityClass = TimeEntry::class, attributes = ["*"], action = EntityAttributePolicyAction.MODIFY))
    @EntityPolicy(
            entityClass = TimeEntry::class,
            actions = [EntityPolicyAction.ALL])
    fun timeEntry()

    @EntityAttributePolicyContainer(
            EntityAttributePolicy(entityClass = User::class, attributes = ["id", "avatar", "version", "username", "password", "email", "active", "timeZoneId"], action = EntityAttributePolicyAction.VIEW),
            EntityAttributePolicy(entityClass = User::class, attributes = ["firstName", "lastName"], action = EntityAttributePolicyAction.MODIFY))
    @EntityPolicy(
            entityClass = User::class,
            actions = [EntityPolicyAction.READ, EntityPolicyAction.UPDATE])
    fun user()

    @EntityAttributePolicyContainer(
            EntityAttributePolicy(entityClass = ProjectStats::class, attributes = ["*"], action = EntityAttributePolicyAction.VIEW))
    @EntityPolicy(
            entityClass = ProjectStats::class,
            actions = [EntityPolicyAction.READ])
    fun projectStats()

    @MenuPolicy(menuIds = ["User.list", "Project.list", "Task_.list", "TimeEntry.list", "ProjectStats.list"])
    @ViewPolicy(viewIds = ["User.list", "Project.list", "Task_.list", "TimeEntry.list", "ProjectStats.list", "Project.detail", "Task_.detail", "TimeEntry.detail", "User.detail"])
    fun screens()
}