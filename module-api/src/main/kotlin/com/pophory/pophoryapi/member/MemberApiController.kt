package com.pophory.pophoryapi.member

import com.pophory.pophoryapi.member.dto.response.MemberGetResponse
import com.pophory.pophorydomain.common.common.ApiController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping

@ApiController
class MemberApiController(private val memberService: MemberService) {

    @GetMapping("/v2/member")
    fun getMemberInfo(memberId: Long): ResponseEntity<MemberGetResponse> {
        return ResponseEntity.ok(memberService.getMemberInfo(memberId))
    }

    @DeleteMapping("/v2/member")
    fun deleteMember(memberId: Long): ResponseEntity<Unit> {
        memberService.deleteMember(memberId)
        return ResponseEntity.ok().build()
    }
}