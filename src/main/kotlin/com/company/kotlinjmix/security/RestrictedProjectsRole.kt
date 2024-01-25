package com.company.kotlinjmix.security

import com.company.kotlinjmix.entity.Project
import com.company.kotlinjmix.entity.User
import com.github.javaparser.utils.Log
import io.jmix.core.security.CurrentAuthentication
import io.jmix.security.model.RowLevelBiPredicate
import io.jmix.security.model.RowLevelPolicyAction
import io.jmix.security.role.annotation.PredicateRowLevelPolicy
import io.jmix.security.role.annotation.RowLevelRole
import org.springframework.context.ApplicationContext


@RowLevelRole(name = "RestrictedProjectsRole", code = RestrictedProjectsRole.CODE)
interface RestrictedProjectsRole {

    companion object {
        const val CODE = "restricted-projects-role"
    }

    @PredicateRowLevelPolicy(
        entityClass = Project::class,
        actions = [RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE]
    )
    fun projectPredicate(): RowLevelBiPredicate<Project, ApplicationContext> {
        return RowLevelBiPredicate { project, applicationContext ->
            val currentAuthentication = applicationContext.getBean(CurrentAuthentication::class.java)
            val curUser = currentAuthentication.user as User
         //   curUser.username.equals(project.manager?.username)
            true
        }
    }
}