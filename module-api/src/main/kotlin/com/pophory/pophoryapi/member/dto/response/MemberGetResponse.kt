package com.pophory.pophoryapi.member.dto.response

import com.pophory.pophorydomain.member.MemberEntity

data class MemberGetResponse(
    val id: Long,
    val realName: String,
    val nickname: String,
    val profileImageUrl: String
) {
    companion object {
        fun of(member: MemberEntity): MemberGetResponse {
            return MemberGetResponse(
                id = member.id,
                realName = member.realName,
                nickname = member.nickname,
                profileImageUrl = member.profileImageUrl
            )
        }
    }
}