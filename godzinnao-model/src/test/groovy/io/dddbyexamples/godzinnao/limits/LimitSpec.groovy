package io.dddbyexamples.godzinnao.limits

import spock.lang.PendingFeature
import spock.lang.Specification

import java.time.Duration

class LimitSpec extends Specification {

    LimitEvents events = Mock(LimitEvents)
    private String employeeId = "marek"

    def "new limit for an employee is defined"() {
        given: "there are not limits for the employee"
        def subject = noLimitsDefined()
        when: "we try define limit for the employee"
        subject.define(employeeLimit(Duration.ofHours(8)))
        then: "limit is defined"
        1 * events.emit(eventLimitDefined(Duration.ofHours(8)))
    }

    def "two daily limits for employee cannot be defined"() {
        given: "limit for some employee"
        def subject = singleLimitForEmployee(Duration.ofHours(8))
        when: "we try define limit for the same employee"
        subject.define(employeeLimit(Duration.ofHours(12)))
        then: "old limit is redefined"
        1 * events.emit(eventLimitRedefined(Duration.ofHours(12)))
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
        thrown(IllegalStateException)
    }

    def "limit 24/a day or more day for an employee cannot be created"() {
        given: "there are not limits for the employee"
        def subject = noLimitsDefined()
        when: "we try define limit limit 24/a day the same employee"
        subject.define(employeeLimit(Duration.ofHours(26)))
        then: "error is raised"
        thrown(IllegalArgumentException)
    }

    def "limit 24/a day for an employee cannot be deleted"() {

    }

    def "delete of employee limit returns to default 24/day limit"() {
        given: "limit for some employee"
        when: "we delete limit for the same employee"
        then: "default limit 24/day is defined"
    }

    private LimitRedefined eventLimitRedefined(Duration hours) {
        new LimitRedefined(employeeId, hours)
    }

    private LimitDefined eventLimitDefined(Duration hours) {
        new LimitDefined(employeeId, hours)
    }

    private EmployeeLimit employeeLimit(Duration hours) {
        new EmployeeLimit(employeeId, hours)
    }

    private def noLimitsDefined() {
        new EmployeeLimitDefinition(employeeId, null, events)
    }

    private def singleLimitForEmployee(Duration limit) {
        new EmployeeLimitDefinition(employeeId, new LimitDefined(employeeId, limit), events)
    }
}







