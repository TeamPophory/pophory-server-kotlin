package com.pophory.pophoryapi.member

import org.springframework.data.jpa.repository.JpaRepository
import com.pophory.pophorydomain.member.MemberEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Repository


@Repository
interface MemberJpaRepository : JpaRepository<MemberEntity, Long> {

    fun findByIdOrThrow(id: Long): MemberEntity {
        return findById(id).orElseThrow { throw EntityNotFoundException("Member not found") }
    }
}