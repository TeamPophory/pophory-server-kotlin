package com.pophory.pophorydomain.albumdesign

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "album_cover")
class AlbumCoverEntity(
    @Id @GeneratedValue
    val id: Long,
    val coverNumber: Int,
    val theme: AlbumTheme
) {

}