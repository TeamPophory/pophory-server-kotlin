package com.pophory.pophoryapi.studio

import com.pophory.pophoryapi.studio.dto.response.StudioGetResponse
import com.pophory.pophorydomain.common.common.ApiController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@ApiController
class StudioController(private val studioService: StudioService) {

    @GetMapping("/v2/studio")
    fun getStudios() : ResponseEntity<List<StudioGetResponse>>{
        return ResponseEntity.ok(studioService.getStudios())
    }
}