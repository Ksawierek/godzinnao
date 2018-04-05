package io.dddbyexamples.godzinnao.limits

import spock.lang.PendingFeature
import spock.lang.Specification

class LimitSpec extends Specification {

    def "new limit for an employee is defined"() {
        given: "there are not limits for the employee"
        when: "we try define limit for the employee"
        then: "limit is defined"
    }

    def "new limit for a task is defined"() {
        given: "there are not limits for the task"
        when: "we try define limit for the task"
        then: "limit is defined"
    }

    def "new limit for a project is defined"() {
        given: "there are not limits for the project"
        when: "we try define limit for the project"
        then: "limit is defined"
    }

    def "two project limits cannot be defined"() {
        given: "limit for some project"
        when: "we try define limit for the same project"
        then: "old limit is redefined"
    }

    def "two daily limits for employee cannot be defined"() {
        given: "limit for some employee"
        when: "we try define limit for the same employee"
        then: "old limit is redefined"
    }

    def "two tasks limits for the same task cannot be defined"() {
        given: "limit for some task"
        when: "we try define limit for the same task"
        then: "old limit is redefined"
    }

    @PendingFeature
    def "error notification instead of redefining limit"() {
        given: "limit for some task"
        when: "we try define limit for the same task"
        then: "new limit cannot be created"
        throw new IllegalStateException()
    }


    def "limit 24/a day or more day for an employee cannot be created"() {
        given: "there are not limits for the employee"
        when: "we try define limit limit 24/a day the same employee"
        then: "error is raised"
    }

    def "limit 24/a day for an employee cannot be deleted"() {

    }

    def "delete of employee limit returns to default 24/day limit"() {
        given: "limit for some employee"
        when: "we delete limit for the same employee"
        then: "default limit 24/day is defined"
    }
}









