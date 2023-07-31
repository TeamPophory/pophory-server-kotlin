package com.pophory.pophorydomain.studio

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.util.Assert

@Entity
@Table(name = "studio")
class StudioEntity(
    @Id @GeneratedValue
    val id: Long,
    @Column(unique = true, nullable = false)
    val name: String,
    val imageUrl: String
) {
    fun validateNotNull() {
        Assert.notNull(name, "name must not be null")
    }
}