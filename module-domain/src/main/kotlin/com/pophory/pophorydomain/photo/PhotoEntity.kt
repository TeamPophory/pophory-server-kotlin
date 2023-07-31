package com.pophory.pophorydomain.photo

import com.pophory.pophorydomain.album.AlbumEntity
import com.pophory.pophorydomain.studio.StudioEntity
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import java.time.LocalDate

@Entity
@Table(name = "photo")
class PhotoEntity(
    @Id @GeneratedValue
    val id: Long,
    val imageUrl: String,
    val shareId: String,
    @Column(nullable = false)
    val width: Int,
    @Column(nullable = false)
    val height: Int,
    val takenAt: LocalDate,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "album_id")
    val album: AlbumEntity,
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "studio_id")
    val studio: StudioEntity,
    var isDeleted: Boolean = false,
    var deletedAt: LocalDate? = null

) {
}