package sw.sample.designpattern.mvi

sealed class MviIntent{
    object LoadImage : MviIntent()
}