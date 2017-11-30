package com.bertramlabs.plugins.tuneup

class UrlMappings {

    static mappings = {
        "/tuneup"(resources: 'slowTransactions', namespace: 'tuneup')
    }
}
