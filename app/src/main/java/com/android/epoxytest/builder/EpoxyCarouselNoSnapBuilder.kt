package com.android.epoxytest.builder

import android.content.Context
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelCollector
import com.airbnb.epoxy.ModelView

fun ModelCollector.carouselNoSnapBuilder(builder: EpoxyCarouselNoSnapBuilder.() -> Unit): CarouselNoSnapModel_ {
    val carouselBuilder = EpoxyCarouselNoSnapBuilder().apply { builder() }
    add(carouselBuilder.carouselNoSnapModel)
    return carouselBuilder.carouselNoSnapModel
}

class EpoxyCarouselNoSnapBuilder(
    internal val carouselNoSnapModel: CarouselNoSnapModel_ = CarouselNoSnapModel_()
) : ModelCollector, CarouselNoSnapModelBuilder by carouselNoSnapModel {
    private val models = mutableListOf<EpoxyModel<*>>()

    override fun add(model: EpoxyModel<*>) {
        models.add(model)

        // Set models list every time a model is added so that it can run debug validations to
        // ensure it is still valid to mutate the carousel model.
        carouselNoSnapModel.models(models)
    }
}

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CarouselNoSnap(context: Context) : Carousel(context) {

    override fun getSnapHelperFactory(): Nothing? = null
}