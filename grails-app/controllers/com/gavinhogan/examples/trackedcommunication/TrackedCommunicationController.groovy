package com.gavinhogan.examples.trackedcommunication

class TrackedCommunicationController {
    def linkTo(String id, String target){

        try{
            //Crude example of how you *could* increment
            // the counter. Real world examples might want
            // to record much more information about the click
            def tc = TrackedCommunication.findById(id)
            tc.hitCount++
            tc.save()
            log.info(tc.hitCount)
        }catch(Exception e){
            log.warn(e.message, e)
            //Maybe the entry was removed, migrated etc,
            // either way we should still honor the forward uri
        }finally{
            redirect(uri: target)
        }
    }
}
