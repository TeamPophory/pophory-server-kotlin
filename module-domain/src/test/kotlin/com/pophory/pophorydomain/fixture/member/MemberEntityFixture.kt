package com.pophory.pophorydomain.fixture.member

import com.pophory.pophorydomain.member.MemberEntity
import com.pophory.pophorydomain.member.SocialType
import java.time.LocalDateTime

class MemberEntityFixture {
    companion object {
        private val ID = 1L
        private val REAL_NAME = "realName"
        private val NICKNAME = "nickname"
        private val PROFILE_IMAGE_URL = "profileImageUrl"
        private val POPHORY_ID = "12345668"
        private val IS_DELETED = false
        private val FCM_TOKEN = "fcmToken"
        private val SOCIAL: SocialType = SocialType.KAKAO
        private val REFRESH_TOKEN = "refreshToken"

        fun createMemberEntity(): MemberEntity {
            return MemberEntity(
                id = ID,
                realName = REAL_NAME,
                nickname = NICKNAME,
                profileImageUrl = PROFILE_IMAGE_URL,
                pophoryId = POPHORY_ID,
                isDeleted = IS_DELETED,
                fcmToken = FCM_TOKEN,
                social = SOCIAL,
                refreshToken = REFRESH_TOKEN,
                deletedAt = LocalDateTime.now().plusDays(7L)
            )
        }
    }
}