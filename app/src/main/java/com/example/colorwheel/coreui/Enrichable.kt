package com.example.colorwheel.coreui

interface Enrichable<MODEL : BaseModel> {

    fun enrich(model: MODEL)
}