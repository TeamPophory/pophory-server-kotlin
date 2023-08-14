package com.pophory.pophoryapi.studio.dto.response

import com.pophory.pophorydomain.studio.StudioEntity

data class StudioGetResponse(
    val id: Long,

    val name: String
) {

    companion object {
        fun of(studio: StudioEntity): StudioGetResponse {
            return StudioGetResponse(
                id = studio.id,
                name = studio.name
            )
        }
    }
}