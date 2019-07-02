package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage (
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncomeng:Boolean = false,
    val date:Date = Date()
){
    abstract fun firmatMessage():String

    companion object AbstractFactory{
        var lastId = -1
        fun makeMsg(user:User, chat: Chat, date: Date = Date(), type:String, payLoad: Any): BaseMessage{
            lastId++
            return when(type){
                "image" -> ImageMessage("$lastId", user,chat, date = date, image = "$payLoad")
                    else -> TextMessage("$lastId", user,chat, date = date, text = "$payLoad")
            }
        }
    }
}

