package com.pophory.pophoryapi.member

import com.pophory.pophoryapi.member.dto.response.MemberGetResponse
import com.pophory.pophorydomain.member.MemberEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(private val memberJpaRepository: MemberJpaRepository) {

    fun getMemberInfo(id: Long): MemberGetResponse {
        return MemberGetResponse.of(getMemberById(id))
    }

    private fun getMemberById(id: Long): MemberEntity {
        return memberJpaRepository.findById(id).orElseThrow { throw EntityNotFoundException("Member not found") }
    }
}