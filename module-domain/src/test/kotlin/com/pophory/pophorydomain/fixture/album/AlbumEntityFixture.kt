package com.pophory.pophorydomain.fixture.album

import com.pophory.pophorydomain.album.AlbumEntity
import com.pophory.pophorydomain.fixture.member.MemberEntityFixture
import com.pophory.pophorydomain.member.MemberEntity
import java.time.LocalDateTime

class AlbumEntityFixture {

    companion object {
        private const val ID = 1L
        private const val TITLE = "title"
        fun createAlbumEntity() : AlbumEntity{
            return AlbumEntity(
                    id = ID,
                    title =  TITLE,
                    photoLimit = 15,
                    imageUrl = "image url",
                    deletedAt = LocalDateTime.now(),
                    isDeleted = false,
                    member =  MemberEntityFixture.createMemberEntity()
                    )
        }
    }
}