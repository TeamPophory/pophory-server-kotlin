package com.pophory.pophorydomain.studio

import com.pophory.pophorydomain.studio.QStudioEntity.*
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository


@Repository
class StudioQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun findAll(): List<StudioEntity>? {
        return jpaQueryFactory
            .selectFrom(studioEntity)
            .fetch()
    }
}