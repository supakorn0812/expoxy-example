package com.android.epoxytest.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.android.epoxytest.storeLocation

class StoreLocationController : TypedEpoxyController<Unit>() {
    override fun buildModels(data: Unit?) {
        (0..100).forEach { index ->
            storeLocation {
                id("store_location_$index")
            }
        }
    }
}