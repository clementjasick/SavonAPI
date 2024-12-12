package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleDAO: JpaRepository<Role, Long> {
}