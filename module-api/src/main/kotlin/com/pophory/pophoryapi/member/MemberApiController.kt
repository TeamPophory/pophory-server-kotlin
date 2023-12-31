package com.pophory.pophoryapi.member

import com.pophory.pophoryapi.member.dto.request.MemberUpdateRequest
import com.pophory.pophoryapi.member.dto.response.MemberGetResponse
import com.pophory.pophorydomain.common.common.ApiController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody

@ApiController
class MemberApiController(private val memberService: MemberService) {

    @GetMapping("/v2/member")
    fun getMemberInfo(memberId: Long): ResponseEntity<MemberGetResponse> {
        return ResponseEntity.ok(memberService.getMemberInfo(memberId))
    }

    @DeleteMapping("/v2/member")
    fun deleteMember(memberId: Long): ResponseEntity<Unit> {
        memberService.delete(memberId)
        return ResponseEntity.ok().build()
    }

    @PatchMapping("/v2/member")
    fun updateMember(@RequestBody request: MemberUpdateRequest, memberId: Long): ResponseEntity<Unit> {
        memberService.update(request, memberId)
        return ResponseEntity.ok().build()
    }
}