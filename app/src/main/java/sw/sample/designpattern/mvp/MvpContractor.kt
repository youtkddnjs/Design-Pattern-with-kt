package sw.sample.designpattern.mvp

interface MvpContractor {

    interface View{
        fun showImaage(url:String, color: String)

        fun showImageCountText(count: Int)
    }

    interface Presenter{

        fun attachView(view: View)

        fun detachView()

        fun loadRandomImage()

    }
}