package techacademy.yuuya.nagafudhi.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Star(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {
    companion object{
        //横幅・高さ
        val STAR_WIDHT = 0.8f
        val STAR_HEIGHT = 0.8f

        //状態(存在している状態と獲得されてなくなった状態）
        val STAR_EXIST = 0
        val STAR_NONE = 1
    }
    var mState : Int = 0

    init {
        setSize(STAR_WIDHT, STAR_HEIGHT)
        mState = STAR_EXIST
    }
    fun get(){
        mState = STAR_NONE
        setAlpha(0f)
    }
}