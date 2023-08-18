package com.pophory.pophorydomain.album

import com.pophory.pophorydomain.member.MemberEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "album")
class AlbumEntity(
    @Id @GeneratedValue
    val id: Long,
    val title: String = "기본 앨범",
    val photoLimit: Int = 0,
    val imageUrl: String? = null,
    var isDeleted: Boolean = false,
    var deletedAt: LocalDateTime? = null,
    @JoinColumn(name = "member_id")
    @OneToOne(fetch = FetchType.LAZY)
    var member: MemberEntity
) {
    private val ALBUM_STORAGE_EXPIRATION = 7L
    fun softDelete() {
        this.isDeleted = true
        this.deletedAt = LocalDateTime.now().plusDays(ALBUM_STORAGE_EXPIRATION)
    }

    fun validateAlbum() {
        if (this.photoLimit < 0) {
            throw IllegalArgumentException("photoLimit must be positive")
        }
    }

}