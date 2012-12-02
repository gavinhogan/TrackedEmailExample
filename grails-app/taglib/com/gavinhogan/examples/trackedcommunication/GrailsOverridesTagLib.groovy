package com.gavinhogan.examples.trackedcommunication

class GrailsOverridesTagLib {
    static String namespace = "g"

    def getGrailsTagLib(){
        return grailsApplication
                .mainContext
                .getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib')
    }

    def link = { attrs, body->
        if(pageScope.trackedCommunication in TrackedCommunication){
            attrs.absolute = true
            def targetUri = g.createLink(attrs, body)
            def newAttrs = [
                    controller:'trackedCommunication',
                    action: 'linkTo',
                    id:pageScope.trackedCommunication.id,
                    absolute:true, params:[target:targetUri]
            ]
            getGrailsTagLib().link.call(newAttrs, body)
        } else{
            getGrailsTagLib().link.call(attrs, body)
        }
    }
}
