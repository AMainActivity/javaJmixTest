package com.company.kotlinjmix.security

import io.jmix.security.role.annotation.ResourceRole

@ResourceRole(name = "CombineRole", code = CombineRole.CODE)
interface CombineRole : RestrictedProjectsRole, RestrictedTimeEntryRole {

    companion object {
        const val CODE = "combine-role"
    }
}