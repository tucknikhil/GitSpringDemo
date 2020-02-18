package com.valens.spring.web.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/apitest"))
class TestController {

  @GetMapping(Array("/test"))
  def getTest: ResponseEntity[String] = {
    ResponseEntity.ok("Test")
  }

}

