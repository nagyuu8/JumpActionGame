package techacademy.yuuya.nagafudhi.jumpactiongame

import com.badlogic.gdx.graphics.Texture

/**
 * プレイヤーオブジェクトを生成するクラスです。
 */
class Player(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {
    companion object{
        //横幅　高さ
        val PLAYER_WIDTH = 1.0f
        val PLAYER_HEIGHT = 1.0f

        //状態
        val PLAYER_STATE_JUMP = 0
        val PLAYER_STATE_FALL = 1

        //速度
        val PLAYER_JUMP_VELOCITY = 11.0f
        val PLAYER_MOVE_VELOCITY = 20.0f
    }
    //状態を保持する変数
    private var mState : Int

    init {
        setSize(PLAYER_WIDTH, PLAYER_HEIGHT)
        mState =PLAYER_STATE_FALL
    }

    fun update(delta:Float,accelX:Float){
        //重力をプレイヤーの速度に加算し、速度から位置を計算する
        velocity.add(0f,GameScreen.GRAVITY * delta)
        velocity.x = -accelX / 10 * PLAYER_MOVE_VELOCITY
        setPosition(x + velocity.x * delta, y + velocity.y * delta)


        //yの方向の速度が正の時STATEがPLAYER_STATE_JUMP でなければPLYAER_STATE_JUMPにする。
        if(velocity.y >0){
            if(mState != PLAYER_STATE_JUMP){
                mState = PLAYER_STATE_JUMP
            }
        }
        //yの方向の速度が負の時STATEがPLAYER_STATE_JUMP でなければPLYAER_STATE_JUMPにする。
        if (velocity.y < 0){
            if(mState != PLAYER_STATE_FALL){
                mState = PLAYER_STATE_FALL
            }
        }
        //画面の端まで来たら反対側に移動させる。
        if(x + PLAYER_WIDTH /2 < 0){
            x = GameScreen.WORLD_WIDHT - PLAYER_WIDTH/2
        }else if(x + PLAYER_WIDTH /2 > GameScreen.WORLD_WIDHT){
            x = 0f
        }
    }
    fun hitStep(){
        velocity.y = PLAYER_JUMP_VELOCITY
        mState = PLAYER_STATE_JUMP
    }
}