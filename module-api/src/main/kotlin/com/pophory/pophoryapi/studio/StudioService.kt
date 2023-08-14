package com.pophory.pophoryapi.studio

import com.pophory.pophoryapi.studio.dto.response.StudioGetResponse
import com.pophory.pophorydomain.studio.StudioEntity
import com.pophory.pophorydomain.studio.StudioQueryRepository
import org.springframework.stereotype.Service

@Service
class StudioService(private val studioQueryRepository: StudioQueryRepository) {
    fun getStudios(): List<StudioGetResponse>? {
        val studios: List<StudioEntity>? = studioQueryRepository.findAll()
        return studios?.map { StudioGetResponse.of(it) }
    }
}