package com.pophory.pophoryapi.member

import com.pophory.pophoryapi.member.dto.request.MemberUpdateRequest
import com.pophory.pophoryapi.member.dto.response.MemberGetResponse
import com.pophory.pophorydomain.member.MemberEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(private val memberJpaRepository: MemberJpaRepository) {

    fun getMemberInfo(id: Long): MemberGetResponse {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id))
    }

    @Transactional
    fun delete(id: Long) {
        memberJpaRepository.deleteById(id)
    }

    @Transactional
    fun update(request: MemberUpdateRequest, id: Long) {
        val member:MemberEntity = memberJpaRepository.findByIdOrThrow(id)
        member.realName = request.realName
        member.nickname = request.nickname
    }
}