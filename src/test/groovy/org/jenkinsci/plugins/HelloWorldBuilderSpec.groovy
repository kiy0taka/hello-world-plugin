package org.jenkinsci.plugins

import spock.lang.*
import org.junit.Rule
import org.jvnet.hudson.test.JenkinsRule

class HelloWorldBuilderSpec extends Specification {

    @Rule
    JenkinsRule rule = new JenkinsRule()

    def 'say Hello'() {
        given:
        def builder = new HelloWorldBuilder('kiy0taka')

        and:
        def job = rule.createFreeStyleProject()
        job.buildersList.add(builder)

        when:
        def build = job.scheduleBuild2(0).get()

        then:
        build.logFile.text.contains("Hello, kiy0taka!")
    }

    def 'say Bonjour'() {
        given:
        def builder = new HelloWorldBuilder('kiy0taka')
        builder.descriptor.useFrench = true

        and:
        def job = rule.createFreeStyleProject()
        job.buildersList.add(builder)

        when:
        def build = job.scheduleBuild2(0).get()

        then:
        build.logFile.text.contains("Bonjour, kiy0taka!")
    }
}