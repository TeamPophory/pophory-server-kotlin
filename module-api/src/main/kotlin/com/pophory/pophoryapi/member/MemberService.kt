package com.pophory.pophoryapi.member

import com.pophory.pophoryapi.member.dto.response.MemberGetResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(private val memberJpaRepository: MemberJpaRepository) {

    fun getMemberInfo(id: Long): MemberGetResponse {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id))
    }

    fun deleteMember(id: Long) {
        memberJpaRepository.deleteById(id)
    }
}