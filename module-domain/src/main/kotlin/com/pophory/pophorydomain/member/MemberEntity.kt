package com.pophory.pophorydomain.member

import com.pophory.pophorydomain.common.entity.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.util.Assert
import java.time.LocalDateTime

@Table(name = "member")
@Entity
class MemberEntity (
    @Id @GeneratedValue
    val id: Long = 0,
    @Enumerated(value = EnumType.STRING)
    val social:SocialType,
    val name: String,
    @Column(length = 6)
    val realName: String,
    @Column(length = 15, unique = true)
    val nickname: String,
    val profileImageUrl: String,
    val refreshToken: String,
    @Column(length = 8, nullable = false)
    val pophoryId: String,
    val fcmToken: String,
    val isDeleted: Boolean = false,
    val deletedAt: LocalDateTime
) : BaseTimeEntity() {
    fun validateNotNull() {
        Assert.notNull(social, "social must not be null")
        Assert.notNull(pophoryId, "pophory must not be null")
    }

}