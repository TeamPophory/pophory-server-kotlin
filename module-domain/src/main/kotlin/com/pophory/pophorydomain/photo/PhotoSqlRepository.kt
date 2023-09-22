package com.pophory.pophorydomain.photo

import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface PhotoSqlRepository {

    @Query(
            "SELECT * FROM photo WHERE id=?1",
            nativeQuery = true
    )
    fun findById(id: Long): PhotoEntity
}