package com.pophory.pophorydomain.fcm

import com.pophory.pophorydomain.member.MemberEntity
import jakarta.persistence.*


@Entity
@Table
class FcmEntity(
        @Id @GeneratedValue
        val id:Long,
        @Column(nullable = false)
        val fcmOs: FcmOS,
        @Column(nullable = false)
        val fcmToken: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        val member: MemberEntity
) {
}