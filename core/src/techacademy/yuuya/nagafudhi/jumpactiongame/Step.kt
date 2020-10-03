package techacademy.yuuya.nagafudhi.jumpactiongame

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture

/**
 * 足場となるStepクラスです。
 *
 *@param type　は動いているか 1,静止時0です、
 */
class Step(type:Int,texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object{
        //横幅・高さ
        val STEP_WIDTH = 2.0f
        val STEP_HEIGHT = 0.5f

        //タイプ（通常と動くタイプ)
        val STEP_TYPE_STATIC = 0
        val STEP_TYPE_MOVEING = 1

        //状態(通常と消えた状態)
        val STEP_STATE_NORMAL = 0
        val STEP_STATE_VANISH = 1

        //速度
        val STEP_VELOSITY = 2.0f
    }
    var mState : Int = 0
    var mType : Int
    init {
        setSize(STEP_WIDTH, STEP_HEIGHT)
        mType= type
        if(mType == STEP_TYPE_MOVEING){
            velocity.x = STEP_VELOSITY
        }
    }
    /**
     * 座標の更新
     * GameScreen renderメソッドより呼ばれて座標の更新を行う。
     * @param deltaTime
     */
    fun update(deltaTime:Float){
        if(mType == STEP_TYPE_MOVEING){
            x += velocity.x * deltaTime

            if(x < STEP_WIDTH /2){
                velocity.x = -velocity.x
                x = STEP_WIDTH
            }
            if(x > GameScreen.WORLD_WIDHT - STEP_WIDTH/2){
                velocity.x = -velocity.x
                x = GameScreen.WORLD_WIDHT - STEP_WIDTH/2
            }
        }
    }

    /**
     * 消える足場
     * 一定確率でプレイヤーが踏んだ時に呼び出される
     */
    fun vanish(){
        mState = STEP_STATE_VANISH
        setAlpha(0f)
        velocity.x = 0f
    }
}