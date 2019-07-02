package ru.skillbranch.devintencive.models

import ru.skillbranch.devintencive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomeng: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncomeng, date) {
    override fun firmatMessage(): String =
        "id: $id ${from?.firstName} ${if(isIncomeng)"receive" else "sent"} message \"$text\" ${humanizeDiff()} "
}