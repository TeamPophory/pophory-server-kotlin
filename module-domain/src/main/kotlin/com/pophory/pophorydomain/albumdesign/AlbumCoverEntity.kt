package com.pophory.pophorydomain.albumdesign

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "album_cover")
class AlbumCoverEntity(
    @Id @GeneratedValue
    val id: Long,
    val coverNumber: Int,
    val theme: AlbumTheme,
    @OneToMany(mappedBy = "albumCover", cascade = [CascadeType.ALL])
    val albumDesigns: MutableList<AlbumDesignEntity> = mutableListOf()
) {

}