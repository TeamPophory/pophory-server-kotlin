package com.pophory.pophoryapi.member

import org.springframework.data.jpa.repository.JpaRepository
import com.pophory.pophorydomain.member.MemberEntity
import org.springframework.stereotype.Repository


@Repository
interface MemberJpaRepository : JpaRepository<MemberEntity, Long> {
}