package com.pophory.pophorydomain.albumdesign

import jakarta.persistence.*


@Entity
@Table(name = "album_design")
class AlbumDesignEntity(
    @Id @GeneratedValue
    val id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    val albumCover: AlbumCoverEntity,
    val imageUrl: String
) {
}