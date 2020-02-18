/**
 * Please refer to https://www.justanalytics.com/guzzle/eula for current EULA
 */
package com.valens.spring

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
//@EnableConfigurationProperties(Array(classOf[ApplicationProperties], classOf[DataSourceProperties]))
class SpringAPIConf {

}

object SpringAPIApplication extends App {
	SpringApplication.run(classOf[SpringAPIConf])
}