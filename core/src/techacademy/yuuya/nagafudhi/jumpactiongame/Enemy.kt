package techacademy.yuuya.nagafudhi.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int) : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object{
        //横幅・高さ
        val ENEMY_WIDHT = 0.8f
        val ENEMY_HEIGHT = 0.8f

        //状態(存在している状態と獲得されてなくなった状態）
        val  ENEMY_EXIST = 0
        val  ENEMY_NONE = 1
    }
    var mState : Int = 0

    init {
        setSize( ENEMY_WIDHT,  ENEMY_HEIGHT)
        mState =  ENEMY_EXIST
    }
    fun hit(){
        mState =  ENEMY_NONE
        setAlpha(0f)
    }
}