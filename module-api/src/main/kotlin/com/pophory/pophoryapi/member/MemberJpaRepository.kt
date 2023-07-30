package com.pophory.pophoryapi.member

import org.springframework.data.jpa.repository.JpaRepository
import com.pophory.pophorydomain.member.MemberEntity
interface MemberJpaRepository :JpaRepository<MemberEntity, Long> {
}