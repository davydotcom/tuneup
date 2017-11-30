package com.bertramlabs.plugins

import com.bertramlabs.plugins.tuneup.TuneUpMetricInterceptor
import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class TuneUpMetricInterceptorSpec extends Specification implements InterceptorUnitTest<TuneUpMetricInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test tuneUpMetric interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"tuneUpMetric")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
