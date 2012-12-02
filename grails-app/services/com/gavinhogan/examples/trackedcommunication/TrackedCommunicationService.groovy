package com.gavinhogan.examples.trackedcommunication

class TrackedCommunicationService {
    def mailService
    def outBoundSenderAddress

    def send(TrackedCommunication communication) {
        communication.save()
        mailService.sendMail{
            to(communication.receiver)
            from(outBoundSenderAddress)
            subject(communication.subject)
            body(view: communication.templatePath, model:[trackedCommunication: communication])
        }
    }
}
