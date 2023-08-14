package com.pophory.pophorydomain.member

import com.pophory.pophorydomain.member.QMemberEntity.memberEntity
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.util.StringUtils
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MemberQueryRepository(
    private val queryFactory: JPAQueryFactory
) {
    fun findDynamicQuery(realName: String, nickname: String) : List<MemberEntity> {
        return queryFactory
            .selectFrom(memberEntity)
            .where(eqRealName(realName), eqNickname(nickname))
            .fetch()
    }

    private fun eqRealName(realName: String) : BooleanExpression? {
        if (StringUtils.isNullOrEmpty(realName)) {
            return null;
        }
        return memberEntity.realName.eq(realName)
    }

    private fun eqNickname(nickname: String) : BooleanExpression? {
        if (StringUtils.isNullOrEmpty(nickname)) {
            return null;
        }
        return memberEntity.nickname.eq(nickname)
    }

    @Transactional(readOnly = true)
    fun exist(memberId: Long) : Boolean {
        return queryFactory
            .selectOne()
            .from(memberEntity)
            .where(memberEntity.id.eq(memberId))
            .fetchOne() != null
    }

}