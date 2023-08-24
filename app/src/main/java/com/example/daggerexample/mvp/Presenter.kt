package com.example.daggerexample.mvp

class Presenter : Contract.Presenter,Contract.Model.OnFinishedListener {

    var mainView:Contract.View? = null
    lateinit var model:Contract.Model

    constructor(mainView: Contract.View, model: Contract.Model) {
        this.mainView = mainView
        this.model = model
    }


    override fun onButtonClick() {
        mainView?.let { it.showProgress() }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
       mainView = null
    }

    override fun onFinished(string: String?) {
       mainView?.let {
           it.setString(string)
           it.hideProgress()
       }
    }
}